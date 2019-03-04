import org.junit.Test;
import clasesDatos.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class PruebaTest {
    ListadoClientes listaClientes = new ListadoClientes();
    Empresa cliente1 = new Empresa("Carlos", "20902106M", new Direccion(12004, "Cs", "Cs"),
            "al375884@uji.es", new Tarifa(20));
    Particular cliente2 = new Particular("Heredia", "Edgar", "20919905W",
            new Direccion(12006, "cs", "cs"), "al375825@uji.es", new Tarifa(60));

    @Test
    public void listaClienteTest(){
        listaClientes.añadir(cliente1);
        listaClientes.añadir(cliente2);
        assertEquals(2, listaClientes.getLista().size());
        listaClientes.borrar(cliente1);
        assertEquals(1, listaClientes.getLista().size());
    }

    @Test
    public void cambioTarifaTest(){
        cliente1.cambioTarifa(new Tarifa(15));
        assertEquals(15, cliente1.getTarifa().getCoste(), 0.0);
        cliente2.cambioTarifa(new Tarifa(cliente2.getTarifa().getCoste()/2));
        assertEquals(30, cliente2.getTarifa().getCoste(), 0.0);
    }

    Llamada llamada1 = new Llamada("123456789", 10.3);
    Llamada llamada2 = new Llamada("987654321", 13);

    @Test
    public void añadirLlamadaTest(){
        cliente1.listadoLlamadas().add(llamada1);
        cliente1.listadoLlamadas().add(llamada2);
        cliente2.listadoLlamadas().add(llamada2);
        assertEquals(2, cliente1.listadoLlamadas().size());
        assertEquals(1, cliente2.listadoLlamadas().size());
    }



}
