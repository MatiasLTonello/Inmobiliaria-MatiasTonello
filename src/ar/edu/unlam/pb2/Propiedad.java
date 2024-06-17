package ar.edu.unlam.pb2;

import java.util.Objects;

abstract public class Propiedad implements Comparable<Propiedad> {
	private Propietario dueño;
	private Inquilino inquilino;
	private Direccion direccion;
	private Double valor;
	private Integer codigoDePropiedad;
	private Boolean estaAlquilada;
	private TipoDeOperacion tipoDeOperacion;
	
	public Propiedad(Propietario dueño, Direccion direccion, Double valor, Integer codigoDePropiedad) {
		this.dueño = dueño;
		this.setDireccion(direccion);
		this.setValor(valor);
		this.setCodigoDePropiedad(codigoDePropiedad);
		this.setEstaAlquilada(false);
		this.tipoDeOperacion = TipoDeOperacion.VENTA;
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

	public Propietario getDueño() {
		return dueño;
	}

	public void setDueño(Propietario dueño) {
		this.dueño = dueño;
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
	            "Dueño: " + (dueño != null ? dueño.toString() : "No asignado") + ", " +
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
		int retorno = 0;
		if(this.getValor() > o.getValor()) {
			retorno = -1;
		} else if(this.getValor() < o.getValor()) {
			retorno = 1;
		}
		
		return retorno;
	}
	
	
	
	
	
}
