package clasesDatos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class Cliente implements Fecha{
    protected String nombre;
    protected String nif;
    protected Direccion direccion;
    protected String correo;
    protected LocalDateTime fecha;
    protected Tarifa tarifa;
    protected ArrayList<Llamada> llamadas;
    protected HashMap<String, Factura> facturas;



    public Cliente( String nombre, String nif, Direccion direccion, String correo, Tarifa tarifa){
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha = LocalDateTime.now();
        this.tarifa = tarifa;
        llamadas=new ArrayList<Llamada>();
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
        return this.fecha;
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

    public ArrayList<Llamada> listadoLlamadas(){
        return llamadas;
    }

    public ArrayList<Factura> listadoFacturas(){
        ArrayList<Factura> lista=new ArrayList<Factura>();
        for(String codFactura: facturas.keySet()){
            lista.add(facturas.get(codFactura));
        }
        return lista;
    }

    public Factura recuperarFactura(String codigo){
        return facturas.get(codigo);
    }

    public String clienteToString(){
        StringBuilder cadenaCliente=new StringBuilder();
        cadenaCliente.append(nombre+"   "+nif+"   ");
        cadenaCliente.append(direccion.getCp()+" "+direccion.getProvincia()+" "+direccion.getPoblacion()+"   ");
        cadenaCliente.append(correo+"   "+ fecha.toString()+"   ");
        cadenaCliente.append(tarifa.getCoste());
        return cadenaCliente.toString();
    }


}
