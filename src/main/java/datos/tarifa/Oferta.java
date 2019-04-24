package datos.tarifa;

import datos.llamada.Llamada;

import java.io.Serializable;

public class Oferta implements Tarifa, Serializable {
    protected double coste;
    protected Tarifa tarifa;

    public Oferta(double coste, Tarifa tarifa){
        this.tarifa=tarifa;
        this.coste = coste;
    }

    protected Tarifa getTarifa(){
        return this.tarifa;
    }

    public double getCoste(){
        return this.coste;
    }

    public double precioLlamada(Llamada llamada){
        return llamada.getDuracion() * coste;
    }
}
