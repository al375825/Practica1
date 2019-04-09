import org.junit.Test;
import datos.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class PruebaTest {
    ListadoClientes listaClientes = new ListadoClientes();
    Empresa cliente1 = new Empresa("Carlos", "20902106M", new Direccion(12004, "Cs", "Cs"),
            "al375884@uji.es", new Tarifa(20));
    Particular cliente2 = new Particular("Heredia", "Edgar", "20919905W",
            new Direccion(12006, "cs", "cs"), "al375825@uji.es", new Tarifa(60));

    @Test
    public void listaClienteTest() throws ClienteException {
        listaClientes.anadir(cliente1);
        listaClientes.anadir(cliente2);
        assertEquals(2, listaClientes.recuperarListado().size());
        listaClientes.borrar(cliente1);
        assertEquals(1, listaClientes.recuperarListado().size());
    }

    Llamada llamada1 = new Llamada("123456789", 10);
    Llamada llamada2 = new Llamada("987654321", 20);

    @Test
    public void añadirLlamadaTest(){
        cliente1.listadoLlamadas().add(llamada1);
        cliente1.listadoLlamadas().add(llamada2);
        cliente2.listadoLlamadas().add(llamada2);
        assertEquals(2, cliente1.listadoLlamadas().size());
        assertEquals(1, cliente2.listadoLlamadas().size());
    }

    @Test
    public void calcularImporteTest(){
        Factura facturaC1=new Factura("1234",cliente1);
        Factura facturaC2=new Factura("1234",cliente2);
        cliente1.getFacturas().put("1234",facturaC1);
        cliente2.getFacturas().put("1234",facturaC2);
        cliente1.listadoLlamadas().add(llamada1);
        cliente1.listadoLlamadas().add(llamada2);
        cliente2.listadoLlamadas().add(llamada2);
        assertEquals(600, facturaC1.calcularImporte(cliente1),0.0);
        assertEquals(1200, facturaC2.calcularImporte(cliente2),0.0);
        cliente2.listadoLlamadas().add(llamada1);
        assertEquals(1800, facturaC2.calcularImporte(cliente2),0.0);
    }

   @Test
    public void cambioTarifaTest(){
        cliente1.cambioTarifa(new Tarifa(15));
        assertEquals(15, cliente1.getTarifa().getCoste(), 0.0);
        cliente2.cambioTarifa(new Tarifa(cliente2.getTarifa().getCoste()/2));
        assertEquals(30, cliente2.getTarifa().getCoste(), 0.0);
    }





}
