package clasesDatos;

import java.util.HashMap;
import java.util.Set;

public class ListadoClientes {
    private HashMap<String, Cliente> lista;

    public ListadoClientes(){
        this.lista = new HashMap<String, Cliente>();
    }

    public void añadir(Cliente cliente){
        lista.put(cliente.nif, cliente);
    }

    public void borrar(Cliente cliente){
        lista.remove(cliente.nif);
    }

    public Cliente recuperarCliente(String nif){
        return lista.get(nif);
    }

    public HashMap<String, Cliente> getLista(){
        return this.lista;
    }

    public HashMap<String, Cliente> recuperarListado(){
        Set<String> dnis= lista.keySet();
        for(String cliente:dnis){
            System.out.println(cliente);
        }
        return lista;
    }



}
