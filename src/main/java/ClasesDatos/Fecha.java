package ClasesDatos;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private Calendar fecha;

    public Fecha(int dia, int mes, int año){
        fecha=new GregorianCalendar();
        this.fecha.set(Calendar.YEAR,año);
        this.fecha.set(Calendar.MONTH,mes);
        this.fecha.set(Calendar.DAY_OF_MONTH,dia);
    }

    public int getDia(){
        return this.fecha.get(Calendar.DAY_OF_MONTH);
    }

    public int getMes(){
        return this.fecha.get(Calendar.MONTH);
    }

    public int getAño(){
        return this.fecha.get(Calendar.YEAR);
    }

    public String formatoFecha(){
        StringBuilder formatoFecha=new StringBuilder();
        formatoFecha.append(this.getDia());
        formatoFecha.append("/");
        formatoFecha.append(this.getMes());
        formatoFecha.append("/");
        formatoFecha.append(this.getAño());
        return formatoFecha.toString();
    }
}
