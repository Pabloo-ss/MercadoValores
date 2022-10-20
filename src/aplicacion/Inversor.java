package aplicacion;

public class Inversor extends Usuario {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String telefono;

    public Inversor(String id,
            String clave,
            float saldoDisponible,
            String dni,
            String nombre,
            String apellido1,
            String apellido2,
            String direccion,
            String telefono) {

        super(id, clave, saldoDisponible, TipoUsuario.Inversor);
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public Inversor(String id, String clave, float saldoDisponible) {
        super(id, clave, saldoDisponible, TipoUsuario.Inversor);
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}