package baseDatos;

import aplicacion.Usuario;
import aplicacion.Empresa;
import aplicacion.OperacionVenta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOOperacionVenta extends AbstractDAO {

    public DAOOperacionVenta(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /*PUESTA EN VENTA DE PARTICIPACIONES*/
    public void puestaVentaParticipaciones(Usuario usuario, String empresa, int num, float precio) {

        Connection con;
        PreparedStatement stm = null;
        ResultSet rs;

        float comision = 0;

        con = this.getConexion();

        try {
            con.setAutoCommit(false);

            stm = con.prepareStatement("select comision from regulador");
            rs = stm.executeQuery();
            if (rs.next()) {
                comision = rs.getFloat("comision");
            } else {
                System.out.println("Nunca debería chegar aquí");
            }

            //Ejecutamos la insercion en la base de datos
            stm = con.prepareStatement("insert into mercado values(?,?, now(),?,?,?)");

            stm.setString(1, usuario.getId());
            stm.setString(2, empresa);
            stm.setFloat(3, comision);
            stm.setInt(4, num);
            stm.setFloat(5, precio);

            stm.executeUpdate();

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
                stm.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void retirarMercado(String idUsuario, java.sql.Timestamp marcaTemporal) {

        Connection con;
        PreparedStatement stm = null;

        con = this.getConexion();

        try {
            stm = con.prepareStatement("delete from mercado where usuario = ? and marcatemporal = ?");
            stm.setString(1, idUsuario);
            stm.setTimestamp(2, marcaTemporal);

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    /*COMPRAR PARTICIPACIONES*/
    public boolean comprarParticipaciones(String usuario, String empresa, int num, float precio) {
        Connection con;
        PreparedStatement stm = null;
        ResultSet rs;
        ResultSet aux;
        float dineroComprador = 0;
        boolean resultado = true;

        int numVenta = 0;
        int count = 0;
        int cantidadActual;

        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            // Se obtiene la cantidad de participaciones disponibles por debajo del precio indicado
            stm = con.prepareStatement("select sum(cantidadparticipaciones) as numVenta from mercado "
                    + "where usuario != ? and empresa = ? and precioparticipacion <= ?");
            stm.setString(1, usuario);
            stm.setString(2, empresa);
            stm.setFloat(3, precio);
            rs = stm.executeQuery();

            if (rs.next()) {
                numVenta = rs.getInt("numVenta");
            } else {
                System.out.println("Nunca debería chegar aquí");
            }

            if (num <= numVenta) {
                // Ordena de menor a mayor precio las participaciones a la venta de dicha empresa por debajo del precio indicado
                stm = con.prepareStatement("select * from mercado where usuario != ? and empresa = ? "
                        + "and precioparticipacion <= ? order by precioparticipacion, marcaTemporal");
                stm.setString(1, usuario);
                stm.setString(2, empresa);
                stm.setFloat(3, precio);
                rs = stm.executeQuery();

                while (rs.next() && count < num) {
                    if ((num - count) < rs.getInt("cantidadparticipaciones")) {
                        stm = con.prepareStatement("update mercado set cantidadparticipaciones = ? where usuario = ? and empresa = ? and marcatemporal = ?");
                        stm.setInt(1, (rs.getInt("cantidadparticipaciones") - (num - count)));
                        stm.setString(2, rs.getString("usuario"));
                        stm.setString(3, rs.getString("empresa"));
                        stm.setTimestamp(4, rs.getTimestamp("marcatemporal"));
                        stm.executeUpdate();
                        cantidadActual = (num - count);
                    } else {
                        stm = con.prepareStatement("delete from mercado where usuario = ? and empresa = ? and marcatemporal = ?");
                        stm.setString(1, rs.getString("usuario"));
                        stm.setString(2, rs.getString("empresa"));
                        stm.setTimestamp(3, rs.getTimestamp("marcatemporal"));
                        stm.executeUpdate();
                        cantidadActual = rs.getInt("cantidadparticipaciones");
                    }

                    // Modificamos las participaciones de la empresa
                    stm = con.prepareStatement("update tenerparticipaciones set cantidad = cantidad - ? where usuario = ? and empresa = ? ");
                    stm.setInt(1, cantidadActual);
                    stm.setString(2, rs.getString("usuario"));
                    stm.setString(3, rs.getString("empresa"));

                    // Comprobamos si la empresa se quedó sin participaciones para borrar su tupla
                    stm = con.prepareStatement("select * from tenerparticipaciones where usuario = ? and empresa = ?");
                    stm.setString(1, rs.getString("usuario"));
                    stm.setString(2, rs.getString("empresa"));
                    aux = stm.executeQuery();
                    if (aux.next()) {
                        if (aux.getInt("cantidad") == 0) {
                            stm = con.prepareStatement("delete from tenerparticipaciones where usuario = ? and empresa = ?");
                            stm.setString(1, rs.getString("usuario"));
                            stm.setString(2, rs.getString("empresa"));
                            stm.executeUpdate();
                        }
                    } else {
                        System.out.println("Nunca debería chegar aquí");
                    }

                    count += cantidadActual;

                    // Se modifican los saldos
                    float dineroRegulador = (float) (cantidadActual * rs.getFloat("precioparticipacion")
                            * ((rs.getFloat("comisionventa") / 100)));
                    dineroComprador += (float) (cantidadActual * rs.getFloat("precioparticipacion"));
                    float dineroVendedor = (float) ((cantidadActual * rs.getFloat("precioparticipacion")) - dineroRegulador);

                    stm = con.prepareStatement("update usuario set saldodisponible = saldodisponible + ? where id = ?");
                    stm.setFloat(1, dineroVendedor);
                    stm.setString(2, rs.getString("usuario"));
                    stm.executeUpdate();

                    stm = con.prepareStatement("update usuario set saldodisponible = saldodisponible + ? where tipousuario = 'Regulador'");
                    stm.setFloat(1, dineroRegulador);
                    stm.executeUpdate();
                }

                // Comprobación de participaciones de la empresa por parte del usuario.
                stm = con.prepareStatement("select exists(select * from tenerparticipaciones where usuario = ? and empresa = ?) as result");
                stm.setString(1, usuario);
                stm.setString(2, empresa);

                rs = stm.executeQuery();
                if (rs.next()) {
                    if (rs.getBoolean("result")) {
                        //El usuario posee participaciones de la empresa, se actualiza su número
                        stm = con.prepareStatement("update tenerparticipaciones set cantidad = cantidad + ? where usuario = ? and empresa = ?");
                        stm.setInt(1, num);
                        stm.setString(2, usuario);
                        stm.setString(3, empresa);
                        stm.executeUpdate();
                    } else {
                        //Si no tiene participaciones de la empresa se insertan en la tabla
                        stm = con.prepareStatement("insert into tenerparticipaciones values(?, ?, ?)");
                        stm.setString(1, usuario);
                        stm.setString(2, empresa);
                        stm.setInt(3, num);
                        stm.executeUpdate();
                    }
                } else {
                    System.out.println("Nunca debería chegar aquí");
                }

                // Por último comprobamos si la compra es posible por el saldo del usuario
                stm = con.prepareStatement("select saldodisponible from usuario where id = ?");
                stm.setString(1, usuario);
                rs = stm.executeQuery();
                if (rs.next()) {
                    if (rs.getFloat("saldodisponible") >= dineroComprador) {
                        // Se actualiza el mismo
                        stm = con.prepareStatement("update usuario set saldodisponible = saldodisponible - ? where id = ?");
                        stm.setFloat(1, dineroComprador);
                        stm.setString(2, usuario);
                        stm.executeUpdate();

                        con.commit();
                    } else {
                        this.getFachadaAplicacion().muestraExcepcion("No tienes saldo suficiente para realizar la compra");
                        resultado = false;
                        con.rollback();
                    }
                } else {
                    System.out.println("Nunca debería chegar aquí");
                }

            } else {
                this.getFachadaAplicacion().muestraExcepcion("No hay participaciones de esta empresa a la venta por debajo\n"
                        + "el valor máximo espeficiado");
                resultado = false;
                con.rollback();
            }

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
                stm.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    //FUNCIONES OBTENCION DE DATOS
    //----------------------------
    public List<OperacionVenta> obtenerOperaciones() {

        Connection con;
        PreparedStatement stm = null;
        ResultSet rs;
        ArrayList<OperacionVenta> operaciones = new ArrayList();

        con = this.getConexion();

        try {
            stm = con.prepareStatement("select * from mercado");
            rs = stm.executeQuery();

            while (rs.next()) {
                operaciones.add(new OperacionVenta(rs.getString("usuario"),
                        rs.getString("empresa"),
                        rs.getTimestamp("marcatemporal"),
                        rs.getFloat("comisionventa"),
                        rs.getInt("cantidadparticipaciones"),
                        rs.getFloat("precioparticipacion")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return operaciones;
    }

    public List<OperacionVenta> obtenerOperacionesEmpresa(Empresa empresa) {

        Connection con;
        PreparedStatement stm = null;
        ResultSet rs;
        ArrayList<OperacionVenta> operaciones = new ArrayList();

        con = this.getConexion();

        try {
            stm = con.prepareStatement("select * from mercado where empresa = ?");
            stm.setString(0, empresa.getId());
            rs = stm.executeQuery();

            while (rs.next()) {
                operaciones.add(new OperacionVenta(rs.getString("usuario"),
                        rs.getString("empresa"),
                        rs.getTimestamp("marcatemporal"),
                        rs.getFloat("comisionventa"),
                        rs.getInt("cantidadparticipaciones"),
                        rs.getFloat("precioparticipacion")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return operaciones;

    }
}
