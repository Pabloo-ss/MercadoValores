package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class GestionParticipaciones {

    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionParticipaciones(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public java.util.List<Participaciones> obtenerParticipaciones(Usuario u){
        return fbd.obtenerParticipaciones(u);
    }
    
    public java.util.List<Participaciones> obtenerParticipacionesEnVenta(Usuario u){
        return fbd.obtenerParticipacionesEnVenta(u);
    }
    
    public int obtenerNumTotalParticipacionesEmpresa(Usuario u, String empresa) {
        return fbd.obtenerNumTotalParticipacionesEmpresa(u, empresa);
    }
    
    public int obtenerNumParticipacionesDisponiblesEmpresa(Usuario u, String e) {
        return fbd.obtenerNumParticipacionesDisponibles(u, e);
    }
    
    public java.util.List<Participaciones> obtenerTotalEnVenta(){
        return fbd.obtenerTotalEnVenta();
    }
    
    public void darAlta(String e, int num){
        fbd.darAltaPart(e,num);
    }
    
    public boolean darBaja(String e, int num){
        return fbd.darBajaPart(e,num);
    }
    
    
}
