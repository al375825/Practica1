package ClasesDatos;

public class Factura {
    private String codigo;
    private Tarifa tarifa;
    private Fecha fecha;
    private String periodo;
    private double importe;

    public Factura(String codigo, Tarifa tarifa, Fecha fecha, String periodo, int importe){
        this.codigo = codigo;
        this.fecha = fecha;
        this.tarifa = tarifa;
        this.periodo = periodo;
        this.importe = importe;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public Tarifa getTarifaFactura(){
        return this.tarifa;
    }

    public Fecha getFecha(){
        return this.fecha;
    }

    public String getPeriodo(){
        return this.periodo;
    }

    public double getImporte(){
        return this.importe;
    }

    //metodo getFecha
}
