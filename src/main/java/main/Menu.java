package main;

import clasesDatos.Cliente;
import clasesDatos.ListadoClientes;
import clasesDatos.Tarifa;

import java.util.Scanner;

public class Menu {
    public void mostrarMenu(){
        System.out.println("Seleccione un menú: ");
        System.out.println("1. Clientes ");
        System.out.println("2. Facturas ");
        System.out.println("3. Llamadas ");
        System.out.println("4. Salir");
        Scanner teclado = new Scanner(System.in);
        Byte opcion=teclado.nextByte();
        seleccionarOpcion(opcion);
    }

    public void seleccionarOpcion(Byte opcion){
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

    public void menuClientes(){
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Dar de alta (nuevo cliente)");
        System.out.println("2. Dar de baja (borrar cliente) ");
        System.out.println("3. Cambiar tarifa ");
        System.out.println("4. Recuperación de datos");
        System.out.println("5. Listado de clientes");
        System.out.println("6. Salir");
        Scanner teclado = new Scanner(System.in);
        Byte opcion=teclado.nextByte();
        seleccionarOpcionClientes(opcion);
    }

    public void menuFacturas(){
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Emitir una factura");
        System.out.println("2. Recuperar una factura ");
        System.out.println("3. Mostrar todas las facturas");
        System.out.println("4. Salir");
        Scanner teclado = new Scanner(System.in);
        Byte opcion=teclado.nextByte();
        seleccionarOpcionFacturas(opcion);
    }

    public void menuLlamadas(){
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Nueva llamada");
        System.out.println("2. Listar llamadas");
        System.out.println("3. Salir");
        Scanner teclado = new Scanner(System.in);
        Byte opcion=teclado.nextByte();
        seleccionarOpcionLlamadas(opcion);
    }

    public void seleccionarOpcionClientes(Byte opcion){
        Scanner teclado = new Scanner(System.in);
        switch(opcion){
            case 1: //crearCliente();
                break;
            case 2: System.out.println("Introduce el nif: ");
                String nif= teclado.next();
                Cliente cliente = new ListadoClientes().recuperarCliente(nif);
                new ListadoClientes().borrar(cliente);
                break;
            case 3: System.out.println("Introduce el nif: ");
                nif= teclado.next();
                cliente = new ListadoClientes().recuperarCliente(nif);
                System.out.println("Introduzca la nueva tarifa: ");
                Double dato = teclado.nextDouble();
                Tarifa tarifa = new Tarifa(dato);
                cliente.cambioTarifa(tarifa);
                break;
            case 4:
                System.out.println("Introduce el nif: ");
                String dni= teclado.next();
                new ListadoClientes().recuperarCliente(dni);
                break;
            case 5: new ListadoClientes().recuperarListado();
                break;
            case 6: System.out.println("Adiós");
                break;
            default: System.out.println("Opción no válida, seleccione otra.");
                break;
        }
    }

    public void seleccionarOpcionFacturas(Byte opcion){
        Scanner teclado = new Scanner(System.in);
        switch(opcion){
            case 1: //emitirFactura();
                break;
            case 2: //recuperarFactura();
                break;
            case 3: //mostrarFactura();
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
            case 1: //crearLlamada();
                break;
            case 2: System.out.println("Introduce el nif: ");
                String nif= teclado.next();
                Cliente cliente = new ListadoClientes().recuperarCliente(nif);
                cliente.listadoLlamadas();
                break;
            case 3: System.out.println("Adiós");
                break;
            default: System.out.println("Opción no válida, seleccione otra.");
                break;
        }
    }
}
