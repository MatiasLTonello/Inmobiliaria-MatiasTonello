package ar.edu.unlam.pb2;

public class ClienteNoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

	public ClienteNoEncontradoException(String mensaje) {
		super(mensaje);
	}
}
