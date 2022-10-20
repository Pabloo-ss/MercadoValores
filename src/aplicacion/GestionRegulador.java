package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class GestionRegulador {

    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionRegulador(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

}
