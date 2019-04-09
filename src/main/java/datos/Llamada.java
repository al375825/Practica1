package datos;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Llamada implements Fecha, Serializable {
    private String destino;
    private LocalDateTime fecha;
    private double duracion;

    public Llamada(String destino, double duracion){
        this.destino = destino;
        this.fecha = LocalDateTime.now();
        this.duracion = duracion;
    }

    public String getDestino(){
        return this.destino;
    }

    public LocalDateTime getFecha(){
        return this.fecha;
    }

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
