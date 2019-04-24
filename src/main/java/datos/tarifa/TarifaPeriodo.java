package datos.tarifa;

import datos.llamada.Llamada;

import java.io.Serializable;
import java.time.LocalTime;

public class TarifaPeriodo extends Oferta implements Serializable {

    private LocalTime horaini;
    private LocalTime horafin;

    public TarifaPeriodo(double coste, Tarifa tarifa, LocalTime horaini, LocalTime horafin) {
        super(coste, tarifa);
        this.horaini = horaini;
        this.horafin = horafin;
    }

    @Override
    public double precioLlamada(Llamada llamada) {
        Double antes = tarifa.precioLlamada(llamada);
        Double ahora = llamada.getDuracion() * coste;

        if(llamada.getHora()>horaini.getHour() && llamada.getHora()<horafin.getHour()) {
            if (ahora < antes) {
                return ahora;
            }
        }

        return antes;
    }
}
