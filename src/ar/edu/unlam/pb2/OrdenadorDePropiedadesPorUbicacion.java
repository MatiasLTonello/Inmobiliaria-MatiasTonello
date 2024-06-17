package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenadorDePropiedadesPorUbicacion implements Comparator<Propiedad> {

	   @Override
		public int compare(Propiedad p1, Propiedad p2) {
			return p1.getDireccion().getCiudad().compareTo(p2.getDireccion().getCiudad());
		}
}
