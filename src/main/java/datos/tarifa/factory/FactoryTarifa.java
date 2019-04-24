package datos.tarifa.factory;

import datos.tarifa.Tarifa;
import datos.tarifa.TarifaBasica;
import datos.tarifa.TarifaDiaSemana;
import datos.tarifa.TarifaPeriodo;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class FactoryTarifa implements FactoryIntT, Serializable {

    public FactoryTarifa(){}

    @Override
    public TarifaBasica getTarifaBasica(double coste) {
        return new TarifaBasica(coste);
    }

    @Override
    public TarifaDiaSemana getTarifaDiaSemana(double coste, Tarifa tarifa, DayOfWeek dia) {
        return new TarifaDiaSemana(coste, tarifa, dia);
    }

    @Override
    public TarifaPeriodo getTarifaPeriodo(double coste, Tarifa tarifa, LocalTime horaini, LocalTime horafin) {
        return new TarifaPeriodo(coste, tarifa, horaini, horafin);
    }
}
