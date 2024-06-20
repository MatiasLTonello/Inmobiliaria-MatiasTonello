package ar.edu.unlam.pb2;

import java.util.ArrayList;
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

	public Boolean darDeAltaPropiedad(Propiedad nuevaPropiedad) throws UmbralMinimoNoAlcanzadoException {
		if (validarUmbralMinimoDeLaPropiedad(nuevaPropiedad)) {
			throw new UmbralMinimoNoAlcanzadoException("La propiedad no supera el umbral minimo!");
		}
		return propiedades.add(nuevaPropiedad);
	}

	private Boolean validarUmbralMinimoDeLaPropiedad(Propiedad propiedadAValidar) {
		if (propiedadAValidar.getTipoDeOperacion() == TipoDeOperacion.VENTA
				&& propiedadAValidar.getValor() < 10000.00) {
			return true;
		}
		return false;
	}

	public Boolean addCliente(Cliente cliente) {
		return clientes.add(cliente);
	}

	public Cliente buscarClientePorDNI(String dni) throws ClienteNoEncontradoException {
		for (Cliente cliente : clientes) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		throw new ClienteNoEncontradoException("No se encontró un Cliente con ese DNI");
	}

	private Boolean realizarOperacion(Operacion operacion) throws PropiedadNoDisponibleException {
		operacion.realizar();
		return operaciones.add(operacion);
	}

	public Boolean realizarOperacion(String dniDelCliente, Integer codigoDePropiedad, TipoDeOperacion tipo)
			throws ClienteNoEncontradoException, PropiedadNoEncontradaException, PropiedadNoDisponibleException {
		Cliente cliente = buscarClientePorDNI(dniDelCliente);
		Propiedad propiedadInvolucradaEnLaOperacion = buscarPropiedadPorCodigo(codigoDePropiedad);
		Operacion nuevaOperacion;
		if (comprobarEstadoDePropiedad(propiedadInvolucradaEnLaOperacion, tipo)) {
			if (tipo == TipoDeOperacion.VENTA) {
				nuevaOperacion = new Venta(propiedadInvolucradaEnLaOperacion, (Propietario) cliente);
			} else {
				nuevaOperacion = new Alquiler(propiedadInvolucradaEnLaOperacion, (Inquilino) cliente, 2);
			}
			return realizarOperacion(nuevaOperacion);
		}
		throw new PropiedadNoDisponibleException("La propiedad no esta disponible para esa operación!");
	}

	public Boolean comprobarEstadoDePropiedad(Propiedad propiedadAVerificar, TipoDeOperacion tipoDeOperacionARealizar) {
		return propiedadAVerificar.getTipoDeOperacion().equals(tipoDeOperacionARealizar);
	}

	private Propiedad buscarPropiedadPorCodigo(Integer codigoDePropiedad) throws PropiedadNoEncontradaException {
		for (Propiedad propiedad : propiedades) {
			if (propiedad.getCodigoDePropiedad().equals(codigoDePropiedad)) {
				return propiedad;
			}
		}
		throw new PropiedadNoEncontradaException("No se encontró una propiedad con ese código!");
	}

	public TreeSet<Propiedad> buscarPropiedadesPorRangoDePrecio(Double precioMinimo, Double precioMaximo,
			TipoDePropiedad tipo) throws SinResultadosException {
		TreeSet<Propiedad> casasEnRango = new TreeSet<>();

		for (Propiedad propiedad : propiedades) {
			if (tipo == TipoDePropiedad.CASA) {
				if (propiedad instanceof Casa && propiedad.getValor() >= precioMinimo
						&& propiedad.getValor() <= precioMaximo) {
					casasEnRango.add((Casa) propiedad);
				}
			} else {
				if (propiedad instanceof Departamento && propiedad.getValor() >= precioMinimo
						&& propiedad.getValor() <= precioMaximo) {
					casasEnRango.add((Departamento) propiedad);
				}
			}

		}

		if (casasEnRango.isEmpty()) {
			throw new SinResultadosException("No se encontraron casas en ese rango de Precio");
		}

		return casasEnRango;
	}

	public Double obtenerValorPromedioDePropiedades(TipoDePropiedad tipo) {
		Double valorTotal = 0.0;
		int cantidadDePropiedades = 0;
		for (Propiedad propiedad : propiedades) {
			if (tipo == TipoDePropiedad.CASA) {
				if (propiedad instanceof Casa) {
					valorTotal += propiedad.getValor();
					cantidadDePropiedades++;
				}
			} else {
				if (propiedad instanceof Departamento) {
					valorTotal += propiedad.getValor();
					cantidadDePropiedades++;
				}
			}
		}
		return cantidadDePropiedades > 0 ? valorTotal / cantidadDePropiedades : 0.0;
	}

	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Propiedad> buscarPropiedadesPorCiudad(String ciudad, TipoDePropiedad tipo)
			throws SinResultadosException {
		ArrayList<Propiedad> listaDePropiedadesPorUbicacion = new ArrayList<>();

		for (Propiedad propiedad : propiedades) {
			if (tipo == TipoDePropiedad.CASA) {
				if (propiedad instanceof Casa
						&& propiedad.getDireccion().getCiudad().toLowerCase().equals(ciudad.toLowerCase())) {
					listaDePropiedadesPorUbicacion.add((Casa) propiedad);
				}
			} else {
				if (propiedad instanceof Departamento
						&& propiedad.getDireccion().getCiudad().toLowerCase().equals(ciudad.toLowerCase())) {
					listaDePropiedadesPorUbicacion.add((Departamento) propiedad);
				}
			}

		}
		if (listaDePropiedadesPorUbicacion.isEmpty()) {
			throw new SinResultadosException("No se encontraron propiedades en esa ubicación");
		}
		return obtenerListadoDePropiedadesOrdenadasPorUbicacion(listaDePropiedadesPorUbicacion);
	}

	private ArrayList<Propiedad> obtenerListadoDePropiedadesOrdenadasPorUbicacion(ArrayList<Propiedad> propiedades) {
		propiedades.sort(new OrdenadorDePropiedadesPorUbicacion());
		return propiedades;
	}

	public Boolean realizarPermuta(Integer codigoDePropiedadX, Integer codigoDePropiedadY)
			throws PropiedadNoEncontradaException, PropiedadNoDisponibleException {
		Propiedad propiedadX = buscarPropiedadPorCodigo(codigoDePropiedadX);
		Propiedad propiedadY = buscarPropiedadPorCodigo(codigoDePropiedadY);
		Operacion nuevaPermuta;

		if (comprobarEstadoDePropiedad(propiedadX, TipoDeOperacion.PERMUTA)
				&& comprobarEstadoDePropiedad(propiedadY, TipoDeOperacion.PERMUTA)) {
			nuevaPermuta = new Permuta(propiedadX, propiedadY);
			return realizarOperacion(nuevaPermuta);
		}

		return false;
	}
}
