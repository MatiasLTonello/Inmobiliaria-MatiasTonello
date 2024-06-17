package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Propietario extends Cliente {

	public Propietario(String apellido, String dni) {
		super(apellido, dni);
		this.setPropiedades(new ArrayList<>());
	}

	private ArrayList<Propiedad> propiedades;
	
	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(ArrayList<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	
	
	
}
