package datos.tarifa;

import datos.llamada.Llamada;

public interface Tarifa {
        String toString();

        double getCoste();

        double precioLlamada(Llamada llamada);

}
