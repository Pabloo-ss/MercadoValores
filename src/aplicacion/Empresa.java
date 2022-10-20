package aplicacion;

public class Empresa extends Usuario {

    private String cif;
    private String nombre;
    private String direccion;
    private String telefono;
    private float saldoBloqueado;
    private int partiBloqueadas;

    public Empresa(String id,
            String clave,
            float saldoDisponible,
            String cif,
            String nombre,
            String direccion,
            String telefono,
            float saldoBloqueado,
            int partiBloqueadas) {

        super(id, clave, saldoDisponible, TipoUsuario.Empresa);
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.saldoBloqueado = saldoBloqueado;
        this.partiBloqueadas = partiBloqueadas;

    }
    
    public Empresa(String id, String clave, float saldoDisponible) {
        super(id, clave, saldoDisponible, TipoUsuario.Empresa);
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public float getSaldoBloqueado() {
        return saldoBloqueado;
    }
    
    public int getPartiBloqueadas() {
        return partiBloqueadas;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setSaldoBloqueado(float saldoBloqueado) {
        this.saldoBloqueado = saldoBloqueado;
    }

    public void setPartiBloqueadas(int partiBloqueadas) {
        this.partiBloqueadas = partiBloqueadas;
    }
    
    
}