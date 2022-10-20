package aplicacion;

import java.sql.Timestamp;

public class OperacionVenta {
    private final String idUsuario;
    private final String idEmpresa;
    private final Timestamp marcaTemporal;
    private final float comision;
    private final int cantidad;
    private final float precioParticipacion;
    
    public OperacionVenta(  String idUsuario,
                            String idEmpresa,
                            Timestamp marcaTemporal,
                            float comision,
                            int cantidad,
                            float precioParticipacion){
        
        this.idUsuario = idUsuario;
        this.idEmpresa = idEmpresa;
        this.marcaTemporal = marcaTemporal;
        this.comision = comision;
        this.cantidad = cantidad;
        this.precioParticipacion = precioParticipacion;       
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public Timestamp getMarcaTemporal() {
        return marcaTemporal;
    }

    public float getComision() {
        return comision;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecioParticipacion() {
        return precioParticipacion;
    }
    
    
}
