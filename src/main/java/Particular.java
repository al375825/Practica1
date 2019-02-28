public class Particular extends Cliente {
    private String apellidos;

    public Particular(String apellidos, String nombre, String nif, Dirección direccion, String correo, Fecha fecha, Tarifa tarifa){
        super(nombre, nif, direccion, correo, fecha, tarifa);
        this.apellidos = apellidos;
    }
}
