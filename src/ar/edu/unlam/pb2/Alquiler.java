package ar.edu.unlam.pb2;

public class Alquiler implements Operacion {
    private Propiedad propiedad;
    private Inquilino inquilino;
    private Integer duracion; 

    public Alquiler(Propiedad propiedad, Inquilino inquilino, int duracion) {
        this.propiedad = propiedad;
        this.inquilino = inquilino;
        this.duracion = duracion;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public Integer getDuracion() {
        return duracion;
    }
    
    public Boolean verificarDisponibilidadDeLaPropiedad()  {
    	return propiedad.getEstaAlquilada();
    }

	@Override
	public void realizar() throws PropiedadNoDisponibleException {
		if(verificarDisponibilidadDeLaPropiedad()) {
			throw new PropiedadNoDisponibleException("La propiedad ya esta alquilada!");
		}
		propiedad.setInquilino(inquilino);
	}
}