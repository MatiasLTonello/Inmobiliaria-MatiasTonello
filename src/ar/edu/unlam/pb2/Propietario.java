package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Propietario extends Cliente {

	public Propietario(String apellido, String dni) {
		super(apellido, dni);
		this.setPropiedades(new ArrayList<>());
	}
	private String apellido;
	private String dni;
	private ArrayList<Propiedad> propiedades;
	
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
	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(ArrayList<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}
	
	
	
}
