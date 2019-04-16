package datos.tarifa;

import datos.llamada.Llamada;

import java.io.Serializable;
import java.time.LocalTime;

public class TarifaPeriodo extends Tarifa implements Serializable {

    private LocalTime hora;

    public TarifaPeriodo(double coste, LocalTime hora) {
        super(coste);
        this.hora = hora;
    }

    @Override
    public double precioLlamada(Llamada llamada) {
        Double anterior = 0.0; //tarifa.calcularPrecioLlamada(llamada); hay que cambiarlo
        Double actual = llamada.getDuracion() * coste;

        if(llamada.getHora().isAfter(hora)) {
            if (actual < anterior) {
                return actual;
            }
        }

        return anterior;
    }
}
