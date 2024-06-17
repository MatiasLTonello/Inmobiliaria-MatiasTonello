package ar.edu.unlam.pb2;

import java.util.Objects;

public class Direccion {

	private String ciudad;
	private String calle;
	private String numero;
	
	public Direccion(String ciudad, String calle, String numero) {
		this.ciudad = ciudad;
		this.calle = calle;
		this.numero = numero;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(calle, ciudad, numero);
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
		return Objects.equals(calle, other.calle) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(numero, other.numero);
	}
	
    @Override
    public String toString() {
        return "Direccion [Ciudad=" + ciudad + ", calle=" + calle + ", numero=" + numero + "]";
    }

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
