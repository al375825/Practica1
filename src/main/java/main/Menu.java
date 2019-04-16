package main;

import datos.*;

import java.util.Scanner;

public class Menu{
    private Aplicacion aplicacion = new Aplicacion();

    public static void main (String[] args) throws ClienteException {
        new Menu().mostrarMenu();

    }
    public void mostrarMenu() throws ClienteException {
        aplicacion.leerDesdeFichero("fichero.bin");
        Scanner teclado = new Scanner(System.in);
        Byte opcion;
        // todo Si es 4 que salga del bucle.
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
        aplicacion.guardarEnFichero("fichero.bin", aplicacion.listaClientes);
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
        System.out.println("6. Listado de clientes entre dos fechas");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
        Scanner teclado = new Scanner(System.in);
        Byte opcion=teclado.nextByte();
        seleccionarOpcionClientes(opcion);
    }

    public void menuFacturas(){
        System.out.println("1. Emitir una factura");
        System.out.println("2. Recuperar una factura ");
        System.out.println("3. Mostrar todas las facturas");
        System.out.println("4. Listado de facturas entre dos fechas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        Scanner teclado = new Scanner(System.in);
        Byte opcion=teclado.nextByte();
        seleccionarOpcionFacturas(opcion);
    }

    public void menuLlamadas(){
        System.out.println("1. Nueva llamada");
        System.out.println("2. Listar llamadas");
        System.out.println("3. Listado de llamadas entre dos fechas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        Scanner teclado = new Scanner(System.in);
        Byte opcion=teclado.nextByte();
        seleccionarOpcionLlamadas(opcion);
    }

    // todo No debéis desentenderos de la excepción.
    public void seleccionarOpcionClientes(Byte opcion) throws ClienteException {
        switch(opcion){
            case 1: aplicacion.crearCliente();
                break;
            case 2: aplicacion.eliminarCliente();
                break;
            case 3: aplicacion.cambioTarifa();
                break;
            case 4: aplicacion.recuperarDatos();
                break;
            case 5: aplicacion.listarClientes();
                break;
            case 6: aplicacion.clientesIntervalo();
                break;
            case 7: aplicacion.despedida();
                break;
            default: aplicacion.opcionInvalida();
                break;
        }
    }



    public void seleccionarOpcionFacturas(Byte opcion){
        switch(opcion){
            case 1: aplicacion.emitirFactura();
                break;
            case 2: aplicacion.recuperarFactura();
                break;
            case 3: aplicacion.mostrarFacturas();
                break;
            case 4: aplicacion.facturasIntervalo();
                break;
            case 5: aplicacion.despedida();
                break;
            default: aplicacion.opcionInvalida();
                break;
        }
    }

    public void seleccionarOpcionLlamadas(Byte opcion){
        switch(opcion){
            case 1: aplicacion.crearLlamadas();
                break;
            case 2: aplicacion.listarLLamadas();
                break;
            case 3: aplicacion.llamadasIntervalo();
                break;
            case 4: aplicacion.despedida();
                break;
            default: aplicacion.opcionInvalida();
                break;
        }
    }
}