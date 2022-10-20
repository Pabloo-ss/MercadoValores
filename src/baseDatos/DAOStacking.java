package baseDatos;

import aplicacion.Stacked;
import aplicacion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOStacking extends AbstractDAO {

    public DAOStacking(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void insertarStacking(Stacked s) {
        Connection con;
        PreparedStatement stmStac = null;
        ResultSet rsStac;
        float interes = 0;
        int cantidadAntigua = 0;

        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            //Primero obtenemos el interes vigente en ese momento
            stmStac = con.prepareStatement("select interes from regulador");
            rsStac = stmStac.executeQuery();
            if (rsStac.next()) {
                interes = rsStac.getFloat("interes");
            }

            //Introducimos en la tabla stacking
            stmStac = con.prepareStatement("insert into stacking values(?,?,?,?,?)");
            stmStac.setTimestamp(1, s.getMarcaTemporal());
            stmStac.setString(2, s.getUsuario());
            stmStac.setString(3, s.getIdEmpresa());
            stmStac.setInt(4, s.getCantidad());
            stmStac.setFloat(5, interes);

            stmStac.executeUpdate();

            //Primero obtenemos las participaciones que tenía antes
            stmStac = con.prepareStatement("select cantidad from tenerParticipaciones where usuario = ? and empresa = ?");
            stmStac.setString(1, s.getUsuario());
            stmStac.setString(2, s.getIdEmpresa());
            rsStac = stmStac.executeQuery();
            if (rsStac.next()) {
                cantidadAntigua = rsStac.getInt("cantidad");
            }

            //Retiramos las participaciones correspondientes
            stmStac = con.prepareStatement("update tenerParticipaciones set cantidad = ? where usuario = ? and empresa = ?");
            stmStac.setInt(1, cantidadAntigua - s.getCantidad());
            stmStac.setString(2, s.getUsuario());
            stmStac.setString(3, s.getIdEmpresa());
            stmStac.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
            }
        } finally {
            try {
                con.setAutoCommit(true);
                stmStac.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }
        }
    }

    public float retirarStacking(Stacked s) {
        Connection con;
        PreparedStatement stmStac = null;
        ResultSet rsStac;
        float precio = 1;
        int dias = 0;
        int cantidadAntigua = 0;
        float res = 0;

        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            //Primero calculamos los dias que han pasado
            stmStac = con.prepareStatement("select (cast(current_timestamp as date) - cast(? as date)) as resultado");
            stmStac.setTimestamp(1, s.getMarcaTemporal());

            rsStac = stmStac.executeQuery();
            if (rsStac.next()) {
                dias = rsStac.getInt("resultado");
            }

            //Luego borramos de la tabla de stacking
            stmStac = con.prepareStatement("delete from stacking where marcaTemporal = ? and usuario = ? and empresa = ?");
            stmStac.setTimestamp(1, s.getMarcaTemporal());
            stmStac.setString(2, s.getUsuario());
            stmStac.setString(3, s.getIdEmpresa());

            stmStac.executeUpdate();

            //Introducimos las participaciones correspondientes
            //Primero comprobamos si ya tiene mas participaciones como esas
            stmStac = con.prepareStatement("select cantidad from tenerParticipaciones where usuario = ? and empresa = ?");
            stmStac.setString(1, s.getUsuario());
            stmStac.setString(2, s.getIdEmpresa());

            rsStac = stmStac.executeQuery();
            if (rsStac.next()) {
                if (!rsStac.wasNull()) {
                    cantidadAntigua = rsStac.getInt("cantidad");
                    //Una vez sabemos la cantidad antigua actualizamos
                    stmStac = con.prepareStatement("update tenerParticipaciones set cantidad = ? where usuario = ? and empresa = ?");
                    stmStac.setInt(1, s.getCantidad() + cantidadAntigua);
                    stmStac.setString(2, s.getUsuario());
                    stmStac.setString(3, s.getIdEmpresa());
                } else { //Si no tenia participaciones se inserta un nuevo registro
                    stmStac = con.prepareStatement("insert into tenerParticipaciones values(?,?,?)");
                    stmStac.setString(1, s.getUsuario());
                    stmStac.setString(2, s.getIdEmpresa());
                    stmStac.setInt(3, s.getCantidad());
                }
            }
            stmStac.executeUpdate();
            //Queda calcular el precio sobre el que se aplicará el interés (Se coge el mas barato)
            stmStac = con.prepareStatement("select precioparticipacion "
                    + "from mercado, tenerParticipaciones "
                    + "where mercado.usuario = tenerParticipaciones.usuario "
                    + "and mercado.empresa = ? "
                    + "order by precioparticipacion asc");
            stmStac.setString(1, s.getIdEmpresa());

            rsStac = stmStac.executeQuery();
            if (rsStac.next()) {
                precio = rsStac.getFloat("precioparticipacion");
            }

            //Por ultimo calculamos la ganancia   
            res = precio * s.getInteres() * dias;

            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
            }
        } finally {
            try {
                con.setAutoCommit(true);
                stmStac.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }
        }
        return res;
    }

    public java.util.List<Stacked> obtenerStacking(Usuario u) {

        java.util.List<Stacked> resultado = new java.util.ArrayList<>();
        Stacked staActual;
        Connection con;
        PreparedStatement stmStac;
        ResultSet rsStac = null;

        con = this.getConexion();
        try {

            stmStac = con.prepareStatement("select s.marcaTemporal, s.usuario, s.empresa, "
                    + "s.cantidad, s.interesStacking, e.nombre  "
                    + "from stacking as s, empresa as e "
                    + "where s.usuario = ? "
                    + "and s.empresa = e.usuario");
            stmStac.setString(1, u.getId());

            rsStac = stmStac.executeQuery();

            while (rsStac.next()) {
                staActual = new Stacked(rsStac.getTimestamp("marcaTemporal"), rsStac.getString("usuario"),
                        rsStac.getString("nombre"), rsStac.getString("empresa"),
                        rsStac.getInt("cantidad"), rsStac.getFloat("interesStacking"));
                resultado.add(staActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                rsStac.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }
}
