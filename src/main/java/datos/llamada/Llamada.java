package datos.llamada;

import datos.Fecha;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Llamada implements Fecha, Serializable {
    private String destino;
    private LocalDateTime fecha;
    //private LocalTime hora;
    private double duracion;

    public Llamada(String destino, double duracion){
        this.destino = destino;
        this.fecha = LocalDateTime.now();
        //this.hora = LocalTime.now();
        this.duracion = duracion;
    }

    public Llamada(String destino, LocalDateTime fecha, double duracion){
        this.destino = destino;
        this.fecha = fecha;
        //this.hora = hora;
        this.duracion = duracion;
    }

    public String getDestino(){
        return this.destino;
    }

    public LocalDateTime getFecha(){
        return this.fecha;
    }

    public int getHora(){ return this.fecha.getHour();}

    public double getDuracion(){
        return this.duracion;
    }

    public String llamadaToString(){
        StringBuilder cadenaLlamada=new StringBuilder();
        cadenaLlamada.append("Destino: "+destino+"   ");
        cadenaLlamada.append(fecha.toString()+"   ");
        cadenaLlamada.append("Duración: "+ duracion + "   ");
        //cadenaLlamada.append(hora);
        return cadenaLlamada.toString();
    }
}
