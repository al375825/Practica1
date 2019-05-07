package datos.tarifa;

import datos.llamada.Llamada;

import java.io.Serializable;

public class TarifaBasica  implements Tarifa, Serializable {
    // todo El coste lo podéis subir a la interfaz Tarifa y convertirla en una clase.
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
