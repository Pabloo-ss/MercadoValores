package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class GestionPrerregistros {
    
    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    //CONSTRUCTOR
    //-----------
    public GestionPrerregistros(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    //OBTENER TODOS PREREGISTROS
    //--------------------------
    public java.util.List<Prerregistro> obtenerSolicitudesPrerregistro() {
        return fbd.obtenerPrerregistros();
    }
    
    //RECHAZA UN PRERREGISTRO
    //--------------------------
    public void rechazarPrerregistro(Prerregistro p) {
        fbd.rechazarPrerregistro(p);
    }
    
    //CONFIRMA UN PRERREGISTRO
    //--------------------------
    public void confirmarPrerregistro(Prerregistro p){
        fbd.confirmarPrerregistro(p);
    }
    
    public boolean insertarPrerregistro(Prerregistro p) {
        return fbd.insertarPrerregistro(p);
    }
}