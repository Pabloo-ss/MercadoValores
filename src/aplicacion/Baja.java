package aplicacion;

import java.sql.Timestamp;

public class Baja {
    
    private final Usuario usuario;
    private final java.sql.Timestamp marcaTemporal;
    private final int numPart;
    
    public Baja(Usuario usuario, java.sql.Timestamp marcaTemporal, int numPart) {
        this.usuario = usuario;
        this.marcaTemporal = marcaTemporal;
        this.numPart = numPart;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Timestamp getMarcaTemporal() {
        return marcaTemporal;
    }
    
    public int getNumPart() {
        return numPart;
    }
}
