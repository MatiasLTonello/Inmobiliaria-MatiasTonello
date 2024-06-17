package ar.edu.unlam.pb2;

public class Venta implements Operacion {
    private Propiedad propiedad;
    private Propietario nuevoPropietario;

    public Venta(Propiedad propiedad, Propietario nuevoPropietario) {
        this.propiedad = propiedad;
        this.nuevoPropietario = nuevoPropietario;
    }

    public void realizar() {
        propiedad.setDueño(nuevoPropietario);
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public Propietario getNuevoPropietario() {
        return nuevoPropietario;
    }
}