package datos.tarifa.factory;

import datos.tarifa.Tarifa;
import datos.tarifa.TarifaBasica;
import datos.tarifa.TarifaDiaSemana;
import datos.tarifa.TarifaPeriodo;
import java.time.DayOfWeek;
import java.time.LocalTime;

public interface FactoryIntT {
    public TarifaBasica getTarifaBasica(double coste);

    public TarifaDiaSemana getTarifaDiaSemana(double coste, Tarifa tarifa, DayOfWeek dia);

    public TarifaPeriodo getTarifaPeriodo(double coste, Tarifa tarifa, LocalTime horaini, LocalTime horafin);
}
