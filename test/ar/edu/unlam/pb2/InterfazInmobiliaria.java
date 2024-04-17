package ar.edu.unlam.pb2;

import java.util.Scanner;

public class InterfazInmobiliaria {
	/* private static Scanner teclado = new Scanner(System.in);
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

	private static void realizarAlquilerDePropiedad() {
		Integer codigoDePropiedadAAlquilar;
		String dniInquilino;
		System.out.println("Ingrese el código de la propiedad a alquilar : ");
		codigoDePropiedadAAlquilar = teclado.nextInt();
		Casa propiedadAAlquilar = actual.buscarPropiedadPorCodigo(codigoDePropiedadAAlquilar);
		System.out.println("Ingrese el DNI del inquilino");
		dniInquilino = teclado.next();
		Propietario inquilino = actual.buscarClientePorDNI(dniInquilino);
		
		actual.alquilarPropiedad(inquilino, propiedadAAlquilar);
		
	}

	private static void realizarVentaDePropiedad() {
		Integer codigoDePropiedadAVender;
		String dniNuevoDueño;
		System.out.println("Ingrese el código de la propiedad a vender : ");
		codigoDePropiedadAVender = teclado.nextInt();
		Casa propiedadAVender = actual.buscarPropiedadPorCodigo(codigoDePropiedadAVender);
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
		actual.obtenerListadoDeCasasOrdenadasPorUbicacion();		
	}

	private static void agregarNuevaPropiedad() {
		String calle, ciudad;
		Double precio;
		TipoDeOperacion tipo;
		Clasificacion clasificacion;

		System.out.println("Ingrese la calle de la propiedad : ");
		calle = teclado.next();
		System.out.println("Ingrese la ciudad de la propiedad: ");
		ciudad = teclado.next();
		System.out.println("Ingrese el precio :");
		precio = teclado.nextDouble();

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
				System.out.println("Tipo de operación no válido. Por favor, ingrese C, D,P, T o E.");
			}
		} while (true);

		Casa nuevaPropiedad = new Casa(calle, ciudad, precio, true, tipo, CODIGO_DE_PROPIEDAD_SIGUIENTE, clasificacion);
		if (actual.add(nuevaPropiedad)) {
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

		Casa propiedadAModificar = actual.buscarPropiedadPorCodigo(codigo);

		if (propiedadAModificar != null) {
			String calle, ciudad;
			Double precio;
			System.out.println("Ingrese la calle de la propiedad : ");
			calle = teclado.next();
			System.out.println("Ingrese la ciudad de la propiedad: ");
			ciudad = teclado.next();
			System.out.println("Ingrese el precio :");
			precio = teclado.nextDouble();

			propiedadAModificar.setCalle(calle);
			propiedadAModificar.setCiudad(ciudad);
			propiedadAModificar.setPrecio(precio);
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
		actual.obtenerListadoDeCasasOrdenadasPorPrecio();
	}*/
}
