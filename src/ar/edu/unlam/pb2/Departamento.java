package ar.edu.unlam.pb2;

import java.util.Objects;

public class Departamento extends Propiedad {

	private Integer piso;
	private String departamento;
	
	public Departamento(Propietario dueño, Direccion direccion, Double valor,Integer codigoDePropiedad, Integer piso, String departamento) {
		super(dueño,direccion, valor, codigoDePropiedad);
		this.setPiso(piso);
		this.setDepartamento(departamento);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(departamento, piso);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(departamento, other.departamento) && Objects.equals(piso, other.piso);
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}