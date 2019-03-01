package clasesDatos;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class Cliente {
    protected String nombre;
    protected String nif;
    protected Direccion direccion;
    protected String correo;
    protected Fecha fechaAlta;
    protected Tarifa tarifa;
    protected LinkedList<Llamada> llamadas;
    protected HashMap<String, Factura> facturas;



    public Cliente( String nombre, String nif, Direccion direccion, String correo, Fecha fecha, Tarifa tarifa){
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.correo = correo;
        this.fechaAlta = fecha;
        this.tarifa = tarifa;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getNif(){
        return this.nif;
    }

    public Direccion getDireccion(){
        return this.direccion;
    }

    public String getCorreo(){
        return this.correo;
    }

    public Fecha getFechaAlta(){
        return this.fechaAlta;
    }

    public Tarifa getTarifa(){
        return this.tarifa;
    }



    public void cambioTarifa(Tarifa nuevatarifa){
        this.tarifa = nuevatarifa;
    }

    public LinkedList<Llamada> listadoLlamadas(){
        return llamadas;
    }

    public void crearClientes(){

    }

    //metodo getfecha
}
