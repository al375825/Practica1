package datos.tarifa;

import datos.llamada.Llamada;

import java.io.Serializable;
import java.time.DayOfWeek;

public class TarifaDiaSemana extends Tarifa implements Serializable {

    private DayOfWeek dia;

    public TarifaDiaSemana(double coste, DayOfWeek dia) {
        super(coste);
        this.dia = dia;
    }

    @Override
    public double precioLlamada(Llamada llamada) {
        Double anterior = 0.0;//= tarifa.calcularPrecioLlamada(llamada); hay que cambiarlo
        Double actual = llamada.getDuracion() * coste;

        if(llamada.getFecha().getDayOfWeek().compareTo(dia) == 0) {
            if(actual < anterior) {
                return actual;
            }
        }

        return anterior;
    }
}
