package aplicacion;

public class Regulador extends Usuario {

    private final float comisionCompraventa;
    private final float interesStacking;

    public Regulador(String id, String clave, float saldoDisponible, float comision, float interes) {
        super(id, clave, saldoDisponible, TipoUsuario.Regulador);
        this.comisionCompraventa = comision;
        this.interesStacking = interes;
    }

    public float getComisionCompraventa() {
        return comisionCompraventa;
    }

    public float getInteresStacking() {
        return interesStacking;
    }
    
}