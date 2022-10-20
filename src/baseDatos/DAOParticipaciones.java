package baseDatos;

import aplicacion.Participaciones;
import aplicacion.Usuario;
import java.sql.*;

public class DAOParticipaciones extends AbstractDAO {

    public DAOParticipaciones(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /*OBTENCIÓN DE LAS PARTICIPACIONES DE UN USUARIO*/
    public java.util.List<Participaciones> obtenerParticipaciones(Usuario u) {
        //Variables locales
        java.util.List<Participaciones> partiDisponibles = new java.util.ArrayList<>();
        Participaciones partiActual;
        Connection con;
        PreparedStatement stmParticipacion = null;
        ResultSet rsParticipacion;

        //Acceso a la conexión
        con = this.getConexion();

        try {
            //Preparación string
            stmParticipacion = con.prepareStatement("(select t.usuario, t.empresa, "
                    + "cantidad - (select coalesce(sum(cantidadparticipaciones),0) "
                    + "from tenerparticipaciones as ten, mercado as mer "
                    + "where ten.usuario = mer.usuario "
                    + "and ten.empresa = mer.empresa "
                    + "and ten.empresa= t.empresa "
                    + "and mer.usuario = t.usuario "
                    + "group by t.empresa, t.usuario "
                    + "having sum(cantidadparticipaciones) > 0) as cantidad "
                    + "from tenerparticipaciones as t, mercado as m "
                    + "where t.usuario = m.usuario "
                    + "and t.empresa = m.empresa "
                    + "and (cantidad - (select coalesce(sum(cantidadparticipaciones),0) "
                    + "from tenerparticipaciones as ten, mercado as mer "
                    + "where ten.usuario = mer.usuario "
                    + "and ten.empresa = mer.empresa "
                    + "and ten.empresa= t.empresa "
                    + "and mer.usuario = t.usuario "
                    + "group by t.empresa, t.usuario "
                    + "having sum(cantidadparticipaciones) > 0)) > 0"
                    + "and t.usuario = ?) "
                    + "UNION "
                    + "(select usuario, empresa, cantidad "
                    + "from tenerparticipaciones as t "
                    + "where usuario not in (select ten.usuario "
                    + "from tenerparticipaciones as ten, mercado as mer "
                    + "where ten.usuario = mer.usuario "
                    + "and ten.empresa = mer.empresa "
                    + "and ten.empresa = t.empresa "
                    + "and mer.usuario = t.usuario) "
                    + "and usuario = ? and cantidad > 0) "
                    + "order by usuario");
            stmParticipacion.setString(1, u.getId());
            stmParticipacion.setString(2, u.getId());

            //Ejecución query
            rsParticipacion = stmParticipacion.executeQuery();

            //lectura de resultados
            while (rsParticipacion.next()) {
                partiActual = new Participaciones(rsParticipacion.getString("usuario"), rsParticipacion.getString("empresa"),
                        rsParticipacion.getInt("cantidad"), 0);
                partiDisponibles.add(partiActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmParticipacion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar los cursores");
            }
        }
        return partiDisponibles;
    }

    /*OBTENCIÓN DE LAS PARTICIPACIONES TOTALES QUE ESTÁN EN EL MERCADO*/
    public java.util.List<Participaciones> obtenerTotalEnVenta() {
        //Variables locales
        java.util.List<Participaciones> partiVentas = new java.util.ArrayList<>();
        Participaciones partiActual;
        Connection con;
        PreparedStatement stmParticipacion = null;
        ResultSet rsParticipacion;

        //Acceso a la conexión
        con = this.getConexion();

        try {
            //Preparación de string
            stmParticipacion = con.prepareStatement("select * from mercado order by empresa, precioparticipacion");

            //Ejecución query
            rsParticipacion = stmParticipacion.executeQuery();

            while (rsParticipacion.next()) {
                partiActual = new Participaciones(rsParticipacion.getString("usuario"), rsParticipacion.getString("empresa"),
                        rsParticipacion.getInt("cantidadparticipaciones"), rsParticipacion.getFloat("precioparticipacion"));
                partiActual.setMarcaTemporalVenta(rsParticipacion.getTimestamp("marcaTemporal"));
                partiVentas.add(partiActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());

        } finally {
            try {
                stmParticipacion.close();
            } catch (SQLException exc) {
                System.out.println(exc.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(exc.getMessage());
            }
        }

        return partiVentas;
    }

    /*OBTENCIÓN DE LAS PARTICIPACIONES QUE ESTÁN EN VENTA POR UN USUARIO*/
    public java.util.List<Participaciones> obtenerParticipacionesEnVenta(Usuario u) {
        //Variables locales
        java.util.List<Participaciones> partiVentas = new java.util.ArrayList<>();
        Participaciones partiActual;
        Connection con;
        PreparedStatement stmParticipacion = null;
        ResultSet rsParticipacion;

        //Acceso a la conexión
        con = this.getConexion();

        try {
            //Preparación de string
            stmParticipacion = con.prepareStatement("select * from mercado where usuario = ?");
            stmParticipacion.setString(1, u.getId());

            //Ejecución query
            rsParticipacion = stmParticipacion.executeQuery();

            while (rsParticipacion.next()) {
                partiActual = new Participaciones(rsParticipacion.getString("usuario"), rsParticipacion.getString("empresa"),
                        rsParticipacion.getInt("cantidadparticipaciones"), rsParticipacion.getFloat("precioparticipacion"));
                partiActual.setMarcaTemporalVenta(rsParticipacion.getTimestamp("marcatemporal"));
                partiVentas.add(partiActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());

        } finally {
            try {
                stmParticipacion.close();
            } catch (SQLException exc) {
                System.out.println(exc.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(exc.getMessage());
            }
        }

        return partiVentas;
    }

    /*OBTENCIÓN TOTAL PARTICIPACIONES DE UN USUARIO PARA UNA EMPRESA CONCRETA*/
    public int obtenerNumTotalParticipacionesEmpresa(Usuario u, String empresa) {
        int numParticipaciones = 0;

        Connection con;
        PreparedStatement stmParticipacion = null;
        ResultSet rsParti;

        //Acceso a la conexión
        con = this.getConexion();

        try {
            //Número total de participaciones
            stmParticipacion = con.prepareCall("select coalesce(sum(cantidad),0) as total from tenerparticipaciones where empresa = ? and usuario = ?");
            stmParticipacion.setString(1, empresa);
            stmParticipacion.setString(2, u.getId());
            rsParti = stmParticipacion.executeQuery();

            if (rsParti.next()) {
                numParticipaciones = rsParti.getInt("total");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
        } finally {
            try {
                stmParticipacion.close();
            } catch (SQLException ex) {
                System.out.println("Imposible cerrar cursores");
            }

        }

        return numParticipaciones;
    }

    /*OBTENCIÓN DEL NÚMERO DE PARTICIPACIONES DISPONIBLES PARA LA VENTA DE UNA EMPRESA*/
    public int obtenerNumParticipacionesDisponibles(Usuario u, String empresa) {
        int numParticipaciones = 0;

        Connection con;
        PreparedStatement stmParticipacion = null;
        ResultSet rsParti;

        //Acceso a la conexión
        con = this.getConexion();

        try {
            con.setAutoCommit(false);
            //Número total de participaciones
            stmParticipacion = con.prepareCall("select coalesce(sum(cantidad),0) as total from tenerparticipaciones where empresa = ? and usuario = ?");
            stmParticipacion.setString(1, empresa);
            stmParticipacion.setString(2, u.getId());
            rsParti = stmParticipacion.executeQuery();

            if (rsParti.next()) {
                numParticipaciones = rsParti.getInt("total");
            }

            //fNúmero de participaciones en venta
            stmParticipacion = con.prepareCall("select coalesce(sum(cantidadparticipaciones),0) as total from mercado where empresa = ? and usuario = ?");
            stmParticipacion.setString(1, empresa);
            stmParticipacion.setString(2, u.getId());
            rsParti = stmParticipacion.executeQuery();

            if (rsParti.next()) {
                numParticipaciones -= rsParti.getInt("total");
            }

            //Número de participaciones en pactos
            stmParticipacion = con.prepareCall("select coalesce(sum(cantidad),0) as total from ofertaPacto as op, acuerdoPacto as ap "
                                                + "where op.marcaTemporal = ap.marcaTemporal "
                                                + " and op.comprador = ap.comprador"
                                                + " and op.empresa = ? and ap.vendedor = ?");
            stmParticipacion.setString(1, empresa);
            stmParticipacion.setString(2, u.getId());
            rsParti = stmParticipacion.executeQuery();

            if (rsParti.next()) {
                numParticipaciones -= rsParti.getInt("total");
            }

            if (u instanceof aplicacion.Empresa) {
                //Número total de participaciones bloqueadas
                stmParticipacion = con.prepareCall("select coalesce(sum(partiBloqueadas),0) as total from empresa where nombre = ? and usuario = ?");
                stmParticipacion.setString(1, empresa);
                stmParticipacion.setString(2, u.getId());
                rsParti = stmParticipacion.executeQuery();

                if (rsParti.next()) {
                    numParticipaciones -= rsParti.getInt("total");
                }
            }

            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
                System.out.println(ex.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }
        } finally {
            try {
                con.setAutoCommit(true);
                stmParticipacion.close();
            } catch (SQLException ex) {
                System.out.println("Imposible cerrar cursores");
            }

        }

        return numParticipaciones;
    }

    public void darAlta(String e, int num) {
        Connection con;
        PreparedStatement stmParticipacion = null;
        ResultSet rsParti;
        int numParticipaciones = 0;

        //Acceso a la conexión
        con = this.getConexion();

        try {
            con.setAutoCommit(false);

            // Comprobamos si tiene participaciones propias.
            stmParticipacion = con.prepareStatement("select cantidad "
                    + "from tenerparticipaciones where usuario = empresa and empresa = ?");
            stmParticipacion.setString(1, e);
            rsParti = stmParticipacion.executeQuery();

            //Actualizamos el numero disponibles
            if (rsParti.next()) {
                numParticipaciones = rsParti.getInt("cantidad");
            }

            //Si tiene alguna, sumamos las nuevas a las anteriores.
            if (numParticipaciones > 0) {
                stmParticipacion = con.prepareStatement("update tenerparticipaciones "
                        + "set cantidad = cantidad + ? "
                        + "where usuario = empresa and empresa = ? ");
                stmParticipacion.setInt(1, num);
                stmParticipacion.setString(2, e);
                stmParticipacion.executeUpdate();
            } //Si no, las creamos.
            else {
                stmParticipacion = con.prepareStatement("insert into tenerParticipaciones (usuario, empresa, cantidad) values(?, ?, ?)");
                stmParticipacion.setString(1, e);
                stmParticipacion.setString(2, e);
                stmParticipacion.setInt(3, num);
                stmParticipacion.executeUpdate();
            }

            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
                System.out.println(ex.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex1.getMessage());
            }
        } finally {
            try {
                con.setAutoCommit(true);
                stmParticipacion.close();
            } catch (SQLException ex) {
                System.out.println("Imposible cerrar cursores");
            }

        }
    }

    public boolean darBaja(String e, int num) {
        boolean resultado = true;
        Connection con;
        PreparedStatement stmParticipacion = null;
        ResultSet rsParti;
        int numParticipaciones = 0;

        //Acceso a la conexión
        con = this.getConexion();

        try {
            con.setAutoCommit(false);

            // Comprobamos si tiene participaciones propias.
            stmParticipacion = con.prepareStatement("select cantidad - (coalesce((select sum(cantidadparticipaciones) from mercado where usuario = empresa and usuario = ?), 0) \n" +
                                "+ coalesce((select sum(stacking.cantidad) from stacking where usuario = empresa and usuario = ?),0))\n" +
                                "as cantidad \n" +
                                "from tenerparticipaciones \n" +
                                "where usuario = empresa \n" +
                                "and empresa = ?");
            stmParticipacion.setString(1, e);
            stmParticipacion.setString(2, e);
            stmParticipacion.setString(3, e);
            rsParti = stmParticipacion.executeQuery();

            //Actualizamos el numero que tiene
            if (rsParti.next()) {
                numParticipaciones = rsParti.getInt("cantidad");
            }
            
            System.out.println(numParticipaciones);

            //Si hay suficientes, se actualiza la cantidad
            if (numParticipaciones >= num) {
                stmParticipacion = con.prepareStatement("update tenerparticipaciones "
                        + "set cantidad = cantidad - ? "
                        + "where usuario = empresa and empresa = ?");
                stmParticipacion.setInt(1, num);
                stmParticipacion.setString(2, e);
                stmParticipacion.executeUpdate();

                // Comprobamos si tiene participaciones propias.
                stmParticipacion = con.prepareStatement("select cantidad "
                        + "from tenerparticipaciones where usuario = empresa and empresa = ?");
                stmParticipacion.setString(1, e);
                rsParti = stmParticipacion.executeQuery();

                //Actualizamos el numero que tiene
                if (rsParti.next()) {
                    numParticipaciones = rsParti.getInt("cantidad");
                }
                if (numParticipaciones <= 0) {
                    stmParticipacion = con.prepareStatement("delete from tenerparticipaciones "
                            + "where usuario=empresa and empresa= ?");
                    stmParticipacion.setString(1, e);
                    stmParticipacion.executeUpdate();
                }

                con.commit();
            } //Si no, mandamos un mensaje a VPrincipal para exponer el mensaje de error.
            else {
                resultado = false;
                con.rollback();
            }
        } catch (SQLException ex) {
            try {
                con.rollback();
                System.out.println(ex.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex1.getMessage());
            }
        } finally {
            try {
                con.setAutoCommit(true);
                stmParticipacion.close();
            } catch (SQLException ex) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
}
