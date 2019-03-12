package main;

import clasesDatos.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Aplicacion {

    public ListadoClientes listaClientes = new ListadoClientes();

    public void crearCliente() throws ClienteException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("    Introduce el nombre del cliente: ");
        String nombre = teclado.next();
        System.out.println("    Introduce el dni del cliente: ");
        String nif = teclado.next();
        System.out.println("    Introduce el CP del cliente: ");
        int cp = teclado.nextInt();
        System.out.println("    Introduce la provincia: ");
        String provincia = teclado.next();
        System.out.println("    Introduce la población: ");
        String poblacion = teclado.next();
        Direccion dirCliente = new Direccion(cp, provincia, poblacion);
        System.out.println("    Introduce su correo: ");
        String correo = teclado.next();
        System.out.println("    Introduce la tarifa (€/min): ");
        double precio = teclado.nextDouble();
        Tarifa tarifa = new Tarifa(precio);

        System.out.println("    Tipo de cliente: 1) Empresa o 2) Particular ");
        int opcion = teclado.nextInt();
        if (opcion == 1) {
            Empresa nuevoCliente = new Empresa(nombre, nif, dirCliente, correo, tarifa);
            listaClientes.anadir(nuevoCliente);
        } else {
            System.out.println("    Introduce los apellidos del cliente: ");
            String apellidos = teclado.next();
            Particular nuevoCliente = new Particular(apellidos, nombre, nif, dirCliente, correo, tarifa);
            listaClientes.anadir(nuevoCliente);
        }
        System.out.println("Cliente creado");
    }

    public void eliminarCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nif: ");
        String nif= teclado.next();
        Cliente cliente = listaClientes.recuperarCliente(nif);
        listaClientes.borrar(cliente);
        System.out.println("Cliente eliminado");

    }

    public void cambioTarifa(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nif: ");
        String nif= teclado.next();
        Cliente cliente = listaClientes.recuperarCliente(nif);
        System.out.println("Introduzca la nueva tarifa: ");
        Double dato = teclado.nextDouble();
        Tarifa tarifa = new Tarifa(dato);
        cliente.cambioTarifa(tarifa);
        System.out.println("Tarifa cambiada con éxito.");
    }

    public void recuperarDatos(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nif: ");
        String dni= teclado.next();
        System.out.println(listaClientes.recuperarCliente(dni).clienteToString());
    }

    public void listarClientes(){
        HashMap<String,Cliente> lista = listaClientes.recuperarListado();
        Set<String> dnis= lista.keySet();
        for(String dnicliente:dnis){
            Cliente datosCliente=listaClientes.recuperarCliente(dnicliente);
            System.out.println(datosCliente.clienteToString());
        }
    }

    public void emitirFactura(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el dni del cliente de la factura: ");
        String nif= teclado.next();
        HashMap<String,Cliente> clientes=listaClientes.recuperarListado();
        Cliente clienteFactura=clientes.get(nif);
        System.out.println("Introduzca el código de la factura a emitir: ");
        String codFact= teclado.next();
        Factura facturaAEmitir=new Factura(codFact,clienteFactura);
        clienteFactura.getFacturas().put(codFact,facturaAEmitir);
        System.out.println(facturaAEmitir.facturaToString());
    }

    public void recuperarFactura(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nif: ");
        String nif= teclado.next();
        Cliente cliente = listaClientes.recuperarCliente(nif);
        System.out.println("Introduce el código de la factura: ");
        String codFact= teclado.next();
        System.out.println(cliente.recuperarFactura(codFact).facturaToString());
    }

    public void mostrarFacturas(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nif: ");
        String nif= teclado.next();
        Cliente cliente = listaClientes.recuperarCliente(nif);
        HashMap<String,Factura> listaFacturas = cliente.getFacturas();
        Set<String> codigosFacturas=listaFacturas.keySet();
        for(String codfactura: codigosFacturas){
            System.out.println(listaFacturas.get(codfactura).facturaToString());
        }
    }

    public void crearLlamadas(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Quién realiza la llamada? ");
        String cliente= teclado.next();
        System.out.println("Introduce el destino: ");
        String destino= teclado.next();
        System.out.println("Introduce la duración (minutos): ");
        Double duracion= teclado.nextDouble();
        Llamada llamada=new Llamada(destino,duracion);
        listaClientes.recuperarCliente(cliente).listadoLlamadas().add(llamada);
        System.out.println("Llamada realizada.");
    }

    public void listarLLamadas(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nif: ");
        String nif= teclado.next();
        Cliente clienteLlamadas = listaClientes.recuperarCliente(nif);
        for(Llamada llamadasCliente:clienteLlamadas.listadoLlamadas()){
            System.out.println(llamadasCliente.llamadaToString());
        }
    }
    public void despedida(){
        System.out.println("Adiós");
    }

    public void opcionInvalida(){
        System.out.println("Opción no válida, seleccione otra.");
    }
}
