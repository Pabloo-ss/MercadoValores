package baseDatos;

import aplicacion.*;
import java.sql.*;

public class DAOUsuarios extends AbstractDAO {

    //CONSTRUCTOR
    //-----------
    public DAOUsuarios(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //INSERTAR USUARIO
    //---------------
    public void insertarUsuario(Usuario u) {
        Connection con = this.getConexion();
        PreparedStatement stmUsuario = null;

        try {
            stmUsuario = con.prepareStatement("insert into usuario values(?,?,?,?)");
            stmUsuario.setString(1, u.getId());
            stmUsuario.setString(2, u.getClave());
            stmUsuario.setFloat(3, u.getSaldoDisponible());
            stmUsuario.setString(4, u.getTipo().name());
            stmUsuario.executeUpdate();

            //Se tiene que insertar tambien en la tabla de Inversor o Empresa
            if (u instanceof Inversor) {
                Inversor i = (Inversor) u;
                stmUsuario = con.prepareStatement("insert into inversor values(?,?,?,?,?,?,?)");

                stmUsuario.setString(1, i.getId());
                stmUsuario.setString(2, i.getDni());
                stmUsuario.setString(3, i.getNombre());
                stmUsuario.setString(4, i.getApellido1());
                stmUsuario.setString(5, i.getApellido2());
                stmUsuario.setString(6, i.getDireccion());
                stmUsuario.setString(7, i.getTelefono());
                stmUsuario.executeUpdate();
            } else {
                Empresa e = (Empresa) u;
                stmUsuario = con.prepareStatement("insert into empresa values(?,?,?,?,?)");

                stmUsuario.setString(1, e.getId());
                stmUsuario.setString(2, e.getCif());
                stmUsuario.setString(3, e.getNombre());
                stmUsuario.setString(4, e.getDireccion());
                stmUsuario.setString(5, e.getTelefono());
                stmUsuario.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //VALIDAR USUARIO
    //---------------
    public Usuario validarUsuario(String idUsuario, String clave) {

        //Variables locales
        Usuario resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;
        String id;

        //Acceso a la conexion
        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            //Preparacion string
            stmUsuario = con.prepareStatement("select id, clave "
                    + "from usuario "
                    + "where id = ? and clave = ?");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, clave);

            //Ejecucion query
            rsUsuario = stmUsuario.executeQuery();

            //Lectura de resultados
            if (rsUsuario.next()) {
                id = rsUsuario.getString("id");
                resultado = obtenerUsuario(id);
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
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }
        }
        return resultado;
    }

    //ACTUALIZAR USUARIO
    //------------------
    public void actualizarUsuario(Usuario u, String idAntigua) {
        Connection con;
        PreparedStatement stmActualizacion = null;

        con = this.getConexion();

        try {
            con.setAutoCommit(false);

            if (u instanceof Regulador) {
                Regulador r = (Regulador) u;
                stmActualizacion = con.prepareStatement("update regulador "
                        + "set comision = ?, "
                        + "    interes = ? "
                        + "where usuario = ?");

                stmActualizacion.setFloat(1, r.getComisionCompraventa());
                stmActualizacion.setFloat(2, r.getInteresStacking());
                stmActualizacion.setString(3, idAntigua);
                stmActualizacion.executeUpdate();
            } else if (u instanceof Empresa) {
                Empresa e = (Empresa) u;
                stmActualizacion = con.prepareStatement("update empresa "
                        + "set cif = ?, "
                        + "    nombre = ?, "
                        + "    direccion = ?, "
                        + "    telefono = ?, "
                        + "    saldoBloqueado = ? "
                        + "where usuario = ?");

                stmActualizacion.setString(1, e.getCif());
                stmActualizacion.setString(2, e.getNombre());
                stmActualizacion.setString(3, e.getDireccion());
                stmActualizacion.setString(4, e.getTelefono());
                stmActualizacion.setFloat(5, e.getSaldoBloqueado());
                stmActualizacion.setString(6, idAntigua);
                stmActualizacion.executeUpdate();
            } else if (u instanceof Inversor) {
                Inversor i = (Inversor) u;
                stmActualizacion = con.prepareStatement("update inversor "
                        + "set dni = ?, "
                        + "    nombre = ?, "
                        + "    apellido1 = ?, "
                        + "    apellido2 = ?, "
                        + "    direccion = ?, "
                        + "    telefono = ? "
                        + "where usuario = ?");

                stmActualizacion.setString(1, i.getDni());
                stmActualizacion.setString(2, i.getNombre());
                stmActualizacion.setString(3, i.getApellido1());
                stmActualizacion.setString(4, i.getApellido2());
                stmActualizacion.setString(5, i.getDireccion());
                stmActualizacion.setString(6, i.getTelefono());
                stmActualizacion.setString(7, idAntigua);
                stmActualizacion.executeUpdate();
            } else {
                System.out.println("Nunca debería chegar a aquí");
            }

            stmActualizacion = con.prepareStatement("update usuario "
                    + "set id = ?, "
                    + "    clave = ?, "
                    + "    saldoDisponible = ? "
                    + "where id = ?");
            stmActualizacion.setString(1, u.getId());
            stmActualizacion.setString(2, u.getClave());
            stmActualizacion.setFloat(3, u.getSaldoDisponible());
            stmActualizacion.setString(4, idAntigua);
            stmActualizacion.executeUpdate();

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
                stmActualizacion.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }
        }
    }

    public void actualizarSaldo(Usuario u, float saldoNuevo) {
        Connection con;
        PreparedStatement stmActualizacion = null;

        con = this.getConexion();

        try {

            stmActualizacion = con.prepareStatement("update usuario set saldoDisponible = ? where id = ?");
            stmActualizacion.setFloat(1, saldoNuevo);
            stmActualizacion.setString(2, u.getId());
            stmActualizacion.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmActualizacion.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }
        }
    }

