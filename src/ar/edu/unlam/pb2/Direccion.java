package ar.edu.unlam.pb2;

import java.util.Objects;

public class Direccion {

	private String localidad;
	private String calle;
	private String numero;
	
	public Direccion(String localidad, String calle, String numero) {
		this.localidad = localidad;
		this.calle = calle;
		this.numero = numero;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(calle, localidad, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(localidad, other.localidad)
				&& Objects.equals(numero, other.numero);
	}
	
    @Override
    public String toString() {
        return "Direccion [localidad=" + localidad + ", calle=" + calle + ", numero=" + numero + "]";
    }

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
