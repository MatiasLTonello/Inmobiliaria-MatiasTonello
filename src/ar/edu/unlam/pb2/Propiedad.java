package ar.edu.unlam.pb2;

import java.util.Objects;

abstract public class Propiedad implements Comparable<Propiedad> {
	private Propietario propietario;
	private Inquilino inquilino;
	private Direccion direccion;
	private Double valor;
	private Integer codigoDePropiedad;
	private Boolean estaAlquilada;
	private TipoDeOperacion tipoDeOperacion;
	
	public Propiedad(Propietario propietario, Direccion direccion, Double valor, Integer codigoDePropiedad, TipoDeOperacion tipo) {
		this.propietario = propietario;
		this.setDireccion(direccion);
		this.setValor(valor);
		this.setCodigoDePropiedad(codigoDePropiedad);
		this.setEstaAlquilada(false);
		this.tipoDeOperacion = tipo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(direccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propiedad other = (Propiedad) obj;
		return Objects.equals(direccion, other.direccion);
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getCodigoDePropiedad() {
		return codigoDePropiedad;
	}

	public void setCodigoDePropiedad(Integer codigoDePropiedad) {
		this.codigoDePropiedad = codigoDePropiedad;
	}

	public Boolean getEstaAlquilada() {
		return estaAlquilada;
	}

	public void setEstaAlquilada(Boolean estaAlquilada) {
		this.estaAlquilada = estaAlquilada;
	}

	public TipoDeOperacion getTipoDeOperacion() {
		return tipoDeOperacion;
	}

	public void setTipoDeOperacion(TipoDeOperacion tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}
	
	@Override
	public String toString() {
	    return "Propiedad {" +
	            "Dueño: " + (propietario != null ? propietario.toString() : "No asignado") + ", " +
	            "Inquilino: " + (inquilino != null ? inquilino.toString() : "No asignado") + ", " +
	            "Dirección: " + (direccion != null ? direccion.toString() : "No asignada") + ", " +
	            "Valor: " + (valor != null ? "$" + valor : "No asignado") + ", " +
	            "Código de Propiedad: " + (codigoDePropiedad != null ? codigoDePropiedad : "No asignado") + ", " +
	            "Está Alquilada: " + (estaAlquilada != null ? (estaAlquilada ? "Sí" : "No") : "No asignado") + ", " +
	            "Tipo de Operación: " + (tipoDeOperacion != null ? tipoDeOperacion.toString() : "No asignado") +
	            " }";
	}
	
	@Override
	public int compareTo(Propiedad o) {
		return o.getValor().compareTo(this.getValor());
	}	
}
