package clasesDatos;

public class Empresa extends Cliente{

    public Empresa(String nombre, String nif, Direccion direccion, String correo, Fecha fecha, Tarifa tarifa){
        super(nombre, nif, direccion, correo, fecha, tarifa);
    }
}
