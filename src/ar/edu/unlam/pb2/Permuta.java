package ar.edu.unlam.pb2;

public class Permuta implements Operacion {
    private Propiedad propiedadX;
    private Propiedad propiedadY;

    public Permuta(Propiedad propiedadX, Propiedad propiedadY) {
        this.propiedadX = propiedadX;
        this.propiedadY = propiedadY;
    }

	@Override
	public void realizar() {
		Propietario propietarioDeLaCasaX = propiedadX.getDueño();
		Propietario propietarioDeLaCasaY = propiedadY.getDueño();
		
		propiedadX.setDueño(propietarioDeLaCasaY);
		propiedadY.setDueño(propietarioDeLaCasaX);
	}

    

}