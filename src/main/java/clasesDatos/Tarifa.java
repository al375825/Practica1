package clasesDatos;

import java.io.Serializable;

public class Tarifa implements Serializable {
    double coste;

    public Tarifa(double coste){
        this.coste = coste;
    }

    public double getCoste(){
        return this.coste;
    }
}
