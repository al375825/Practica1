package datos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GenericClass {
    public static <T extends Fecha> ArrayList<T> generico(ArrayList<T> conjuntoObjetos, LocalDateTime inicio, LocalDateTime fin) {
        ArrayList<T> lista = new ArrayList<T>();
        for (T objeto : conjuntoObjetos){
            if (inicio.compareTo(objeto.getFecha()) <= 0 && fin.compareTo(objeto.getFecha()) >= 0) {
                lista.add(objeto);
            }
        }
        return lista;
    }
}


