package baseDatos;

import aplicacion.Pacto;
import aplicacion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOPactos extends AbstractDAO {

    public DAOPactos(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public void insertarPacto(Pacto p){
        Connection con;
        PreparedStatement stmPacto = null;
        ResultSet rsPacto;
        float comision = 1;

        //Acceso a la conexión
        con = this.getConexion();

        try {
            
            con.setAutoCommit(false);
            
            //Primero obtenemos la comison
            stmPacto = con.prepareStatement("select comision from regulador");
            
            rsPacto = stmPacto.executeQuery();
            if(rsPacto.next())
                comision = rsPacto.getFloat("comision");
                
            //Preparación string
            stmPacto = con.prepareStatement("insert into ofertaPacto values(?,?,?,?,?,?,?)");
            stmPacto.setTimestamp(1, p.getMarcaTemporal());
            stmPacto.setString(2, p.getComprador());
            stmPacto.setString(3, p.getIdEmpresa());
            stmPacto.setInt(4, p.getCantidad());
            stmPacto.setFloat(5, p.getPrecio());
            stmPacto.setTimestamp(6, p.getFechaVenta());
            stmPacto.setFloat(7, comision);

            //Ejecución update
            stmPacto.executeUpdate();

            con.commit();
          
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());            }
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                con.setAutoCommit(true);
                stmPacto.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar los cursores");
            }
        }
    }
    
    public java.util.List<Pacto> buscarPactos(String empresa, Usuario u, boolean mios){
        Pacto pactoActual;
        java.util.ArrayList<Pacto> pactos = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmPacto = null;
        ResultSet rsPacto;

        //Acceso a la conexión
        con = this.getConexion();

        try {
            if(mios){
                //Preparación string
                stmPacto = con.prepareStatement("select op.*, nombre "
                                            + "from ofertaPacto as op, empresa as e "
                                            + "where  op.empresa = e.usuario"
                                            + " and op.comprador = ?"
                                            + " and op.marcaTemporal not in(select ap.marcaTemporal "
                                                                        + "from acuerdoPacto as ap "
                                                                        + "where ap.comprador = op.comprador) "
                                            + "order by op.precio asc");
                stmPacto.setString(1, u.getId());
            }else{
                //Preparación string
                stmPacto = con.prepareStatement("select op.*, nombre "
                                            + "from ofertaPacto as op, empresa as e "
                                            + "where e.nombre like ? "
                                            + " and op.empresa = e.usuario"
                                            + " and op.comprador != ?"
                                            + " and op.marcaTemporal not in(select ap.marcaTemporal "
                                                                        + "from acuerdoPacto as ap "
                                                                        + "where ap.comprador = op.comprador) "
                                            + "order by op.precio asc");
                stmPacto.setString(1, "%"+empresa+"%");
                stmPacto.setString(2, u.getId());

                }
                //Ejecución query
                rsPacto = stmPacto.executeQuery();

                //lectura de resultados
                while (rsPacto.next()) {
                    pactoActual = new Pacto(rsPacto.getTimestamp("marcaTemporal"), rsPacto.getString("comprador"), rsPacto.getString("empresa"), 
                            rsPacto.getString("nombre") ,rsPacto.getInt("cantidad"), rsPacto.getFloat("precio"), rsPacto.getTimestamp("fechaVenta"));
                    pactos.add(pactoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPacto.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar los cursores");
            }
        }
        return pactos;
    }
    
    //Busca los pactos ya acordados de un usuario
    public java.util.List<Pacto> buscarMisPactos(Usuario u){
        Pacto pactoActual;
        java.util.ArrayList<Pacto> pactos = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmPacto = null;
        ResultSet rsPacto;

        //Acceso a la conexión
        con = this.getConexion();

        try {
           //Preparación string
            stmPacto = con.prepareStatement("select op.*, nombre, ap.* "
                                        + "from ofertaPacto as op, empresa as e, acuerdoPacto as ap "
                                        + "where op.empresa = e.usuario "
                                        + " and (op.comprador = ? or ap.vendedor = ?)"
                                        + " and ap.marcaTemporal = op.marcaTemporal"
                                        + " and op.marcaTemporal in(select ap.marcaTemporal "
                                                                    + "from acuerdoPacto as ap "
                                                                    + "where ap.comprador = op.comprador) "
                                        + "order by op.precio asc");
            stmPacto.setString(1, u.getId());
            stmPacto.setString(2, u.getId());

            
            //Ejecución query
            rsPacto = stmPacto.executeQuery();

            //lectura de resultados
            while (rsPacto.next()) {
                pactoActual = new Pacto(rsPacto.getTimestamp("marcaTemporal"), rsPacto.getString("comprador"), rsPacto.getString("vendedor"),
                        rsPacto.getString("empresa"), rsPacto.getString("nombre") ,rsPacto.getInt("cantidad"), rsPacto.getFloat("precio"),
                        rsPacto.getTimestamp("fechaVenta"), 0);
                pactos.add(pactoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPacto.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar los cursores");
            }
        }
        return pactos;
    }
    
    public void aceptarPacto(Pacto p){
        Connection con;
        PreparedStatement stmPacto = null;
        ResultSet rsPacto;

        //Acceso a la conexión
        con = this.getConexion();

        try {
            //Preparación string
            stmPacto = con.prepareStatement("insert into acuerdoPacto values(?,?,?,?)");
            stmPacto.setTimestamp(1, p.getMarcaTemporal());
            stmPacto.setString(2, p.getComprador());
            stmPacto.setString(3, p.getIdEmpresa());
            stmPacto.setString(4, p.getVendedor());
            

            //Ejecución update
            stmPacto.executeUpdate();

          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPacto.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar los cursores");
            }
        }
    }
}
