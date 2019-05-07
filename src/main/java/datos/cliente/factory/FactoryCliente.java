package datos.cliente.factory;

import datos.cliente.Direccion;
import datos.cliente.Empresa;
import datos.cliente.Particular;
import datos.tarifa.TarifaBasica;

import java.io.Serializable;

public class FactoryCliente implements FactoryIntC, Serializable {

    public FactoryCliente(){}

    @Override
    public Empresa getClienteEmpresa(String nombre, String nif, Direccion direccion, String correo, double coste) {
        return new Empresa(nombre, nif, direccion, correo, new TarifaBasica(coste));
    }

    @Override
    public Particular getClienteParticular(String apellidos, String nombre, String nif, Direccion direccion, String correo, double coste) {
        return new Particular(apellidos, nombre, nif, direccion, correo, new TarifaBasica(coste));
    }
}
