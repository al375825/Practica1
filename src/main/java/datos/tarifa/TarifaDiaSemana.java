package datos.tarifa;

import datos.llamada.Llamada;

import java.io.Serializable;
import java.time.DayOfWeek;

public class TarifaDiaSemana extends Oferta implements Serializable {

    private DayOfWeek dia;

    public TarifaDiaSemana(double coste, Tarifa tarifa, DayOfWeek dia) {
        super(coste,tarifa);
        this.dia = dia;
    }

    @Override
    public double precioLlamada(Llamada llamada) {
        Double antes = tarifa.precioLlamada(llamada);
        Double ahora = llamada.getDuracion() * coste;

        if(llamada.getFecha().getDayOfWeek().compareTo(dia) == 0) {
            if(ahora < antes) {
                return ahora;
            }
        }

        return antes;
    }
}
