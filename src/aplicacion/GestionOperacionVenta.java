package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class GestionOperacionVenta {

    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionOperacionVenta(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void puestaVentaParticipaciones(Usuario usuario, String empresa, int num, float precio) {
        fbd.puestaVentaParticipaciones(usuario, empresa, num, precio);
    }
    
    public boolean comprarParticipaciones(String usuario, String empresa, int num, float precio) {
        return fbd.comprarParticipaciones(usuario, empresa, num, precio);
    }
    
     public void retirarMercado(String idUsuario, java.sql.Timestamp marcaTemporal) {
        fbd.retirarMercado(idUsuario, marcaTemporal);
    }
}
