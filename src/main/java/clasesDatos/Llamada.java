package clasesDatos;

public class Llamada {
    private String destino;
    private Fecha fecha;
    private double duracion;

    public Llamada(String destino, Fecha fecha, int duracion){
        this.destino = destino;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public String getDestino(){
        return this.destino;
    }

    public Fecha getFechaLlamada(){
        return this.fecha;
    }

    public double getDuracion(){
        return this.duracion;
    }

    //public String getHora(){
        //return this.hora;
    //}

    public String llamadaToString(){
        StringBuilder cadenaLlamada=new StringBuilder();
        cadenaLlamada.append("Destino: "+destino+"   ");
        cadenaLlamada.append(fecha.formatoFecha()+"   ");
        cadenaLlamada.append("Duración: "+ duracion + "   ");
        //cadenaLlamada.append(hora);
        return cadenaLlamada.toString();
    }


    //metodo getFecha
}
