package baseDatos;

import aplicacion.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FachadaBaseDatos {

    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOOperacionVenta daoOperacionVenta;
    private DAOParticipaciones daoParticipaciones;
    private DAOBajas daoBajas;
    private DAOPrerregistros daoPrerregistros;
    private DAOPagosBeneficios daoPagosBeneficios;
    private DAOStacking daoStacking;
    private DAOPactos daoPactos;

    //CONSTRUCTOR
    //-----------
    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {
        Properties configuracion = new Properties();
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoOperacionVenta = new DAOOperacionVenta(conexion, fa);
            daoParticipaciones = new DAOParticipaciones(conexion, fa);
            daoBajas = new DAOBajas(conexion, fa);
            daoPrerregistros = new DAOPrerregistros(conexion, fa);
            daoPagosBeneficios = new DAOPagosBeneficios(conexion, fa);
            daoStacking = new DAOStacking(conexion, fa);
            daoPactos = new DAOPactos(conexion, fa);

        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException | java.sql.SQLException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        }

    }

    //FUNCIONES USUARIO
    //-----------------
    public void insertarUsuario(Usuario u) {
        daoUsuarios.insertarUsuario(u);
    }

    public Usuario validarUsuario(String idUsuario, String clave) {
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }

    public void actualizarUsuario(Usuario u, String idAntigua) {
        daoUsuarios.actualizarUsuario(u, idAntigua);
    }

    public void actualizarSaldo(Usuario u, float saldoNuevo) {
        daoUsuarios.actualizarSaldo(u, saldoNuevo);
    }

    public java.util.List<Usuario> buscarUsuarios(String id) {
        return daoUsuarios.buscarUsuarios(id);
    }

    public Usuario obtenerUsuario(String id) {
        return daoUsuarios.obtenerUsuario(id);
    }

    public java.util.List<Usuario> obtenerEmpresas() {
        return daoUsuarios.obtenerEmpresas();
    }
    
    public java.util.List<Usuario> obtenerEmpresasEnMercado() {
        return daoUsuarios.obtenerEmpresasEnMercado();
    }

    public String obtenerEmpresaPorNombre(String nombre) {
        return daoUsuarios.obtenerEmpresaPorNombre(nombre);
    }

    public float obtenerComisionActual() {
        return daoUsuarios.obtenerComisionActual();
    }

    public float obtenerInteresActual() {
        return daoUsuarios.obtenerInteresActual();
    }

    //FUNCIONES BAJAS
    //---------------
    public java.util.List<Baja> obtenerBajas() {
        return daoBajas.obtenerBajas();
    }

    public void confirmarBaja(Baja b) {
        daoBajas.validarBaja(b.getUsuario().getId());
    }

    public void rechazarBaja(Baja b) {
        daoBajas.borrarBaja(b);
    }

    public boolean solicitarBaja(String u) {
        return daoBajas.solicitarBaja(u);
    }

    //FUNCIONES PREREGISTRO
    //---------------------
    public java.util.List<Prerregistro> obtenerPrerregistros() {
        return daoPrerregistros.obtenerPrerregistros();
    }

    public void confirmarPrerregistro(Prerregistro p) {
        daoPrerregistros.confirmarPrerregistro(p);
    }

    public void rechazarPrerregistro(Prerregistro p) {
        daoPrerregistros.borrarPrerregistro(p);
    }

    public boolean insertarPrerregistro(Prerregistro p) {
        return daoPrerregistros.insertarPrerregistro(p);
    }

    //FUNCIONES PAGOS BENEFICIO
    //-------------------------
    public boolean pagarBeneficios(PagoBeneficios pb) {
        return daoPagosBeneficios.pagarBeneficios(pb);
    }

    public boolean anunciarPago(PagoBeneficios pb) {
        return daoPagosBeneficios.anunciarPago(pb);
    }

    public void borrarPagoBeneficios(PagoBeneficios pb) {
        daoPagosBeneficios.borrarPagoBeneficios(pb);
    }

    public java.util.List<PagoBeneficios> buscarPagosBeneficios(String idEmpresa) {
        return daoPagosBeneficios.buscarPagosBeneficios(idEmpresa);
    }

    //FUNCIONES PARTICIPACIONES
    //---------------------
    public void darAltaPart(String e, int num) {
        daoParticipaciones.darAlta(e, num);
    }

    public boolean darBajaPart(String e, int num) {
        return daoParticipaciones.darBaja(e, num);
    }

    public java.util.List<Participaciones> obtenerParticipaciones(Usuario u) {
        return daoParticipaciones.obtenerParticipaciones(u);
    }

    public java.util.List<Participaciones> obtenerParticipacionesEnVenta(Usuario u) {
        return daoParticipaciones.obtenerParticipacionesEnVenta(u);
    }
    
    public int obtenerNumTotalParticipacionesEmpresa(Usuario u, String empresa) {
        return daoParticipaciones.obtenerNumTotalParticipacionesEmpresa(u, empresa);
    }

    public int obtenerNumParticipacionesDisponibles(Usuario u, String e) {
        return daoParticipaciones.obtenerNumParticipacionesDisponibles(u, e);
    }

    //FUNCIONES OPERACIONES VENTA
    //---------------------
    public void puestaVentaParticipaciones(Usuario usuario, String empresa, int num, float precio) {
        daoOperacionVenta.puestaVentaParticipaciones(usuario, empresa, num, precio);
    }

    public boolean comprarParticipaciones(String usuario, String empresa, int num, float precio) {
        return daoOperacionVenta.comprarParticipaciones(usuario, empresa, num, precio);
    }

    public void retirarMercado(String idUsuario, java.sql.Timestamp marcaTemporal) {
        daoOperacionVenta.retirarMercado(idUsuario, marcaTemporal);
    }

    //FUNCIONES STACKING
    //---------------------
    public void insertarStacking(Stacked s) {
        daoStacking.insertarStacking(s);
    }

    public float retirarStacking(Stacked s) {
        return daoStacking.retirarStacking(s);
    }

    public java.util.List<Stacked> obtenerStacking(Usuario u) {
        return daoStacking.obtenerStacking(u);
    }

    public java.util.List<Participaciones> obtenerTotalEnVenta() {
        return daoParticipaciones.obtenerTotalEnVenta();
    }

    //FUNCIONES PACTOS
    //---------------
    public void insertarPacto(Pacto p) {
        daoPactos.insertarPacto(p);
    }

    public java.util.List<Pacto> buscarPactos(String empresa, Usuario u, boolean mios) {
        return daoPactos.buscarPactos(empresa, u, mios);
    }
    
    public java.util.List<Pacto> buscarMisPactos(Usuario u){
        return daoPactos.buscarMisPactos(u);
    }

    public void aceptarPacto(Pacto p) {
        daoPactos.aceptarPacto(p);
    }
}
