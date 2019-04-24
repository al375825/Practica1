package datos.tarifa;

import datos.llamada.Llamada;

import java.io.Serializable;

public class TarifaBasica  implements Tarifa, Serializable {
    double coste;

    public TarifaBasica(double coste) {
        this.coste=coste;
    }

    public double getCoste(){
        return coste;
    }

    @Override
    public double precioLlamada(Llamada llamada) {
        return llamada.getDuracion()*coste;
    }
}
