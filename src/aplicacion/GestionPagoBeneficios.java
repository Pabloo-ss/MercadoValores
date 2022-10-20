package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class GestionPagoBeneficios {
    
    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionPagoBeneficios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public java.util.List<PagoBeneficios> buscarPagosBeneficios(String idEmpresa) {
        return fbd.buscarPagosBeneficios(idEmpresa);
    }
    
    public boolean pagarBeneficios(PagoBeneficios pb) {
        return fbd.pagarBeneficios(pb);
    }
    
    public boolean anunciarPago(PagoBeneficios pb) {
        return fbd.anunciarPago(pb);
    }
    
    public void darBajaAnuncio(PagoBeneficios pb) {
        fbd.borrarPagoBeneficios(pb);
    }
}
