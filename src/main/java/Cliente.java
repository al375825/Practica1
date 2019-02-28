import java.util.HashMap;
import java.util.LinkedList;

public class Cliente {
    protected String nombre;
    protected String nif;
    protected Dirección direccion;
    protected String correo;
    protected Fecha fecha;
    protected Tarifa tarifa;
    protected LinkedList<Llamada> llamadas;
    protected HashMap<String, Factura> facturas;

    public Cliente( String nombre, String nif, Dirección direccion, String correo, Fecha fecha, Tarifa tarifa){
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha = fecha;
        this.tarifa = tarifa;
    }

    public void cambioTarifa(Tarifa nuevatarifa){
        this.tarifa = nuevatarifa;
    }

    public LinkedList<Llamada> lsitadoLlamadas(){
        return llamadas;
    }

    //metodo getfecha
}
