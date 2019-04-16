package datos.tarifa;

import datos.llamada.Llamada;

import java.io.Serializable;

public class Tarifa implements Serializable {
    double coste;

    public Tarifa(double coste){
        this.coste = coste;
    }

    public double getCoste(){
        return this.coste;
    }

    public double precioLlamada(Llamada llamada){
        return llamada.getDuracion() * coste;
    }
}
