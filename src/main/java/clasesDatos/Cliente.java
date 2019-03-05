package clasesDatos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class Cliente {
    protected String nombre;
    protected String nif;
    protected Direccion direccion;
    protected String correo;
    protected LocalDateTime fechaAlta;
    protected Tarifa tarifa;
    protected LinkedList<Llamada> llamadas;
    protected HashMap<String, Factura> facturas;



    public Cliente( String nombre, String nif, Direccion direccion, String correo, Tarifa tarifa){
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.correo = correo;
        this.fechaAlta = LocalDateTime.now();
        this.tarifa = tarifa;
        llamadas=new LinkedList<Llamada>();
        facturas=new HashMap<String,Factura>();
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

    public LocalDateTime getFecha(){
        return this.fechaAlta;
    }

    public Tarifa getTarifa(){
        return this.tarifa;
    }

    public HashMap<String, Factura> getFacturas(){
        return facturas;
    }

    public void cambioTarifa(Tarifa nuevatarifa){
        this.tarifa = nuevatarifa;
    }

    public LinkedList<Llamada> listadoLlamadas(){
        return llamadas;
    }

    public Factura recuperarFactura(String codigo){
        return facturas.get(codigo);
    }

    public String clienteToString(){
        StringBuilder cadenaCliente=new StringBuilder();
        cadenaCliente.append(nombre+"   "+nif+"   ");
        cadenaCliente.append(direccion.getCp()+" "+direccion.getProvincia()+" "+direccion.getPoblacion()+"   ");
        cadenaCliente.append(correo+"   "+ fechaAlta.toString()+"   ");
        cadenaCliente.append(tarifa.getCoste());
        return cadenaCliente.toString();
    }


}
