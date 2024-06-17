package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private HashSet<Propiedad> propiedades;
    private List<Operacion> operaciones;
	private HashSet<Cliente> clientes;


	public Inmobiliaria(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.propiedades = new HashSet<>();
		this.clientes = new HashSet<>();
		this.operaciones = new ArrayList<>();
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

	public Boolean addCliente(Cliente cliente) {
		return clientes.add(cliente);
	}

	public Cliente buscarClientePorDNI(String dni) {
		for (Cliente cliente : clientes) {
			if (cliente != null && cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}
	
    public void realizarOperacion(Operacion operacion) {
        operacion.realizar();
        operaciones.add(operacion);
    }
	
    public TreeSet<Propiedad> buscarPropiedadesPorRangoDePrecio(double precioMinimo, double precioMaximo, TipoDePropiedad tipo) throws SinResultadosException {
        TreeSet<Propiedad> casasEnRango = new TreeSet<>();

        for (Propiedad propiedad : propiedades) {
        	if(tipo == TipoDePropiedad.CASA) {
        		  if (propiedad instanceof Casa  && propiedad.getValor() >= precioMinimo && propiedad.getValor() <= precioMaximo) {
                      casasEnRango.add((Casa) propiedad);
                  }
        	} else {
        		 if (propiedad instanceof Departamento  && propiedad.getValor() >= precioMinimo && propiedad.getValor() <= precioMaximo) {
                     casasEnRango.add((Departamento) propiedad);
                 }
        	}
          
        }
        
        if(casasEnRango.isEmpty()) {
        	throw new SinResultadosException("No se encontraron casas en ese rango de Precio");
        }

        return casasEnRango;
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

	public Propiedad buscarPropiedadPorCodigo(Integer codigo) {
		for (Propiedad propiedad : propiedades) {
			if (propiedad != null && propiedad.getCodigoDePropiedad().equals(codigo)) {
				return propiedad;
			}
		}
		return null;
	}

	public void alquilarPropiedad(Cliente inquilino, Propiedad propiedadAAlquilar) {
		propiedadAAlquilar.setEstaAlquilada(true);
		propiedadAAlquilar.setInquilino((Inquilino) inquilino);
	}

	public ArrayList<Propiedad> buscarPropiedadesPorCiudad(String ciudad, TipoDePropiedad tipo) throws SinResultadosException {
		ArrayList<Propiedad> listaDePropiedadesPorUbicacion = new ArrayList<>();
		for (Propiedad propiedad : propiedades) {
			if(tipo == TipoDePropiedad.CASA) {
				if(propiedad instanceof Casa && propiedad.getDireccion().getCiudad().equals(ciudad)) {
					listaDePropiedadesPorUbicacion.add((Casa) propiedad);
				}
			} else {
				if(propiedad instanceof Departamento && propiedad.getDireccion().getCiudad().equals(ciudad)) {
					listaDePropiedadesPorUbicacion.add((Departamento) propiedad);
				}
			}
		
		}
		if(listaDePropiedadesPorUbicacion.isEmpty()) {
			throw new SinResultadosException("No se encontraron propiedades en esa ubicación");
		}
		return obtenerListadoDePropiedadesOrdenadasPorUbicacion(listaDePropiedadesPorUbicacion);
	}
	
	private ArrayList<Propiedad> obtenerListadoDePropiedadesOrdenadasPorUbicacion(ArrayList <Propiedad> propiedades) {
		Collections.sort(propiedades, new OrdenadorDePropiedadesPorUbicacion());
		return propiedades;
	}
}
