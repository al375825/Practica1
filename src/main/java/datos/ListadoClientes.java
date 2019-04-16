package datos;

import datos.cliente.Cliente;
import datos.cliente.ClienteException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ListadoClientes implements Serializable {
    private HashMap<String, Cliente> lista;

    public ListadoClientes(){
        this.lista = new HashMap<String, Cliente>();
    }

    public void anadir(Cliente cliente) throws ClienteException {
        if (lista.containsKey(cliente.getNif()))throw new ClienteException();
        lista.put(cliente.getNif(), cliente);
    }

    public void borrar(Cliente cliente){
        lista.remove(cliente.getNif());
    }

    public Cliente recuperarCliente(String nif){
        return lista.get(nif);
    }

    public ArrayList<Cliente> recuperarListado(){
        ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
        for(String clave: lista.keySet()){
            listaClientes.add(lista.get(clave));
        }
        return listaClientes;
    }


}
