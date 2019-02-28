package ClasesDatos;

import java.util.HashMap;

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

    public HashMap<String, Cliente> recuperarListado(){
        return lista;
    }



}
