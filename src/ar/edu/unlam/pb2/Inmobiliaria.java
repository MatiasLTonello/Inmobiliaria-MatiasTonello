package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Inmobiliaria {

    private String nombre;
    private String direccion;
    private HashSet<Propiedad> propiedades;
    private HashSet<Propietario> propietarios;
    private HashSet<Inquilino> inquilinos;

    public Inmobiliaria(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.propiedades = new HashSet<>();
        this.propietarios = new HashSet<>();
        this.inquilinos = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean darDeAltaPropiedad(Propiedad nuevaPropiedad) {
        return propiedades.add(nuevaPropiedad);
    }

    public Boolean addCliente(Propietario propietario) {
        return propietarios.add(propietario);
    }

    public Propietario buscarClientePorDNI(String dni) {
        for (Propietario propietario : propietarios) {
            if (propietario != null && propietario.getDni().equals(dni)) {
                return propietario;
            }
        }
        return null;
    }

    public List<Propiedad> buscarPorRangoDePrecio(double precioMinimo, double precioMaximo) {
        List<Propiedad> propiedadesEnRango = new ArrayList<>();

        for (Propiedad propiedad : propiedades) {
            if (propiedad != null && propiedad.getValor() >= precioMinimo && propiedad.getValor() <= precioMaximo) {
                propiedadesEnRango.add(propiedad);
            }
        }
        if (propiedadesEnRango.isEmpty()) {
            return null;
        }
        return propiedadesEnRango;
    }

    public void cambiarDueñoDePropiedad(Propietario nuevoPropietario, Propiedad propiedad) {
        propiedad.setDueño(nuevoPropietario);
    }

    public Double obtenerValorPromedioDeCasas() {
        double valorTotal = 0.0;
        int cantidadDeCasas = 0;
        for (Propiedad propiedad : propiedades) {
            if (propiedad instanceof Casa) {
                valorTotal += propiedad.getValor();
                cantidadDeCasas++;
            }
        }
        return cantidadDeCasas > 0 ? valorTotal / cantidadDeCasas : 0.0;
    }

    public Double obtenerValorPromedioDeDepartamentos() {
        double valorTotal = 0.0;
        int cantidadDeDepartamentos = 0;
        for (Propiedad propiedad : propiedades) {
            if (propiedad instanceof Departamento) {
                valorTotal += propiedad.getValor();
                cantidadDeDepartamentos++;
            }
        }
        return cantidadDeDepartamentos > 0 ? valorTotal / cantidadDeDepartamentos : 0.0;
    }

    public void obtenerListadoDePropiedadesOrdenadasPorPrecio() {
        List<Propiedad> listaPropiedades = new ArrayList<>(propiedades);
        Collections.sort(listaPropiedades, new Comparator<Propiedad>() {
            @Override
            public int compare(Propiedad p1, Propiedad p2) {
                return Double.compare(p1.getValor(), p2.getValor());
            }
        });

        System.out.println("Listado de propiedades ordenadas por precio:");
        for (Propiedad propiedad : listaPropiedades) {
            System.out.println(propiedad.toString());
        }
    }

    public Propiedad buscarPropiedadPorCodigo(Integer codigo) {
        for (Propiedad propiedad : propiedades) {
            if (propiedad != null && propiedad.getCodigoDePropiedad().equals(codigo)) {
                return propiedad;
            }
        }
        return null;
    }

    public void obtenerListadoDePropiedadesOrdenadasPorUbicacion() {
        List<Propiedad> listaPropiedades = new ArrayList<>(propiedades);
        Collections.sort(listaPropiedades, new Comparator<Propiedad>() {
            @Override
            public int compare(Propiedad p1, Propiedad p2) {
                return p1.getDireccion().getLocalidad().compareTo(p2.getDireccion().getLocalidad());
            }
        });

        System.out.println("Listado de propiedades ordenadas por ubicación:");
        for (Propiedad propiedad : listaPropiedades) {
            System.out.println(propiedad.toString());
        }
    }

    public void alquilarPropiedad(Cliente inquilino, Propiedad propiedadAAlquilar) {
        propiedadAAlquilar.setEstaAlquilada(true);
        propiedadAAlquilar.setInquilino((Inquilino)inquilino);
    }

	public void buscarPorCiudad(String ciudad) {
        List<Propiedad> listaPropiedades = new ArrayList<>(propiedades);
		for(Propiedad propiedad : listaPropiedades) {
			System.out.println(propiedad.toString());
		}
	}

	public void buscarPropiedadesPorTipoDeOperacion(TipoDeOperacion operacion) {
	       List<Propiedad> listaPropiedades = new ArrayList<>(propiedades);
			for(Propiedad propiedad : listaPropiedades) {
				if(propiedad.getTipoDeOperacion() == operacion) {
				System.out.println(propiedad.toString());
				}
			}
	}
}
