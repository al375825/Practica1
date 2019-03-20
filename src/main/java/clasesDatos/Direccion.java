package clasesDatos;

import java.io.Serializable;

public class Direccion implements Serializable {
    private int cp;
    private String provincia;
    private String poblacion;

    public Direccion(int cp, String provincia, String poblacion) {
        this.cp = cp;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public int getCp(){
        return this.cp;
    }

    public String getProvincia(){
        return this.provincia;
    }

    public String getPoblacion(){
        return this.poblacion;
    }
}
