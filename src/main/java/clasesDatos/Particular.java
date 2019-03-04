package clasesDatos;

public class Particular extends Cliente {
    private String apellidos;

    public Particular(String apellidos, String nombre, String nif, Direccion direccion, String correo, Tarifa tarifa){
        super(nombre, nif, direccion, correo, tarifa);
        this.apellidos = apellidos;
    }

    public String getApellidos(){
        return this.apellidos;
    }
}
