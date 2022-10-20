package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;


public class GestionStacking {
  
    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionStacking(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public void insertarStacking(Stacked s) {
        fbd.insertarStacking(s);
    }
    
    public float retirarStacking(Stacked s) {
        return fbd.retirarStacking(s);
    }
    
    public java.util.List<Stacked> obtenerStacking(Usuario u) {
        return fbd.obtenerStacking(u);
    }
}
