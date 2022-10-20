package baseDatos;

import aplicacion.Empresa;
import aplicacion.Inversor;
import aplicacion.Prerregistro;
import java.sql.*;

public class DAOPrerregistros extends AbstractDAO {

    //CONSTRUCTOR
    //-----------
    public DAOPrerregistros(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //OBTENER PREREGISTROS
    //--------------------
    public java.util.List<Prerregistro> obtenerPrerregistros() {
        java.sql.Timestamp mtActual = null;
        Inversor iActual = null;
        Empresa eActual = null;
        String datoActual[];
        java.util.List<Prerregistro> resultado = new java.util.ArrayList<>();
        Prerregistro preActual = null;
        Connection con;
        PreparedStatement stmPre = null;
        ResultSet rsPre;

        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            stmPre = con.prepareStatement("select marcaTemporal, id, clave, tipoUsuario, dato "
                    + "from prerregistro, datos "
                    + "where prerregistro.marcaTemporal = datos.marcaTemporalPrerregistro "
                    + "order by marcaTemporal");
            rsPre = stmPre.executeQuery();

            while (rsPre.next()) {
                if (mtActual == null) {
                    mtActual = rsPre.getTimestamp("marcaTemporal");
                    preActual = new Prerregistro(null, rsPre.getString("tipoUsuario"), rsPre.getTimestamp("marcaTemporal"));
                    iActual = new Inversor(rsPre.getString("id"), rsPre.getString("clave"), 0);
                    eActual = new Empresa(rsPre.getString("id"), rsPre.getString("clave"), 0);
                }

                if (!rsPre.getTimestamp("marcaTemporal").toString().equals(mtActual.toString())) {
                    switch (preActual.getTipo()) {
                        case "Inversor":
                            preActual.setUsuario(iActual);
                            break;
                        case "Empresa":
                            preActual.setUsuario(eActual);
                            break;
                        default:
                            System.out.println("Nunca debería chegar a aquí");
                            break;
                    }

                    resultado.add(preActual);

                    mtActual = rsPre.getTimestamp("marcaTemporal");
                    preActual = new Prerregistro(null, rsPre.getString("tipoUsuario"), rsPre.getTimestamp("marcaTemporal"));
                    iActual = new Inversor(rsPre.getString("id"), rsPre.getString("clave"), 0);
                    eActual = new Empresa(rsPre.getString("id"), rsPre.getString("clave"), 0);
                }

                switch (preActual.getTipo()) {
                    case "Inversor":
                        datoActual = rsPre.getString("dato").split(":", -1);

                        if (datoActual.length != 2) {
                            this.getFachadaAplicacion().muestraExcepcion("Error en el formato de los datos de los prerregistros");
                            break;
                        }

                        switch (datoActual[0]) {
                            case "dni":
                                iActual.setDni(datoActual[1]);
                                break;
                            case "nombre":
                                iActual.setNombre(datoActual[1]);
                                break;
                            case "ap1":
                                iActual.setApellido1(datoActual[1]);
                                break;
                            case "ap2":
                                iActual.setApellido2(datoActual[1]);
                                break;
                            case "direccion":
                                iActual.setDireccion(datoActual[1]);
                                break;
                            case "tlf":
                                iActual.setTelefono(datoActual[1]);
                                break;
                        }

                        break;
                    case "Empresa":
                        datoActual = rsPre.getString("dato").split(":", -1);

                        if (datoActual.length != 2) {
                            this.getFachadaAplicacion().muestraExcepcion("Error en el formato de los datos de los prerregistros");
                            break;
                        }

                        switch (datoActual[0]) {
                            case "cif":
                                eActual.setCif(datoActual[1]);
                                break;
                            case "nombre":
                                eActual.setNombre(datoActual[1]);
                                break;
                            case "direccion":
                                eActual.setDireccion(datoActual[1]);
                                break;
                            case "tlf":
                                eActual.setTelefono(datoActual[1]);
                                break;
                        }

                        break;
                    default:
                        System.out.println("Nunca debería chegar a aquí");
                        break;
                }
            }

            if (mtActual != null) {
                switch (preActual.getTipo()) {
                    case "Inversor":
                        preActual.setUsuario(iActual);
                        break;
                    case "Empresa":
                        preActual.setUsuario(eActual);
                        break;
                    default:
                        System.out.println("Nunca debería chegar a aquí");
                        break;
                }

                resultado.add(preActual);
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
                stmPre.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    //CONFIRMAR PRERREGISTRO
    //--------------------
    public void confirmarPrerregistro(Prerregistro p) {
        Connection con;
        PreparedStatement stmPre = null;

        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            stmPre = con.prepareStatement("delete from datos where marcaTemporalPrerregistro = ?");
            stmPre.setTimestamp(1, p.getMarcaTemporal());
            stmPre.executeUpdate();

            stmPre = con.prepareStatement("delete from prerregistro where marcaTemporal = ?");
            stmPre.setTimestamp(1, p.getMarcaTemporal());
            stmPre.executeUpdate();

            this.getFachadaAplicacion().insertarUsuario(p.getUsuario());

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
                stmPre.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

    }

    //BORRAR PRERREGISTRO
    //--------------------
    public void borrarPrerregistro(Prerregistro p) {
        Connection con;
        PreparedStatement stmPre = null;

        con = this.getConexion();

        try {
            con.setAutoCommit(false);
            stmPre = con.prepareStatement("delete from datos where marcaTemporalPrerregistro = ?");
            stmPre.setTimestamp(1, p.getMarcaTemporal());
            stmPre.executeUpdate();

            stmPre = con.prepareStatement("delete from prerregistro where marcaTemporal = ?");
            stmPre.setTimestamp(1, p.getMarcaTemporal());
            stmPre.executeUpdate();

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
                stmPre.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

    }

    public boolean insertarPrerregistro(Prerregistro p) {
        Connection con;
        PreparedStatement stmPre = null;
        boolean resultado = true;

        con = this.getConexion();

        try {
            if (this.getFachadaAplicacion().obtenerUsuario(p.getUsuario().getId()) == null) {
                con.setAutoCommit(false);

                stmPre = con.prepareStatement("insert into prerregistro(marcaTemporal, id, clave, tipoUsuario) "
                        + "values(?, ?, ?, ?)");
                stmPre.setTimestamp(1, p.getMarcaTemporal());
                stmPre.setString(2, p.getUsuario().getId());
                stmPre.setString(3, p.getUsuario().getClave());
                if (p.getUsuario() instanceof Empresa) {
                    stmPre.setString(4, "Empresa");
                } else if (p.getUsuario() instanceof Inversor) {
                    stmPre.setString(4, "Inversor");
                } else {
                    System.out.println("Nunca debería chegar aquí");
                }
                stmPre.executeUpdate();

                stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                stmPre.setTimestamp(1, p.getMarcaTemporal());
                stmPre.setString(2, "id:" + p.getUsuario().getId());
                stmPre.executeUpdate();

                if (p.getUsuario() instanceof Empresa) {
                    Empresa e = (Empresa) p.getUsuario();

                    stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                    stmPre.setTimestamp(1, p.getMarcaTemporal());
                    stmPre.setString(2, "cif:" + e.getCif());
                    stmPre.executeUpdate();

                    stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                    stmPre.setTimestamp(1, p.getMarcaTemporal());
                    stmPre.setString(2, "nombre:" + e.getNombre());
                    stmPre.executeUpdate();

                    stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                    stmPre.setTimestamp(1, p.getMarcaTemporal());
                    stmPre.setString(2, "direccion:" + e.getDireccion());
                    stmPre.executeUpdate();

                    stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                    stmPre.setTimestamp(1, p.getMarcaTemporal());
                    stmPre.setString(2, "tlf:" + e.getTelefono());
                    stmPre.executeUpdate();
                } else if (p.getUsuario() instanceof Inversor) {
                    Inversor i = (Inversor) p.getUsuario();

                    stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                    stmPre.setTimestamp(1, p.getMarcaTemporal());
                    stmPre.setString(2, "dni:" + i.getDni());
                    stmPre.executeUpdate();

                    stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                    stmPre.setTimestamp(1, p.getMarcaTemporal());
                    stmPre.setString(2, "nombre:" + i.getNombre());
                    stmPre.executeUpdate();

                    stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                    stmPre.setTimestamp(1, p.getMarcaTemporal());
                    stmPre.setString(2, "ap1:" + i.getApellido1());
                    stmPre.executeUpdate();

                    stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                    stmPre.setTimestamp(1, p.getMarcaTemporal());
                    stmPre.setString(2, "ap2:" + i.getApellido2());
                    stmPre.executeUpdate();

                    stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                    stmPre.setTimestamp(1, p.getMarcaTemporal());
                    stmPre.setString(2, "direccion:" + i.getDireccion());
                    stmPre.executeUpdate();

                    stmPre = con.prepareStatement("insert into datos(marcaTemporalPrerregistro, dato) values(?,?)");
                    stmPre.setTimestamp(1, p.getMarcaTemporal());
                    stmPre.setString(2, "tlf:" + i.getTelefono());
                    stmPre.executeUpdate();

                } else {
                    System.out.println("Nunca debería chegar aquí");
                }

                con.commit();
            } else {
                this.getFachadaAplicacion().muestraExcepcion("El ID introducido ya está en uso");
                resultado = false;
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
                con.setAutoCommit(true);
                if (stmPre != null) {
                    stmPre.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        
        return resultado;
    }
}
