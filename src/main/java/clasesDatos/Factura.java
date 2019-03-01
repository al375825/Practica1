package clasesDatos;

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

    public String facturaToString(){
        StringBuilder cadenaFactura=new StringBuilder();
        cadenaFactura.append("Codigo: "+codigo+"   ");
        cadenaFactura.append(tarifa.getCoste()+"   ");
        cadenaFactura.append(fecha.formatoFecha()+"   ");
        cadenaFactura.append(periodo+"    ");
        cadenaFactura.append("A pagar: "+importe);
        return cadenaFactura.toString();
    }

    //metodo getFecha
}
