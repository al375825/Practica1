public class Llamada {
    private String destino;
    private Fecha fecha;
    private double duracion;
    private String hora;

    public Llamada(String destino, Fecha fecha, int duracion, String hora){
        this.destino = destino;
        this.fecha = fecha;
        this.duracion = duracion;
        this.hora = hora;
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

    public String getHora(){
        return this.hora;
    }

    //metodo getFecha
}
