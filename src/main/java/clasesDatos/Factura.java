package clasesDatos;

import java.time.LocalDateTime;

public class Factura {
    private String codigo;
    private Tarifa tarifa;
    private LocalDateTime fecha;
    private LocalDateTime inicioPeriodo;
    private LocalDateTime finPeriodo;
    private double importe;

    public Factura(String codigo, Cliente cliente){
        this.codigo = codigo;
        this.fecha = LocalDateTime.now();
        this.tarifa = cliente.getTarifa();
        this.inicioPeriodo = LocalDateTime.now();
        this.finPeriodo = inicioPeriodo.plusMonths(1);
        importe = calcularImporte(cliente);
    }

    public String getCodigo(){
        return this.codigo;
    }

    public Tarifa getTarifaFactura(){
        return this.tarifa;
    }


    public LocalDateTime getInicioPeriodo(){
        return this.inicioPeriodo;
    }

    public LocalDateTime getFinPeriodo(){
        return this.finPeriodo;
    }

    public double getImporte(){
        return this.importe;
    }

    public double calcularImporte(Cliente cliente){
        double duracion=0;
        int mes = LocalDateTime.now().getMonthValue();
        for(Llamada llamada:cliente.listadoLlamadas()){
            if(llamada.getFecha().getMonthValue()==mes) {
                duracion+=llamada.getDuracion();
            }
        }
        importe=duracion*tarifa.getCoste();
        return importe;
    }

    public String facturaToString(){
        StringBuilder cadenaFactura=new StringBuilder();
        cadenaFactura.append("Codigo: "+getCodigo()+"   ");
        cadenaFactura.append(getTarifaFactura().getCoste()+"   ");
        cadenaFactura.append(fecha.toString()+"   ");
        cadenaFactura.append(getInicioPeriodo()+" - " + getFinPeriodo()+"   ");
        cadenaFactura.append("A pagar: "+getImporte());
        return cadenaFactura.toString();
    }

    public LocalDateTime getFecha(){
        return this.fecha;
    }
}
