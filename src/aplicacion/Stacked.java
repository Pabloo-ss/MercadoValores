package aplicacion;

import java.sql.Timestamp;


public class Stacked {
    private final java.sql.Timestamp marcaTemporal;
    private final String usuario;
    private String empresa;
    private final String idEmpresa;
    private final int cantidad;
    private float interes;

    public Stacked(Timestamp marcaTemporal, String usuario, String empresa, String idEmpresa, int cantidad, float interes) {
        this.marcaTemporal = marcaTemporal;
        this.usuario = usuario;
        this.empresa = empresa;
        this.idEmpresa = idEmpresa;
        this.cantidad = cantidad;
        this.interes = interes;
    }

    public Stacked(Timestamp marcaTemporal, String usuario, String idEmpresa, int cantidad) {
        this.marcaTemporal = marcaTemporal;
        this.usuario = usuario;
        this.idEmpresa = idEmpresa;
        this.cantidad = cantidad;
    }

    public Timestamp getMarcaTemporal() {
        return marcaTemporal;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmpresa() {
        return empresa;
    }
    
    public String getIdEmpresa() {
        return idEmpresa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
    
}
