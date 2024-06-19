package ar.edu.unlam.pb2;

public class PropiedadNoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L;

	public PropiedadNoEncontradaException(String mensaje) {
		super(mensaje);
	}
}
