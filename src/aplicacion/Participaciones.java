package aplicacion;

import java.sql.Timestamp;

public class Participaciones {

    private final String usuario;
    private final int cantidad;
    private final String empresa;
    private final float precio;
    private java.sql.Timestamp marcaTemporalVenta;

    public Participaciones(String idUsuario, String empresa, int cantidad, float precio) {
        this.usuario = idUsuario;
        this.empresa = empresa;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getEmpresa() {
        return empresa;
    }

    public float getPrecio() {
        return precio;
    }

    public Timestamp getMarcaTemporalVenta() {
        return marcaTemporalVenta;
    }

    public void setMarcaTemporalVenta(Timestamp marcaTemporalVenta) {
        this.marcaTemporalVenta = marcaTemporalVenta;
    }
    
}
