package clasesDatos;

public class ClienteException extends Exception {
    public ClienteException(){
        super("Ese cliente ya existe.");
    }
}
