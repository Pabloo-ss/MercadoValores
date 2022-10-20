package baseDatos;

import aplicacion.Baja;
import java.sql.*;

public class DAOBajas extends AbstractDAO {

    //CONSTRUCTOR
    //-----------
    public DAOBajas(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //OBTENER BAJA/S
    //--------------
    public java.util.List<Baja> obtenerBajas() {
        java.util.List<Baja> resultado = new java.util.ArrayList<>();
        Baja bajaActual;
        Connection con;
        PreparedStatement stmBaja = null;
        ResultSet rsBajas;

        con = this.getConexion();
        try {
            stmBaja = con.prepareStatement("select b.usuario, b.marcatemporal, sum(t.cantidad) as numPartTotal "
                    + "from baja as b left join tenerparticipaciones as t on b.usuario = t.usuario "
                    + "group by b.usuario, b.marcatemporal "
                    + "order by b.marcaTemporal");
            rsBajas = stmBaja.executeQuery();

            while (rsBajas.next()) {
                bajaActual = new Baja(this.getFachadaAplicacion().obtenerUsuario(rsBajas.getString("usuario")),
                        rsBajas.getTimestamp("marcatemporal"),
                        rsBajas.getInt("numPartTotal"));
                resultado.add(bajaActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBaja.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public Baja obtenerBaja(String usuario) {
        Baja resultado = null;
        Connection con;
        PreparedStatement stmBaja = null;
        ResultSet rsBaja;

        con = this.getConexion();
        try {
            stmBaja = con.prepareStatement("select b.usuario, b.marcatemporal, sum(t.cantidad) as numPartTotal "
                    + "from baja as b left join tenerparticipaciones as t on b.usuario = t.usuario "
                    + "where b.usuario = ? "
                    + "group by b.usuario, b.marcatemporal");
            stmBaja.setString(1, usuario);
            rsBaja = stmBaja.executeQuery();

            resultado = new Baja(this.getFachadaAplicacion().obtenerUsuario(rsBaja.getString("usuario")),
                    rsBaja.getTimestamp("marcatemporal"),
                    rsBaja.getInt("numPartTotal"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBaja.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    //SOLICITAR BAJA
    //--------------
    public boolean solicitarBaja(String usuario) {
        Connection con;
        PreparedStatement stmBaja = null;
        ResultSet rsCheck;
        boolean resultado = false;

        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            stmBaja = con.prepareStatement("select * from baja where usuario = ?");
            stmBaja.setString(1, usuario);
            rsCheck = stmBaja.executeQuery();

            if (rsCheck.next()) {
                this.getFachadaAplicacion().muestraExcepcion("Ya has solicitado la baja anteriormente.\nEspera a que el regulador la procese");
            } else {
                stmBaja = con.prepareStatement("insert into baja(usuario,marcatemporal) values(?,now())");
                stmBaja.setString(1, usuario);
                stmBaja.executeUpdate();
                resultado = true;
            }

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
                stmBaja.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    //VALIDAR BAJA
    //------------
    public void validarBaja(String usuario) {
        Connection con;
        PreparedStatement stmBaja = null;

        con = this.getConexion();
        try {
            stmBaja = con.prepareStatement("delete from usuario where id = ?");
            stmBaja.setString(1, usuario);
            stmBaja.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBaja.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //BORRAR BAJA
    //------------
    public void borrarBaja(Baja b) {
        Connection con;
        PreparedStatement stmBaja = null;

        con = this.getConexion();
        try {
            stmBaja = con.prepareStatement("delete from baja where usuario = ?");
            stmBaja.setString(1, b.getUsuario().getId());
            stmBaja.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stmBaja.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}
