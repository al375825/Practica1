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

    public double calcularImporte(Cliente cliente, int mes){
        int duracion=0;
        for(Llamada llamada:cliente.listadoLlamadas()){
            if(llamada.getFechaLlamada().getMes()==mes) {
                duracion+=llamada.getDuracion();
            }
        }
        this.importe=duracion*tarifa.coste;
    }

    public String facturaToString(){
        StringBuilder cadenaFactura=new StringBuilder();
        cadenaFactura.append("Codigo: "+this.getCodigo()+"   ");
        cadenaFactura.append(this.getTarifaFactura().getCoste()+"   ");
        cadenaFactura.append(this.getFecha().formatoFecha()+"   ");
        cadenaFactura.append(this.getPeriodo()+"    ");
        cadenaFactura.append("A pagar: "+this.getImporte());
        return cadenaFactura.toString();
    }

    public Fecha getFechaFactura(){
        return this.fecha;
    }
}
