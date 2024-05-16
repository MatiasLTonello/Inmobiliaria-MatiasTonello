package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfazInmobiliaria {
	private static Scanner teclado = new Scanner(System.in);
	private static Inmobiliaria actual = new Inmobiliaria("Lo de mati", "Salguero");
	private static Integer CODIGO_DE_PROPIEDAD_SIGUIENTE = 1;

	public static void main(String[] args) {
		Integer opcionSeleccionada;

		do {
			mostrarMenu();
			opcionSeleccionada = teclado.nextInt();
			ejecutarOpcion(opcionSeleccionada);
		} while (opcionSeleccionada != 9);

		teclado.close();
	}

	private static void mostrarMenu() {
		System.out.println("Menu de opciones");
		System.out.println("0. Buscar propiedades por a.Rango de precios b.Ciudad c.Venta o alquiler");
		System.out.println("1. Agregar nuevas propiedades");
		System.out.println("2. Modificar propiedad existentes");
		System.out.println("3. Agregar Clientes");
		System.out.println("4. Obtener listado de propiedades ordenado por precio.");
		System.out.println("5. Obtener el listado de propiedades ordenado por ubicación.");
		System.out.println("6. a.Buscar Propiedades por rango de precio b.	Ubicación (Ciudad)");
		System.out.println("7. Realizar la venta de una propiedad");
		System.out.println("8. Realizar el aquiler de una propiedad");
		System.out.println("9. Salir");
	}

	private static void ejecutarOpcion(Integer opcion) {
		switch (opcion) {
		case 0:
			buscarPropiedadesPorDistintosParametros();
			break;
		case 1:
			agregarNuevaPropiedad();
			break;
		case 2:
			modificarPropiedadExistente();
			break;
		case 3:
			agregarCliente();
			break;
		case 4:
			obtenerListadoDePropiedadesPorPrecio();
			break;
		case 5:
			obtenerListadoDePropiedadesPorUbicacion();
			break;
		case 6:
			obtenerListadoFiltrado();
			break;
		case 7:
			realizarVentaDePropiedad();
			break;
		case 8:
			realizarAlquilerDePropiedad();
			break;
		case 9:
			System.out.println("Saliste del menú");
			break;
		default:
			System.out.println("Opción no válida.");
			break;
		}
	}

	private static void buscarPropiedadesPorDistintosParametros() {
			do {
				System.out.println("Ingrese si es para filtrar por Rango de Precios (P) o Ubicacion (U) o Tipo (T): ");
				String tipoInput = teclado.next().toUpperCase();
				if (tipoInput.equals("P")) {
					obtenerListadoDePropiedadesEnUnRangoDePrecios();
					break;
				} else if (tipoInput.equals("U")) {
					obtenerListadoDePropiedadesEnUnaUbicacion();
					break;
				} else if (tipoInput.equals("T")) {
					obtenerListadoDePropiedadesPorTipo();
					break;
				} else {
					System.out.println("Tipo de operación no válido. Por favor, ingrese P, U o T.");
				}
			} while (true);
		}
	

	private static void obtenerListadoDePropiedadesPorTipo() {
		do {
			System.out.println("Ingrese si desea filtrar por Venta (V) o Alquiler (A) ");
			String tipoInput = teclado.next().toUpperCase();
			if (tipoInput.equals("V")) {
				actual.buscarPropiedadesPorTipoDeOperacion(TipoDeOperacion.VENTA);
				break;
			} else if (tipoInput.equals("A")) {
				actual.buscarPropiedadesPorTipoDeOperacion(TipoDeOperacion.ALQUILER);
				break;
			} else {
				System.out.println("Tipo de operación no válido. Por favor, ingrese V O A.");
			}
		} while (true);
		
	}

	private static void obtenerListadoDePropiedadesEnUnaUbicacion() {
		String ciudad;
		System.out.println("Ingrese la ciudad donde desea buscar las propiedades : ");
		ciudad = teclado.next();
		
		actual.buscarPorCiudad(ciudad);
	}

	private static void obtenerListadoDePropiedadesEnUnRangoDePrecios() {
		Double rango1, rango2;
		System.out.println("Ingrese el valor minimo desde donde quiere filtrar: ");
		rango1 = teclado.nextDouble();
		System.out.println("Ingrese el valor maximo desde donde quiere filtrar: ");
		rango2 = teclado.nextDouble();
		
		List<Propiedad> propiedadesEnEseRango = actual.buscarPorRangoDePrecio(rango1, rango2);
		
		for(Propiedad prop:propiedadesEnEseRango) {
			prop.toString();
		}
	}

	private static void realizarAlquilerDePropiedad() {
	    Scanner teclado = new Scanner(System.in);
	    
	    System.out.println("Ingrese el código de la propiedad a alquilar : ");
	    Integer codigoDePropiedadAAlquilar = teclado.nextInt();
	    
	    Propiedad propiedadAAlquilar = actual.buscarPropiedadPorCodigo(codigoDePropiedadAAlquilar);
	    if (propiedadAAlquilar == null) {
	        System.out.println("La propiedad con el código ingresado no existe.");
	        return;
	    }
	    
	    if (propiedadAAlquilar.getEstaAlquilada()) {
	        System.out.println("La propiedad ya está alquilada.");
	        return;
	    }
	    
	    System.out.println("Ingrese el DNI del inquilino:");
	    String dniInquilino = teclado.next();
	    
	    Cliente inquilino = actual.buscarClientePorDNI(dniInquilino);
	    if (inquilino == null) {
	        System.out.println("El inquilino con el DNI ingresado no existe.");
	        return;
	    }
	    
	    actual.alquilarPropiedad(inquilino, propiedadAAlquilar);
	    System.out.println("La propiedad se ha alquilado con éxito.");
	}

	private static void realizarVentaDePropiedad() {
		Integer codigoDePropiedadAVender;
		String dniNuevoDueño;
		System.out.println("Ingrese el código de la propiedad a vender : ");
		codigoDePropiedadAVender = teclado.nextInt();
		Propiedad propiedadAVender = actual.buscarPropiedadPorCodigo(codigoDePropiedadAVender);
		System.out.println("Ingrese el DNI del nuevo dueño");
		dniNuevoDueño = teclado.next();
		Propietario nuevoDueño = actual.buscarClientePorDNI(dniNuevoDueño);
		
		actual.cambiarDueñoDePropiedad(nuevoDueño, propiedadAVender);
		
	}

	private static void obtenerListadoFiltrado() {
		do {
			System.out.println("Ingrese si es para filtrar por Precio (P) o Ubicacion (U): ");
			String tipoInput = teclado.next().toUpperCase();
			if (tipoInput.equals("P")) {
				obtenerListadoDePropiedadesPorPrecio();
				break;
			} else if (tipoInput.equals("U")) {
				obtenerListadoDePropiedadesPorUbicacion();
				break;
			} else {
				System.out.println("Tipo de operación no válido. Por favor, ingrese P o U.");
			}
		} while (true);
	}

	private static void obtenerListadoDePropiedadesPorUbicacion() {
		actual.obtenerListadoDePropiedadesOrdenadasPorUbicacion();		
	}

private static void agregarNuevaPropiedad() {
    Scanner teclado = new Scanner(System.in);

    String calle, ciudad, numero, dni;
    Double precio;
    TipoDeOperacion tipo;
    Clasificacion clasificacion;

    System.out.println("Ingrese la calle de la propiedad : ");
    calle = teclado.next();
    System.out.println("Ingrese la ciudad de la propiedad: ");
    ciudad = teclado.next();
    System.out.println("Ingrese el numero de la propiedad: ");
    numero = teclado.next();
    System.out.println("Ingrese el precio :");
    precio = teclado.nextDouble();
    System.out.println("Ingrese el dni del duenio:");
    dni = teclado.next();

    do {
        System.out.println("Ingrese si es para Alquiler (A) o Venta (V): ");
        String tipoInput = teclado.next().toUpperCase();
        if (tipoInput.equals("A")) {
            tipo = TipoDeOperacion.ALQUILER;
            break;
        } else if (tipoInput.equals("V")) {
            tipo = TipoDeOperacion.VENTA;
            break;
        } else {
            System.out.println("Tipo de operación no válido. Por favor, ingrese A o V.");
        }
    } while (true);
    
    do {
        System.out.println("Ingrese su clasificación Casa(C), Departamento(D), PH (P), Terreno (T), Campo (E): ");
        String tipoInput = teclado.next().toUpperCase();
        if (tipoInput.equals("C")) {
            clasificacion = Clasificacion.CASA;
            break;
        } else if (tipoInput.equals("D")) {
            clasificacion = Clasificacion.DEPARTAMENTO;
            break;
        } else if(tipoInput.equals("P")) {
            clasificacion = Clasificacion.PH;
            break;
        } else if(tipoInput.equals("T")) {
            clasificacion = Clasificacion.TERRENO;
            break;
        } else if(tipoInput.equals("E")) {
            clasificacion = Clasificacion.CAMPO;
            break;
        } else {
            System.out.println("Clasificación no válida. Por favor, ingrese C, D, P, T o E.");
        }
    } while (true);

    Propiedad nuevaPropiedad = null;
    Direccion nuevaDirecc = new Direccion(calle, ciudad, numero);
    Propietario propi = null;
    if(actual.buscarClientePorDNI(dni) == null) {
    	System.out.println("No se encontro un cliente con ese dni");
    	return;
    } else {
    	propi = actual.buscarClientePorDNI(dni);
    }
    
    if (clasificacion == Clasificacion.CASA) {
        nuevaPropiedad = new Casa(propi, nuevaDirecc, precio, CODIGO_DE_PROPIEDAD_SIGUIENTE);
    } else if (clasificacion == Clasificacion.DEPARTAMENTO) {
        nuevaPropiedad = new Departamento(propi, nuevaDirecc, precio, CODIGO_DE_PROPIEDAD_SIGUIENTE,1, "2");
    } else if (clasificacion == Clasificacion.PH) {
        nuevaPropiedad = new PH(propi, nuevaDirecc, precio, CODIGO_DE_PROPIEDAD_SIGUIENTE);
    } else if (clasificacion == Clasificacion.TERRENO) {
        nuevaPropiedad = new Terreno(propi, nuevaDirecc, precio, CODIGO_DE_PROPIEDAD_SIGUIENTE);
    } else if (clasificacion == Clasificacion.CAMPO) {
        nuevaPropiedad = new Campo(propi, nuevaDirecc, precio, CODIGO_DE_PROPIEDAD_SIGUIENTE);
    }

    if (nuevaPropiedad != null && actual.darDeAltaPropiedad(nuevaPropiedad)) {
        System.out.println("Propiedad agregada correctamente");
        CODIGO_DE_PROPIEDAD_SIGUIENTE++;
    } else {
        System.out.println("Error al agregar la propiedad");
    }
}
	private static void modificarPropiedadExistente() {
		Integer codigo;
		System.out.println("Ingrese el codigo de propiedad que desea modificar ");
		codigo = teclado.nextInt();

		Propiedad propiedadAModificar = actual.buscarPropiedadPorCodigo(codigo);

		if (propiedadAModificar != null) {
			String calle, localidad;
			Double precio;
			System.out.println("Ingrese la calle de la propiedad : ");
			calle = teclado.next();
			System.out.println("Ingrese la localidad de la propiedad: ");
			localidad = teclado.next();
			System.out.println("Ingrese el precio :");
			precio = teclado.nextDouble();

			propiedadAModificar.getDireccion().setCalle(calle);
			propiedadAModificar.getDireccion().setLocalidad(localidad);
			propiedadAModificar.setValor(precio);
			System.out.println("Propiedad modificada correctamente");
		} else {
			System.out.println("No se encontró propiedad con ese código");
		}

	}

	private static void agregarCliente() {
		String apellido, dni;
		System.out.println("Ingrese el apellido del cliente :");
		apellido = teclado.next();
		System.out.println("Ingrese el DNI del cliente : ");
		dni = teclado.next();

		Propietario nuevoCliente = new Propietario(apellido, dni);
		if (actual.addCliente(nuevoCliente)) {
			System.out.println("Cliente agregado correctamente");
		} else {
			System.out.println("No se pudo agregar el cliente");
		}

	}

	private static void obtenerListadoDePropiedadesPorPrecio() {
		actual.obtenerListadoDePropiedadesOrdenadasPorPrecio();
	}
}
