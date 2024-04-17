package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private HashSet<Propiedad> casas;
	private final Integer CANTIDAD_MAXIMA_DE_CLIENTES = 100;
	private Propietario clientes[];

	public String getNombre() {
		return nombre;
	}

	public Boolean darDeAltaCasa(Propiedad nuevaCasa) {
		return casas.add(nuevaCasa);
	}

	public Boolean addCliente(Propietario cliente) {
	     
	        if (buscarClientePorDNI(cliente.getDni()) != null) {
	            System.out.println("Ya existe un cliente con el mismo DNI.");
	            return false; 
	        }

	        for (int i = 0; i < clientes.length; i++) {
	            if (clientes[i] == null) {
	                clientes[i] = cliente;
	                return true;
	            }
	        }

	        System.out.println("No hay espacio disponible para agregar más clientes.");
	        return false; 
	    }

	public Propietario buscarClientePorDNI(String dni) {
		for (Propietario cliente : clientes) {
			if (cliente != null && cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}

	 public List<Propiedad> buscarPorRangoDePrecio(double precioMinimo, double precioMaximo) {
	        List<Propiedad> propiedadesEnRango = new ArrayList<>(0);

	        for (Propiedad casa : casas) {
	            if (casa != null && casa.getValor() >= precioMinimo && casa.getValor() <= precioMaximo) {
	                propiedadesEnRango.add(casa);
	            }
	        }
	      if(propiedadesEnRango.size() == 0) {
	    	  return null;
	      }
	     return propiedadesEnRango;
	  }
	
	public void cambiarDueñoDePropiedad(Propietario cliente, Casa propiedad) {
		propiedad.setDueño(cliente);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public Double obtenerValorPromedioDeCasas() {
		Double valorPromedio = 0.00;
		Integer cantidadDeCasas = 0;
		for(Propiedad casa: casas) {
			if(casa instanceof Casa) {
				valorPromedio += casa.getValor();
				cantidadDeCasas++;
			}
		}
		return valorPromedio / cantidadDeCasas;
	}
	
	public Double obtenerValorPromedioDeDepartamentos() {
		Double valorPromedio = 0.00;
		Integer cantidadDeDepartamentos = 0;
		for(Propiedad departamento : casas) {
			if(departamento instanceof Departamento) {
				valorPromedio += departamento.getValor();
				cantidadDeDepartamentos++;
			}
		}
		return valorPromedio / cantidadDeDepartamentos;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Inmobiliaria(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
        this.casas = new HashSet<>();
		this.clientes = new Propietario[CANTIDAD_MAXIMA_DE_CLIENTES];
	}

	/* 	public void obtenerListadoDeCasasOrdenadasPorPrecio() {
		for (int i = 0; i < casas.length - 1; i++) {
			for (int j = 0; j < casas.length - i - 1; j++) {
				if (casas[j] != null && casas[j + 1] != null && casas[j].getPrecio() > casas[j + 1].getPrecio()) {
					Casa temp = casas[j];
					casas[j] = casas[j + 1];
					casas[j + 1] = temp;
				}
			}
		}

		System.out.println("Listado de casas ordenadas por precio:");
		for (Casa casa : casas) {
			if (casa != null) {
				System.out.println(casa.toString());
			}
		}
	}
	 * 
	 * 
	 * 
	 * public Casa buscarPropiedadPorCodigo(Integer codigo) {
		for (int i = 0; i < casas.length - 1; i++) {
			if (casas[i] != null && casas[i].getCodigo() == codigo) {
				return casas[i];
			}
		}
		return null;
	}

	public void obtenerListadoDeCasasOrdenadasPorUbicacion() {
		for (int i = 0; i < casas.length - 1; i++) {
			for (int j = 0; j < casas.length - i - 1; j++) {
				if (casas[j] != null && casas[j + 1] != null) {
					if(casas[j].getCiudad().compareTo(casas[j+1].getCiudad()) > 1) {
						Casa temp = casas[j];
						casas[j] = casas[j + 1];
						casas[j + 1] = temp;
					}
				}
			}
		}

		System.out.println("Listado de casas ordenadas por ubicación:");
		for (Propiedad casa : casas) {
			if (casa != null) {
				System.out.println(casa.toString());
			}
		}
		
	} */
}
