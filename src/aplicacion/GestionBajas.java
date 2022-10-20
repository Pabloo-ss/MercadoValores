package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class GestionBajas {
    
    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionBajas(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public java.util.List<Baja> obtenerSolicitudesBaja() {
        return fbd.obtenerBajas();
    }
    
    public void confirmarBaja(Baja b) {
        fbd.confirmarBaja(b);
    }
    
    public void rechazarBaja(Baja b) {
        fbd.rechazarBaja(b);
    }
    
    public boolean solicitarBaja(String u) {
        return fbd.solicitarBaja(u);
    }
}
