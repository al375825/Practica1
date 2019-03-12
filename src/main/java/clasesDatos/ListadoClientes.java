package clasesDatos;

import java.util.HashMap;

public class ListadoClientes {
    private HashMap<String, Cliente> lista;

    public ListadoClientes(){
        this.lista = new HashMap<String, Cliente>();
    }

    public void anadir(Cliente cliente) throws  ClienteException{
        if (lista.containsKey(cliente.getNif()))throw new ClienteException();
        lista.put(cliente.nif, cliente);
    }

    public void borrar(Cliente cliente){
        lista.remove(cliente.getNif());
    }

    public Cliente recuperarCliente(String nif){
        return lista.get(nif);
    }

    public HashMap<String, Cliente> recuperarListado(){
        return lista;
    }


}
