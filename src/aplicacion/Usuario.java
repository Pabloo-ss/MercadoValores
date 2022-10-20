package aplicacion;

public class Usuario {

    private final String id;
    private final String clave;
    private float saldoDisponible;
    private final TipoUsuario tipo;

    public Usuario(String id, String clave, float saldoDisponible, TipoUsuario tipo) {
        this.id = id;
        this.clave = clave;
        this.saldoDisponible = saldoDisponible;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getClave() {
        return clave;
    }

    public float getSaldoDisponible() {
        return saldoDisponible;
    }
    
    public void setSaldoDisponible(float saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
    
    public TipoUsuario getTipo() {
        return tipo;
    }

}
