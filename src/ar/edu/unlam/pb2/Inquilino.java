package ar.edu.unlam.pb2;

public class Inquilino {

	private String apellido;
	private String dni;
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDni() {
		return dni;
	}
	
	public Inquilino(String apellido, String dni) {
		super();
		this.apellido = apellido;
		this.dni = dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