    //BUSCAR USUARIOS
    //----------------
    public java.util.List<Usuario> buscarUsuarios(String id) {

        java.util.ArrayList<Usuario> usuarios = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmUsrs = null;
        ResultSet rsUsrs;

        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            //CREACION DE USUARIO
            stmUsrs = con.prepareStatement("select id from usuario "
                    + "where id like ? "
                    + "order by id");
            stmUsrs.setString(1, "%" + id + "%");
            rsUsrs = stmUsrs.executeQuery();

            while (rsUsrs.next()) {
                usuarios.add(this.obtenerUsuario(rsUsrs.getString("id")));
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
                stmUsrs.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return usuarios;
    }

    public java.util.List<Usuario> obtenerEmpresas() {

        java.util.ArrayList<Usuario> Empresas = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmEmprs = null;
        ResultSet rsEmprs;

        con = this.getConexion();
        try {

            stmEmprs = con.prepareStatement("select usuario from empresa order by usuario");
            rsEmprs = stmEmprs.executeQuery();

            while (rsEmprs.next()) {
                Empresas.add(this.obtenerUsuario(rsEmprs.getString("usuario")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEmprs.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return Empresas;
    }
    
    public java.util.List<Usuario> obtenerEmpresasEnMercado() {
        java.util.ArrayList<Usuario> Empresas = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmEmprs = null;
        ResultSet rsEmprs;

        con = this.getConexion();
        try {

            stmEmprs = con.prepareStatement("select distinct empresa from mercado order by empresa");
            rsEmprs = stmEmprs.executeQuery();

            while (rsEmprs.next()) {
                Empresas.add(this.obtenerUsuario(rsEmprs.getString("empresa")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEmprs.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return Empresas;
    }

    public java.util.List<Usuario> obtenerInversores() {

        java.util.ArrayList<Usuario> Inversores = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmInvrs = null;
        ResultSet rsInvrs;

        con = this.getConexion();

        try {

            //CREACION DE USUARIO
            stmInvrs = con.prepareStatement("select usuario from inversor");
            rsInvrs = stmInvrs.executeQuery();

            while (rsInvrs.next()) {
                Inversores.add(this.obtenerUsuario(rsInvrs.getString("usuario")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmInvrs.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return Inversores;
    }

    //FUNCIONES CREACION
    //------------------
    public Usuario obtenerUsuario(String id) {
        Usuario resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            con.setAutoCommit(false);

            //CREACION DE USUARIO
            stmUsuario = con.prepareStatement("select id,clave,saldodisponible,tipousuario from usuario where id = ?");
            stmUsuario.setString(1, id);
            rsUsuario = stmUsuario.executeQuery();

            if (rsUsuario.next()) {

                switch (rsUsuario.getString("tipousuario")) {
                    case "Empresa":
                        resultado = obtenerEmpresa(id, rsUsuario.getString("clave"), rsUsuario.getFloat("saldodisponible"));
                        break;
                    case "Inversor":
                        resultado = obtenerInversor(id, rsUsuario.getString("clave"), rsUsuario.getFloat("saldodisponible"));
                        break;
                    case "Regulador":
                        resultado = obtenerRegulador(id, rsUsuario.getString("clave"), rsUsuario.getFloat("saldodisponible"));
                        break;
                }

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
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    private Empresa obtenerEmpresa(String id, String clave, float saldoDisponible) {

        //Variables locales
        Empresa resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        //Conexion
        con = this.getConexion();

        try {

            //EMPRESA
            stmUsuario = con.prepareStatement("select * from empresa where empresa.usuario = ?");
            stmUsuario.setString(1, id);

            //Query
            rsUsuario = stmUsuario.executeQuery();

            //Obtencion de datos
            if (rsUsuario.next()) {
                resultado = new Empresa(id,
                        clave,
                        saldoDisponible,
                        rsUsuario.getString("cif"),
                        rsUsuario.getString("nombre"),
                        rsUsuario.getString("direccion"),
                        rsUsuario.getString("telefono"),
                        rsUsuario.getFloat("saldoBloqueado"),
                        rsUsuario.getInt("partiBloqueadas"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    public String obtenerEmpresaPorNombre(String nombre) {
        Connection con;
        PreparedStatement stmEmprs = null;
        ResultSet rsEmprs;
        String idEmpresa = null;

        con = this.getConexion();
        try {

            stmEmprs = con.prepareStatement("select usuario from empresa where nombre = ?");
            stmEmprs.setString(1, nombre);
            rsEmprs = stmEmprs.executeQuery();

            if (rsEmprs.next()) {
                idEmpresa = rsEmprs.getString("usuario");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEmprs.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return idEmpresa;
    }

    private Inversor obtenerInversor(String id, String clave, float saldoDisponible) {

        //Variables locales
        Inversor resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        //Conexion
        con = this.getConexion();

        try {
            //EMPRESA
            stmUsuario = con.prepareStatement("select * from inversor where inversor.usuario = ?");
            stmUsuario.setString(1, id);

            //Query
            rsUsuario = stmUsuario.executeQuery();

            //Obtencion de datos
            if (rsUsuario.next()) {
                resultado = new Inversor(id,
                        clave,
                        saldoDisponible,
                        rsUsuario.getString("dni"),
                        rsUsuario.getString("nombre"),
                        rsUsuario.getString("apellido1"),
                        rsUsuario.getString("apellido2"),
                        rsUsuario.getString("direccion"),
                        rsUsuario.getString("telefono"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;

    }

    private Regulador obtenerRegulador(String id, String clave, float saldoDisponible) {

        //Variables locales
        Regulador resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        //Conexion
        con = this.getConexion();

        try {

            //EMPRESA
            stmUsuario = con.prepareStatement("select * from regulador where regulador.usuario = ?");
            stmUsuario.setString(1, id);

            //Query
            rsUsuario = stmUsuario.executeQuery();

            //Obtencion de datos
            if (rsUsuario.next()) {
                resultado = new Regulador(id,
                        clave,
                        saldoDisponible,
                        rsUsuario.getFloat("comision"),
                        rsUsuario.getFloat("interes"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    public float obtenerComisionActual() {
        float resultado = 0;
        Connection con;
        PreparedStatement stmComision = null;
        ResultSet rsComision;

        con = this.getConexion();
        try {
            stmComision = con.prepareStatement("select comision from regulador");
            rsComision = stmComision.executeQuery();
            if (rsComision.next()) {
                resultado = rsComision.getFloat("comision");
            } else {
                System.out.println("Nunca debería chegar a aquí");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmComision.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }
    
    public float obtenerInteresActual() {
        float resultado = 0;
        Connection con;
        PreparedStatement stmInteres = null;
        ResultSet rsInteres;

        con = this.getConexion();
        try {
            stmInteres = con.prepareStatement("select interes from regulador");
            rsInteres = stmInteres.executeQuery();
            if (rsInteres.next()) {
                resultado = rsInteres.getFloat("interes");
            } else {
                System.out.println("Nunca debería chegar a aquí");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmInteres.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }
}
