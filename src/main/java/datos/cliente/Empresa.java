package datos.cliente;

import datos.tarifa.Tarifa;

public class Empresa extends Cliente {

    public Empresa(String nombre, String nif, Direccion direccion, String correo, Tarifa tarifa){
        super(nombre, nif, direccion, correo, tarifa);
    }
}
