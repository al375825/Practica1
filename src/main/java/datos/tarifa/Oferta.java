package datos.tarifa;

import datos.llamada.Llamada;

import java.io.Serializable;

public class Tarifa implements InterfazTarifa, Serializable {
    protected double coste;
    protected InterfazTarifa tarifa;

    public Tarifa(double coste, InterfazTarifa tarifa){
        this.tarifa=tarifa;
        this.coste = coste;
    }

    protected InterfazTarifa getTarifa(){
        return this.tarifa;
    }

    public double getCoste(){
        return this.coste;
    }

    public double precioLlamada(Llamada llamada){
        return llamada.getDuracion() * coste;
    }
}
