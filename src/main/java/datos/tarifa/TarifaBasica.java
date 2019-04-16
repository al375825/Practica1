package datos.tarifa;

import datos.llamada.Llamada;

import java.io.Serializable;

public class TarifaBasica extends Tarifa implements Serializable {

    public TarifaBasica(double coste) {
        super(coste);
    }

    @Override
    public double precioLlamada(Llamada llamada) {
        return super.precioLlamada(llamada);
    }
}
