package gui;

import aplicacion.Regulador;
import aplicacion.Usuario;

public class FachadaGui {

    private final aplicacion.FachadaAplicacion fa;
    private java.awt.Frame vp;

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = null;
    }

    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va  = new VAviso(vp, true, txtExcepcion);
        va.setVisible(true);
    }

    public void iniciarAutentificacion() {
        vp = new VAutentificacion(fa);
        vp.setVisible(true);
    }
    
    public void cerrarSesion() {
        vp.dispose();
        iniciarAutentificacion();
    }
    
    public void iniciarPrerregistro() {
        VPrerregistro vpr;
        
        vpr = new VPrerregistro(vp, true, fa);
        vpr.setVisible(true);
    }
    
    public void iniciarRegulador(Regulador r) {
        vp.dispose();
        vp = new VRegulador(fa, r);
        vp.setVisible(true);
    }
    
    public void iniciarUsuarioNormal(Usuario u) {
        vp.dispose();
        vp = new VPrincipal(fa, u);
        vp.setVisible(true);
    }
    
    public void iniciarPagos(Usuario u) {
        VPagos vpa;
        
        vpa = new VPagos(vp, true, fa, u);
        vpa.setVisible(true);
    }
    
    public void iniciarMercado(Usuario u) {
        VMercado vm;
        
        vm = new VMercado(vp, true, fa, u);
        vm.setVisible(true);
    }
    
    public void iniciarStacking(Usuario u) {
        VStacking vs;
        
        vs = new VStacking(vp, true, fa, u);
        vs.setVisible(true);
    }
    
    public void iniciarPactos(Usuario u) {
        VPactos vpac;
        
        vpac = new VPactos(vp, true, fa, u);
        vpac.setVisible(true);
    }
}
