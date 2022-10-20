package aplicacion;

public class FachadaAplicacion {

    //VARAIBLES
    //---------
    private final gui.FachadaGui fgui;
    private final baseDatos.FachadaBaseDatos fbd;
    private final GestionUsuarios gu;
    private final GestionOperacionVenta gov;
    private final GestionParticipaciones gp;
    private final GestionBajas gb;
    private final GestionPrerregistros gpre;
    private final GestionPagoBeneficios gpb;
    private final GestionStacking gs;
    private final GestionPactos gpac;

    //CONSTRUCTOR
    //-----------
    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        gu = new GestionUsuarios(fgui, fbd);
        gov = new GestionOperacionVenta(fgui, fbd);
        gp = new GestionParticipaciones(fgui, fbd);
        gb = new GestionBajas(fgui, fbd);
        gpre = new GestionPrerregistros(fgui, fbd);
        gpb = new GestionPagoBeneficios(fgui, fbd);
        gs = new GestionStacking(fgui, fbd);
        gpac = new GestionPactos(fgui, fbd);
    }

    //MAIN
    //----
    public static void main(String args[]) {
        FachadaAplicacion fa;

        fa = new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    //FUNCION EXCEPCIONES
    //-------------------
    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

    //FUNCION AUTENTIFICACION
    //-----------------------
    public Usuario comprobarAutentificacion(String idUsuario, String clave) {
        return gu.comprobarAutentificacion(idUsuario, clave);
    }

    //FUNCIONES DE INTERFAZ
    //------------------------
    public void iniciaInterfazUsuario() {
        fgui.iniciarAutentificacion();
    }

    public void cerrarSesion() {
        fgui.cerrarSesion();
    }

    public void iniciarPrerregistro() {
        fgui.iniciarPrerregistro();
    }

    public void iniciarRegulador(Regulador r) {
        fgui.iniciarRegulador(r);
    }

    public void iniciarUsuarioNormal(Usuario u) {
        fgui.iniciarUsuarioNormal(u);
    }

    public void iniciarPagos(Usuario u) {
        fgui.iniciarPagos(u);
    }

    public void iniciarMercado(Usuario u) {
        fgui.iniciarMercado(u);
    }

    public void iniciarStacking(Usuario u) {
        fgui.iniciarStacking(u);
    }

    public void iniciarPactos(Usuario u) {
        fgui.iniciarPactos(u);
    }

    //FUNCIONES USUARIO
    //-------------------------
    public void insertarUsuario(Usuario u) {
        gu.insertarUsuario(u);
    }

    public void actualizarDatosUsuario(Usuario u, String idAntigua) {
        gu.actualizarDatosUsuario(u, idAntigua);
    }

    public void actualizarSaldo(Usuario u, float saldoNuevo) {
        gu.actualizarSaldo(u, saldoNuevo);
    }

    public java.util.List<Usuario> buscarUsuarios(String id) {
        return gu.buscarUsuarios(id);
    }

    public Usuario obtenerUsuario(String id) {
        return gu.obtenerUsuario(id);
    }

    public java.util.List<Usuario> obtenerEmpresas() {
        return gu.obtenerEmpresas();
    }

    public java.util.List<Usuario> obtenerEmpresasEnMercado() {
        return gu.obtenerEmpresasEnMercado();
    }

    public String obtenerEmpresaPorNombre(String nombre) {
        return gu.obtenerEmpresaPorNombre(nombre);
    }

    public float obtenerComisionActual() {
        return gu.obtenerComisionActual();
    }

    public float obtenerInteresActual() {
        return gu.obtenerInteresActual();
    }

    //FUNCIONES BAJA
    //-------------------------
    public boolean solicitarBaja(Usuario u) {
        return gb.solicitarBaja(u.getId());
    }

    public void confirmarBaja(Baja b) {
        gb.confirmarBaja(b);
    }

    public void rechazarBaja(Baja b) {
        gb.rechazarBaja(b);
    }

    public java.util.List<Baja> obtenerSolicitudesBaja() {
        return gb.obtenerSolicitudesBaja();
    }

    //FUNCIONES PRERREGISTRO
    //-------------------------
    public boolean insertarPrerregistro(Prerregistro p) {
        return gpre.insertarPrerregistro(p);
    }

    public void confirmarPrerregistro(Prerregistro p) {
        gpre.confirmarPrerregistro(p);
    }

    public void rechazarPrerregistro(Prerregistro p) {
        gpre.rechazarPrerregistro(p);
    }

    public java.util.List<Prerregistro> obtenerSolicitudesPrerregistros() {
        return gpre.obtenerSolicitudesPrerregistro();
    }

    //FUNCIONES PAGO BENEFICIOS
    //-------------------------
    public boolean pagarBeneficios(PagoBeneficios pb) {
        return gpb.pagarBeneficios(pb);
    }

    public boolean anunciarPago(PagoBeneficios pb) {
        return gpb.anunciarPago(pb);
    }

    public void darBajaAnuncio(PagoBeneficios pb) {
        gpb.darBajaAnuncio(pb);
    }

    public java.util.List<PagoBeneficios> buscarAnunciosPagoBeneficios(String idEmpresa) {
        return gpb.buscarPagosBeneficios(idEmpresa);
    }

    //FUNCIONES PARTICIPACIONES
    //-------------------------
    public void darAltaPart(String e, int num) {
        gp.darAlta(e, num);
    }

    public boolean darBajaPart(String e, int num) {
        return gp.darBaja(e, num);
    }

    public java.util.List<Participaciones> consultarMercado() {
        return gp.obtenerTotalEnVenta();
    }

    public java.util.List<Participaciones> obtenerParticipaciones(Usuario u) {
        return gp.obtenerParticipaciones(u);
    }

    public java.util.List<Participaciones> obtenerParticipacionesEnVenta(Usuario u) {
        return gp.obtenerParticipacionesEnVenta(u);
    }

    public int obtenerNumTotalParticipacionesEmpresa(Usuario u, String empresa) {
        return gp.obtenerNumTotalParticipacionesEmpresa(u, empresa);
    }

    public int obtenerNumParticipacionesDisponiblesEmpresa(Usuario u, String e) {
        return gp.obtenerNumParticipacionesDisponiblesEmpresa(u, e);
    }

    //FUNCIONES OPERACIONES VENTA
    //-------------------------
    public void puestaVentaParticipaciones(Usuario usuario, String empresa, int num, float precio) {
        gov.puestaVentaParticipaciones(usuario, empresa, num, precio);
    }

    public void retirarMercado(String idUsuario, java.sql.Timestamp marcaTemporal) {
        gov.retirarMercado(idUsuario, marcaTemporal);
    }

    public boolean comprarParticipaciones(String usuario, String empresa, int num, float precio) {
        return gov.comprarParticipaciones(usuario, empresa, num, precio);
    }

    //FUNCIONES STACKING
    //-------------------------
    public void insertarStacking(Stacked s) {
        gs.insertarStacking(s);
    }

    public java.util.List<Stacked> obtenerStacking(Usuario u) {
        return gs.obtenerStacking(u);
    }

    public float retirarStacking(Stacked s) {
        return gs.retirarStacking(s);
    }

    //FUNCIONES PACTOS
    //-------------------------
    public void insertarPacto(Pacto p) {
        gpac.insertarPacto(p);
    }

    public void aceptarPacto(Pacto p) {
        gpac.aceptarPacto(p);
    }

    public java.util.List<Pacto> buscarPactos(String empresa, Usuario u, boolean mios) {
        return gpac.buscarPactos(empresa, u, mios);
    }

    public java.util.List<Pacto> buscarMisPactos(Usuario u) {
        return gpac.buscarMisPactos(u);
    }
}
