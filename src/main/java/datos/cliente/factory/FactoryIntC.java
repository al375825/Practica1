package datos.cliente.factory;

import datos.cliente.Direccion;
import datos.cliente.Empresa;
import datos.cliente.Particular;

public interface FactoryIntC {
    public Empresa getClienteEmpresa(String nombre, String nif, Direccion direccion, String correo,  double coste);

    public Particular getClienteParticular(String apellidos, String nombre, String nif, Direccion direccion, String correo, double coste);
}
