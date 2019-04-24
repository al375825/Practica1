package datos.tarifa;

import datos.llamada.Llamada;

public interface InterfazTarifa {
        String toString();

        double getCoste();

        double precioLlamada(Llamada llamada);

}
