package main;

import clasesDatos.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    public ListadoClientes listaClientes = new ListadoClientes();

    public static void main (String[] args) throws ClienteException {
        new Menu().mostrarMenu();
    }
    public void mostrarMenu() throws ClienteException {
        Scanner teclado = new Scanner(System.in);
        Byte opcion;
        do {
            System.out.println("1. Clientes ");
            System.out.println("2. Facturas ");
            System.out.println("3. Llamadas ");
            System.out.println("4. Salir");
            System.out.print("Seleccione un menú: ");
            opcion = teclado.nextByte();
            seleccionarOpcion(opcion);
            System.out.println("Presione (1) para volver al menú");
            opcion = teclado.nextByte();
        }while(opcion==1);
        System.out.println("Adiós");
    }

    public void seleccionarOpcion(Byte opcion) throws ClienteException {
        switch(opcion){
            case 1: menuClientes();
                break;
            case 2: menuFacturas();
                break;
            case 3: menuLlamadas();
                break;
            case 4: System.out.println("Adiós");
                break;
            default: System.out.println("Opción no válida, seleccione otra.");
                break;
        }
    }

    public void menuClientes() throws ClienteException {
        System.out.println("1. Dar de alta (nuevo cliente)");
        System.out.println("2. Dar de baja (borrar cliente) ");
        System.out.println("3. Cambiar tarifa ");
        System.out.println("4. Recuperación de datos");
        System.out.println("5. Listado de clientes");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
        Scanner teclado = new Scanner(System.in);
        Byte opcion=teclado.nextByte();
        seleccionarOpcionClientes(opcion);
    }

    public void menuFacturas(){
        System.out.println("1. Emitir una factura");
        System.out.println("2. Recuperar una factura ");
        System.out.println("3. Mostrar todas las facturas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        Scanner teclado = new Scanner(System.in);
        Byte opcion=teclado.nextByte();
        seleccionarOpcionFacturas(opcion);
    }

    public void menuLlamadas(){
        System.out.println("1. Nueva llamada");
        System.out.println("2. Listar llamadas");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        Scanner teclado = new Scanner(System.in);
        Byte opcion=teclado.nextByte();
        seleccionarOpcionLlamadas(opcion);
    }

    public void seleccionarOpcionClientes(Byte opcion) throws ClienteException {
        Scanner teclado = new Scanner(System.in);
        switch(opcion){
            case 1: crearCliente();
                System.out.println("Cliente creado");
                break;
            case 2: System.out.println("Introduce el nif: ");
                String nif= teclado.next();
                Cliente cliente = listaClientes.recuperarCliente(nif);
                listaClientes.borrar(cliente);
                System.out.println("Cliente eliminado");
                break;
            case 3: System.out.println("Introduce el nif: ");
                nif= teclado.next();
                cliente = listaClientes.recuperarCliente(nif);
                System.out.println("Introduzca la nueva tarifa: ");
                Double dato = teclado.nextDouble();
                Tarifa tarifa = new Tarifa(dato);
                cliente.cambioTarifa(tarifa);
                System.out.println("Tarifa cambiada con éxito.");
                break;
            case 4:
                System.out.println("Introduce el nif: ");
                String dni= teclado.next();
                System.out.println(listaClientes.recuperarCliente(dni).clienteToString());
                break;
            case 5: HashMap<String,Cliente> lista = listaClientes.recuperarListado();
                Set<String> dnis= lista.keySet();
                for(String dnicliente:dnis){
                    Cliente datosCliente=listaClientes.recuperarCliente(dnicliente);
                    System.out.println(datosCliente.clienteToString());
                }
                break;
            case 6: System.out.println("Adiós");
                break;
            default: System.out.println("Opción no válida, seleccione otra.");
                break;
        }
    }

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
            listaClientes.añadir(nuevoCliente);
        } else {
            System.out.println("    Introduce los apellidos del cliente: ");
            String apellidos = teclado.next();
            Particular nuevoCliente = new Particular(apellidos, nombre, nif, dirCliente, correo, tarifa);
            listaClientes.añadir(nuevoCliente);
        }
    }

    public void seleccionarOpcionFacturas(Byte opcion){
        Scanner teclado = new Scanner(System.in);
        switch(opcion){
            case 1: System.out.println("Introduzca el dni del cliente de la factura: ");
                String nif= teclado.next();
                HashMap<String,Cliente> clientes=listaClientes.recuperarListado();
                Cliente clienteFactura=clientes.get(nif);
                System.out.println("Introduzca el código de la factura a emitir: ");
                String codFact= teclado.next();
                Factura facturaAEmitir=new Factura(codFact,clienteFactura);
                clienteFactura.getFacturas().put(codFact,facturaAEmitir);
                System.out.println(facturaAEmitir.facturaToString());
                break;
            case 2: System.out.println("Introduce el nif: ");
                nif= teclado.next();
                Cliente cliente = listaClientes.recuperarCliente(nif);
                System.out.println("Introduce el código de la factura: ");
                codFact= teclado.next();
                System.out.println(cliente.recuperarFactura(codFact).facturaToString());
                break;
            case 3: System.out.println("Introduce el nif: ");
                nif= teclado.next();
                cliente = listaClientes.recuperarCliente(nif);
                HashMap<String,Factura> listaFacturas = cliente.getFacturas();
                Set<String> codigosFacturas=listaFacturas.keySet();
                for(String codfactura: codigosFacturas){
                    System.out.println(listaFacturas.get(codfactura).facturaToString());
                }
                break;
            case 4: System.out.println("Adiós");
                break;
            default: System.out.println("Opción no válida, seleccione otra.");
                break;
        }
    }

    public void seleccionarOpcionLlamadas(Byte opcion){
        Scanner teclado = new Scanner(System.in);
        switch(opcion){
            case 1: System.out.println("¿Quién realiza la llamada? ");
                String cliente= teclado.next();
                System.out.println("Introduce el destino: ");
                String destino= teclado.next();
                System.out.println("Introduce la duración (minutos): ");
                Double duracion= teclado.nextDouble();
                Llamada llamada=new Llamada(destino,duracion);
                listaClientes.recuperarCliente(cliente).listadoLlamadas().add(llamada);
                System.out.println("Llamada realizada.");
                break;
            case 2: System.out.println("Introduce el nif: ");
                String nif= teclado.next();
                Cliente clienteLlamadas = listaClientes.recuperarCliente(nif);
                for(Llamada llamadasCliente:clienteLlamadas.listadoLlamadas()){
                    System.out.println(llamadasCliente.llamadaToString());
                }
                break;
            case 3: System.out.println("Adiós");
                break;
            default: System.out.println("Opción no válida, seleccione otra.");
                break;
        }
    }
}