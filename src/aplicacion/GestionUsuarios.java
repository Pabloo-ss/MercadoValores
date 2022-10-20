package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionUsuarios {

    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public Usuario comprobarAutentificacion(String idUsuario, String clave) {
        return fbd.validarUsuario(idUsuario, clave);
    }
    
    public void actualizarDatosUsuario(Usuario u, String idAntigua) {
        fbd.actualizarUsuario(u, idAntigua);
    }
    
    public void actualizarSaldo(Usuario u, float saldoNuevo) {
        fbd.actualizarSaldo(u, saldoNuevo);
    }
    
    public java.util.List<Usuario> buscarUsuarios(String id){
        return fbd.buscarUsuarios(id);
    }
    
    public Usuario obtenerUsuario(String id){
        return fbd.obtenerUsuario(id);
    }
    
    public java.util.List<Usuario> obtenerEmpresas() {
        return fbd.obtenerEmpresas();
    }
    
    public java.util.List<Usuario> obtenerEmpresasEnMercado() {
        return fbd.obtenerEmpresasEnMercado();
    }
    
    public String obtenerEmpresaPorNombre(String nombre) {
        return fbd.obtenerEmpresaPorNombre(nombre);
    }
    
    public float obtenerComisionActual() {
        return fbd.obtenerComisionActual();
    }
    
    public float obtenerInteresActual() {
        return fbd.obtenerInteresActual();
    }
    
    public void insertarUsuario(Usuario u){
        fbd.insertarUsuario(u);
    }
}
