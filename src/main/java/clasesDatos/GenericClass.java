package clasesDatos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class GenericClass {
    public <T extends Fecha> ArrayList<T> generico(Collection<T> conjuntoObjetos, LocalDateTime inicio, LocalDateTime fin) {
        ArrayList<T> lista = new ArrayList<T>();
        for (T objeto : conjuntoObjetos){
            if (inicio.compareTo(objeto.getFecha()) <= 0 && fin.compareTo(objeto.getFecha()) >= 0) {
                lista.add(objeto);
            }
        }
        return lista;
    }
}


