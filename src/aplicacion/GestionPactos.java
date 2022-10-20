package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;


public class GestionPactos {
    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionPactos(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public void insertarPacto(Pacto p){
        fbd.insertarPacto(p);
    }
    
    public java.util.List<Pacto> buscarPactos(String empresa, Usuario u, boolean mios){
        return fbd.buscarPactos(empresa, u, mios);
    }
    
    public java.util.List<Pacto> buscarMisPactos(Usuario u){
        return fbd.buscarMisPactos(u);
    }
    
    public void aceptarPacto(Pacto p){
        fbd.aceptarPacto(p);
    }
}
