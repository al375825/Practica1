import datos.*;

import datos.llamada.Llamada;
import datos.tarifa.Tarifa;
import datos.tarifa.TarifaBasica;
import datos.tarifa.TarifaDiaSemana;
import datos.tarifa.TarifaPeriodo;
import org.junit.Test;
import java.time.*;

import static junit.framework.TestCase.assertEquals;


public class PatronesTest {

    ListadoClientes listaClientes = new ListadoClientes();

    @Test
    public void patronTarifaTest() {
        LocalDate fecha1 = LocalDate.of(2019, 4, 28);
        LocalDate fecha2 = LocalDate.of(2019, 4, 24);
        LocalTime hora1 = LocalTime.of(6, 0);
        LocalTime hora2 = LocalTime.of(18, 0);

        Llamada llamada1 = new Llamada("12345",LocalDateTime.of(fecha1,hora1),5);
        Llamada llamada2 = new Llamada("54321", LocalDateTime.of(fecha2,hora2), 10);
        Llamada llamada3 = new Llamada("54321", LocalDateTime.of(fecha2,hora1), 20);

        LocalTime horaini = LocalTime.of(17, 0);
        LocalTime horafin = LocalTime.of(19, 0);

        Tarifa tarifa = new TarifaBasica(1);
        assertEquals(5.0,tarifa.precioLlamada(llamada1));
        assertEquals(10.0, tarifa.precioLlamada(llamada2));
        assertEquals(20.0, tarifa.precioLlamada(llamada3));

        tarifa = new TarifaPeriodo(0.5, tarifa, horaini, horafin);
        assertEquals(5.0, tarifa.precioLlamada(llamada1));
        assertEquals(5.0,tarifa.precioLlamada(llamada2));
        assertEquals(20.0, tarifa.precioLlamada(llamada3));

        tarifa = new TarifaDiaSemana(0, tarifa, DayOfWeek.SUNDAY);
        assertEquals(0.0, tarifa.precioLlamada(llamada1));
        assertEquals(5.0, tarifa.precioLlamada(llamada2));
        assertEquals(20.0, tarifa.precioLlamada(llamada3));
    }
}
