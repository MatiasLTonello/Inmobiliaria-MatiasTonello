package ar.edu.unlam.pb2;

public class Inquilino extends Cliente {

	private Propiedad propiedadAlquilada;
	
	public Inquilino(String apellido, String dni) {
		super(apellido, dni);
	}
	
	public Propiedad getPropiedadAlquilada() {
		return propiedadAlquilada;
	}
	public void setPropiedadAlquilada(Propiedad propiedadAlquilada) {
		this.propiedadAlquilada = propiedadAlquilada;
	}


}
