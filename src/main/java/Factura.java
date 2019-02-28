public class Factura {
    private String codigo;
    private Tarifa tarifa;
    private Fecha fecha;
    private String periodo;
    private int importe;

    public Factura(String codigo, Tarifa tarifa, Fecha fecha, String periodo, int importe){
        this.codigo = codigo;
        this.fecha = fecha;
        this.tarifa = tarifa;
        this.periodo = periodo;
        this.importe = importe;
    }

    //metodo getFecha
}
