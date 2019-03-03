package clasesDatos;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private Calendar fecha;

    public Fecha(int dia, int mes, int año, int hora){
        fecha=new GregorianCalendar();
        this.fecha.set(Calendar.YEAR,año);
        this.fecha.set(Calendar.MONTH,mes);
        this.fecha.set(Calendar.DAY_OF_MONTH,dia);
        this.fecha.set(Calendar.HOUR_OF_DAY, hora);
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

    public int getHora() { return this.fecha.get(Calendar.HOUR_OF_DAY); }

    public String formatoFecha(){
        StringBuilder formatoFecha=new StringBuilder();
        formatoFecha.append(this.getDia());
        formatoFecha.append("/");
        formatoFecha.append(this.getMes());
        formatoFecha.append("/");
        formatoFecha.append(this.getAño()+"   ");
        formatoFecha.append(this.getHora());
        return formatoFecha.toString();
    }
}
