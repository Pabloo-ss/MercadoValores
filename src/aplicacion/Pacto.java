package aplicacion;

import java.sql.Timestamp;

public class Pacto {
    private final Timestamp marcaTemporal;
    private final String comprador;
    private String vendedor;
    private final String idEmpresa;
    private final String nombreEmpresa;
    private final int cantidad;
    private final float precio;
    private final Timestamp fechaVenta;
    private float comision;

    public Pacto(Timestamp marcaTemporal, String comprador, String vendedor,
            String idEmpresa, String empresa, int cantidad, float precio,
            Timestamp fechaVenta, float comision) {
        this.marcaTemporal = marcaTemporal;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = empresa;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaVenta = fechaVenta;
        this.comision = comision;
    }

    public Pacto(Timestamp marcaTemporal, String comprador, String idEmpresa, String nombreEmpresa, int cantidad, float precio, Timestamp fechaVenta) {
        this.marcaTemporal = marcaTemporal;
        this.comprador = comprador;
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaVenta = fechaVenta;
    }
    

    public Timestamp getMarcaTemporal() {
        return marcaTemporal;
    }

    public String getComprador() {
        return comprador;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public Timestamp getFechaVenta() {
        return fechaVenta;
    }

    public float getComision() {
        return comision;
    }
    
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    
    
    
}
