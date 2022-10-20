package aplicacion;

import java.sql.Timestamp;

public class PagoBeneficios {

    private final String idEmpresa;
    private final Timestamp fecha;
    private float importeParticipacion;
    private int cantidadParticipaciones;
    private int participacionesPorUsuario;
    private int usuariosConParticipaciones;

    public PagoBeneficios(String idEmpresa, Timestamp fecha) {
        this.idEmpresa = idEmpresa;
        this.fecha = fecha;
        this.importeParticipacion = (float) 0.0;
        this.participacionesPorUsuario = 0;
    }

    public PagoBeneficios(String idEmpresa, Timestamp fecha, float importe, int numPart, int partiUser, int numUsers) {
        this.idEmpresa = idEmpresa;
        this.fecha = fecha;
        this.importeParticipacion = importe;
        this.cantidadParticipaciones = numPart;
        this.participacionesPorUsuario = partiUser;
        this.usuariosConParticipaciones = numUsers;
    }

    public float getImporteParticipacion() {
        return importeParticipacion;
    }

    public void setImporteParticipacion(float importeParticipacion) {
        this.importeParticipacion = importeParticipacion;
    }

    public int getCantidadParticipaciones() {
        return cantidadParticipaciones;
    }

    public void setCantidadParticipaciones(int cantidadParticipaciones) {
        this.cantidadParticipaciones = cantidadParticipaciones;
    }

    public int getParticipacionesPorUsuario() {
        return participacionesPorUsuario;
    }

    public void setParticipacionesPorUsuario(int participacionesPorUsuario) {
        this.participacionesPorUsuario = participacionesPorUsuario;
    }

    public int getUsuariosConParticipaciones() {
        return usuariosConParticipaciones;
    }

    public void setUsuariosConParticipaciones(int usuariosConParticipaciones) {
        this.usuariosConParticipaciones = usuariosConParticipaciones;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public Timestamp getFecha() {
        return fecha;
    }

}
