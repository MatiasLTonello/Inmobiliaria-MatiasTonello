package ar.edu.unlam.pb2;

public class Propietario {

	private String apellido;
	private String dni;
	private Casa casas[];
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public Propietario(String apellido, String dni) {
		this.apellido = apellido;
		this.dni = dni;
		this.casas = new Casa[200];
	}
	
	
}
