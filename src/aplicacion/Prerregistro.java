package aplicacion;

import java.sql.Timestamp;

public class Prerregistro {
    private final java.sql.Timestamp marcaTemporal;
    private Usuario usr;
    private final String tipo;


    //CONSTRUCTOR
    //-----------
    public Prerregistro(Usuario usr, String tipo, java.sql.Timestamp marcaTemporal) {
        this.usr = usr;
        this.tipo = tipo;
        this.marcaTemporal = marcaTemporal;
    }

    //GETS
    //----
    public Timestamp getMarcaTemporal() {
        return marcaTemporal;
    }

    public Usuario getUsuario() {
        return this.usr;
    }
    
    public void setUsuario(Usuario u) {
        this.usr = u;
    }

    public String getTipo(){
        return this.tipo;
    }

}
