package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test {

	@org.junit.Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria () throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario nuevaPropiedad = new Propietario("Tonello", "40143300");
		Direccion direccion = new Direccion("Bs As", "Salguero", "1232" );
		Propiedad nuevaCasa = new Casa(nuevaPropiedad, direccion, 12000.00, 1, TipoDeOperacion.VENTA );
		
		assertTrue(inmobiliaria.darDeAltaPropiedad(nuevaCasa));
	}
	
	@org.junit.Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propietario = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Varela", "1324" );
		Propiedad primerCasaAAgregar = new Casa( propietario, direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad segundaCasaAAgregar = new Casa( propietario, direccion2, 12000.00, 2, TipoDeOperacion.VENTA );
		
		assertTrue(inmobiliaria.darDeAltaPropiedad(primerCasaAAgregar));
		assertTrue(inmobiliaria.darDeAltaPropiedad(segundaCasaAAgregar));
	}
	
	@org.junit.Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Propiedad nuevoDepa = new Departamento(propi, direccion1, 12000.00,1, 2, "DEp1", TipoDeOperacion.VENTA );
		
		assertTrue(inmobiliaria.darDeAltaPropiedad(nuevoDepa));
	}
	
	@org.junit.Test
	public void queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria () throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propiedad = new Propietario("Tonello", "40143300");
		Direccion primerDireccion = new Direccion("Bs As", "Salguero", "1232" );
		Direccion segundaDireccion = new Direccion("Bs As", "Varela", "1232" );
		Propiedad primerDepartamento = new Departamento(propiedad, primerDireccion, 12000.00, 1, 2, "Dep1",TipoDeOperacion.VENTA );
		Propiedad segundoDepartamento = new Departamento(propiedad, segundaDireccion, 12000.00, 2, 3, "Dep2", TipoDeOperacion.VENTA );

		assertTrue(inmobiliaria.darDeAltaPropiedad(primerDepartamento));
		assertTrue(inmobiliaria.darDeAltaPropiedad(segundoDepartamento));
	}

	@org.junit.Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() throws UmbralMinimoNoAlcanzadoException {
		final Double VALOR_PROMEDIO_ESPERADO = 100000.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propietario = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1432" );
		Direccion direccion4 = new Direccion("Bs As", "Mataderos", "9832" );
		Propiedad casaAgregar = new Casa( propietario,direccion1, 25000.00, 1, TipoDeOperacion.VENTA );
		Propiedad casaAgregar2 = new Casa( propietario, direccion2, 175000.00, 2, TipoDeOperacion.VENTA );
		Propiedad casaAgregar3 = new Casa( propietario, direccion3, 100000.00, 3, TipoDeOperacion.VENTA );
		Propiedad departamento = new Departamento(propietario, direccion4, 50000.00,4, 1, "Dep90", TipoDeOperacion.VENTA);
		
		inmobiliaria.darDeAltaPropiedad(casaAgregar);
		inmobiliaria.darDeAltaPropiedad(casaAgregar2);
		inmobiliaria.darDeAltaPropiedad(casaAgregar3);
		inmobiliaria.darDeAltaPropiedad(departamento);

		assertEquals(VALOR_PROMEDIO_ESPERADO, inmobiliaria.obtenerValorPromedioDePropiedades(tipoDePropiedadABuscar), 0.01);
	}
	
	@org.junit.Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() throws UmbralMinimoNoAlcanzadoException {
		final Double VALOR_PROMEDIO_ESPERADO = 40000.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.DEPARTAMENTO;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propietario = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1432" );
		
		Departamento depa1 = new Departamento(propietario, direccion1, 40000.00,1, 2, "Dep1", TipoDeOperacion.VENTA);
		Departamento depa2 = new Departamento(propietario, direccion2, 40000.00, 2, 2, "Dep1", TipoDeOperacion.VENTA);
		Departamento depa3 = new Departamento(propietario, direccion3, 40000.00,3, 2, "Dep1", TipoDeOperacion.VENTA);
		
		inmobiliaria.darDeAltaPropiedad(depa1);
		inmobiliaria.darDeAltaPropiedad(depa2);
		inmobiliaria.darDeAltaPropiedad(depa3);
		
		assertEquals(VALOR_PROMEDIO_ESPERADO, inmobiliaria.obtenerValorPromedioDePropiedades(tipoDePropiedadABuscar), 0.01);
	}
	
	@org.junit.Test
	public void queSePuedaAgregarUnClienteALaInmobiliaria() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Cliente nuevoCliente = new Cliente("Tonello", "40143300");
				
		assertTrue(inmobiliaria.addCliente(nuevoCliente));
	}
	
	@org.junit.Test
	public void queNoSePuedanAgregarDosClientesConUnMismoDni() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Cliente nuevoCliente = new Cliente("Tonello", "40143300");
		Cliente nuevoClienteConMismoDni = new Cliente("Monteagudo", "40143300");
		
		inmobiliaria.addCliente(nuevoCliente);
		assertFalse(inmobiliaria.addCliente(nuevoClienteConMismoDni));
		assertEquals(1, inmobiliaria.getClientes().size());
		assertTrue(inmobiliaria.getClientes().contains(nuevoClienteConMismoDni));
	}
	
	@org.junit.Test
	    public void queSePuedaRealizarLaVentaDeUnaPropiedad() throws ClienteNoEncontradoException, PropiedadNoEncontradaException, PropiedadNoDisponibleException, UmbralMinimoNoAlcanzadoException {
			Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
			Cliente propietarioActual = new Propietario("Tonello", "40143300");
			Cliente nuevoPropietario = new Propietario("Monteagudo", "333333");
			TipoDeOperacion venta = TipoDeOperacion.VENTA;

			Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
			Propiedad propiedadPorSerVendida = new Casa((Propietario)propietarioActual,direccion1, 40000.00, 1, TipoDeOperacion.VENTA);
			inmobiliaria.darDeAltaPropiedad(propiedadPorSerVendida);
			inmobiliaria.addCliente(nuevoPropietario);
	        
	        assertTrue(inmobiliaria.realizarOperacion(nuevoPropietario.getDni(), propiedadPorSerVendida.getCodigoDePropiedad(), venta));
	        assertEquals(nuevoPropietario.getDni(), propiedadPorSerVendida.getPropietario().getDni());  
	    }
	
	@org.junit.Test
    public void queSePuedaRealizarElAlquilerDeUnaPropiedad() throws ClienteNoEncontradoException, PropiedadNoEncontradaException, PropiedadNoDisponibleException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Cliente propietarioActual = new Propietario("Tonello", "40143300");
		Cliente nuevoInquilino = new Inquilino("Monteagudo", "333333");
		TipoDeOperacion alquiler = TipoDeOperacion.ALQUILER;


		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Propiedad propiedadPorSerAlquilada = new Casa((Propietario)propietarioActual,direccion1, 40000.00, 1, TipoDeOperacion.ALQUILER);
		inmobiliaria.darDeAltaPropiedad(propiedadPorSerAlquilada);
		inmobiliaria.addCliente(nuevoInquilino);
        
        assertTrue(inmobiliaria.realizarOperacion(nuevoInquilino.getDni(), propiedadPorSerAlquilada.getCodigoDePropiedad(), alquiler));
        assertEquals(propiedadPorSerAlquilada.getInquilino(), nuevoInquilino);
        
    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaPermutaDeDosPropiedades() throws ClienteNoEncontradoException, PropiedadNoEncontradaException, UmbralMinimoNoAlcanzadoException, PropiedadNoDisponibleException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Cliente propietarioCasaX = new Propietario("Tonello", "40143300");
		Cliente propietarioCasaY = new Propietario("Monteagudo", "333333");


		Direccion direccionCasaX = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccionCasaY = new Direccion("Bs As", "Varela", "1983" );
		Propiedad propiedadCasaX = new Casa((Propietario)propietarioCasaX,direccionCasaX, 40000.00, 1, TipoDeOperacion.PERMUTA);
		Propiedad propiedadCasaY = new Casa((Propietario)propietarioCasaY,direccionCasaY, 40000.00, 2, TipoDeOperacion.PERMUTA);

		inmobiliaria.darDeAltaPropiedad(propiedadCasaX);
        inmobiliaria.darDeAltaPropiedad(propiedadCasaY);
        
        assertTrue(inmobiliaria.realizarPermuta(1, 2));
        assertEquals(propietarioCasaY, propiedadCasaX.getPropietario());
        assertEquals(propietarioCasaX, propiedadCasaY.getPropietario());
    }
	
	
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		final Double VALOR_MINIMO_A_BUSCAR = 1000.00;
		final Double VALOR_MAXIMO_A_BUSCAR = 70000.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propietario = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );
		Direccion direccion4 = new Direccion("Mar del Plata", "Av. Peron", "1432" );


		Propiedad primerCasaAAgregar = new Casa( propietario,direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad segundaCasaAAgregar = new Casa( propietario, direccion2, 15000.00, 2, TipoDeOperacion.VENTA );
		Propiedad tercerCasaAAgregar = new Casa( propietario, direccion3, 14000.00, 3, TipoDeOperacion.VENTA );
		Propiedad primerDepartamentoAAgregar = new Departamento(propietario, direccion4, 16000.00,1, 2, "Dep1", TipoDeOperacion.VENTA);
		
		inmobiliaria.darDeAltaPropiedad(primerCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(segundaCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(tercerCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(primerDepartamentoAAgregar);

		
		TreeSet<Propiedad> casasEncontradasEnElRango = inmobiliaria.buscarPropiedadesPorRangoDePrecio(VALOR_MINIMO_A_BUSCAR, VALOR_MAXIMO_A_BUSCAR, tipoDePropiedadABuscar);
        
		assertEquals(segundaCasaAAgregar, casasEncontradasEnElRango.first());
		assertEquals(primerCasaAAgregar, casasEncontradasEnElRango.last());
		assertFalse(casasEncontradasEnElRango.contains(primerDepartamentoAAgregar));
    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		final String ciudadABuscar = "Bs As";
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Balguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Aalguero", "1432" );
		Direccion direccion3 = new Direccion("San Justo", "Varela", "1111" );

		Propiedad primerCasaAAgregar = new Casa( propi,direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad segundaCasaAAgregar = new Casa( propi, direccion2, 15000.00, 2, TipoDeOperacion.VENTA );
		Propiedad tercerCasaAAgregar = new Casa( propi, direccion3, 14000.00, 3, TipoDeOperacion.VENTA );

		
		inmobiliaria.darDeAltaPropiedad(primerCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(segundaCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(tercerCasaAAgregar);
		
		ArrayList<Propiedad> casasEncontradasEnElRango = inmobiliaria.buscarPropiedadesPorCiudad(ciudadABuscar, tipoDePropiedadABuscar);        
		assertNotNull(casasEncontradasEnElRango);
		assertFalse(casasEncontradasEnElRango.contains(tercerCasaAAgregar));
		assertTrue(casasEncontradasEnElRango.contains(segundaCasaAAgregar));
		assertTrue(casasEncontradasEnElRango.contains(primerCasaAAgregar));
		assertEquals(casasEncontradasEnElRango.get(0), segundaCasaAAgregar);
    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		final Double VALOR_MINIMO_A_BUSCAR = 1000.00;
		final Double VALOR_MAXIMO_A_BUSCAR = 70000.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.DEPARTAMENTO;
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propietario = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );
		Direccion direccion4 = new Direccion("Mar del Plata", "Av. Peron", "1432" );


		Propiedad primerCasaAAgregar = new Casa( propietario,direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad segundaCasaAAgregar = new Casa( propietario, direccion2, 15000.00, 2, TipoDeOperacion.VENTA );
		Propiedad tercerCasaAAgregar = new Casa( propietario, direccion3, 14000.00, 3, TipoDeOperacion.VENTA );
		Propiedad primerDepartamentoAAgregar = new Departamento(propietario, direccion4, 15000.00,4, 2, "Dep1", TipoDeOperacion.VENTA);
		Propiedad segundoDepartamentoAAgregar = new Departamento(propietario, direccion4, 13000.00,5, 2, "Dep2", TipoDeOperacion.VENTA);

		
		inmobiliaria.darDeAltaPropiedad(primerCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(segundaCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(tercerCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(primerDepartamentoAAgregar);
		inmobiliaria.darDeAltaPropiedad(segundoDepartamentoAAgregar);

		
		TreeSet<Propiedad> departamentosEncontradosEnElRango = inmobiliaria.buscarPropiedadesPorRangoDePrecio(VALOR_MINIMO_A_BUSCAR, VALOR_MAXIMO_A_BUSCAR, tipoDePropiedadABuscar);
        
		assertEquals(primerDepartamentoAAgregar, departamentosEncontradosEnElRango.first());
    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		final String ciudadABuscar = "Bs As";
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.DEPARTAMENTO;
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );

		Propiedad primerCasaAAgregar = new Casa( propi,direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad primerDepartamentoAAgregar = new Departamento(propi, direccion2, 15000.00,4, 2, "Dep1", TipoDeOperacion.VENTA);
		Propiedad segundoDepartamentoAAgregar = new Departamento(propi, direccion3, 13000.00,5, 2, "Dep2", TipoDeOperacion.VENTA);
		
		inmobiliaria.darDeAltaPropiedad(primerCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(primerDepartamentoAAgregar);
		inmobiliaria.darDeAltaPropiedad(segundoDepartamentoAAgregar);
		
		ArrayList<Propiedad> casasEncontradasEnElRango = inmobiliaria.buscarPropiedadesPorCiudad(ciudadABuscar, tipoDePropiedadABuscar);        
		assertNotNull(casasEncontradasEnElRango);
		assertFalse(casasEncontradasEnElRango.contains(primerCasaAAgregar));
		assertTrue(casasEncontradasEnElRango.contains(primerDepartamentoAAgregar));
		assertTrue(casasEncontradasEnElRango.contains(segundoDepartamentoAAgregar));
    }
	
	@org.junit.Test(expected = SinResultadosException.class)
    public void queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		final Double VALOR_MINIMO_A_BUSCAR = 1000.00;
		final Double VALOR_MAXIMO_A_BUSCAR = 1500.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propietario = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );
		Direccion direccion4 = new Direccion("Mar del Plata", "Av. Peron", "1432" );


		Propiedad primerCasaAAgregar = new Casa( propietario,direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad segundaCasaAAgregar = new Casa( propietario, direccion2, 15000.00, 2, TipoDeOperacion.VENTA );
		Propiedad tercerCasaAAgregar = new Casa( propietario, direccion3, 14000.00, 3, TipoDeOperacion.VENTA );
		Propiedad primerDepartamento = new Departamento(propietario, direccion4, 11000.00,1, 2, "Dep1", TipoDeOperacion.VENTA);
		
		inmobiliaria.darDeAltaPropiedad(primerCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(segundaCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(tercerCasaAAgregar);
		inmobiliaria.darDeAltaPropiedad(primerDepartamento);
		
		TreeSet<Propiedad> casasEncontradasEnElRango = inmobiliaria.buscarPropiedadesPorRangoDePrecio(VALOR_MINIMO_A_BUSCAR, VALOR_MAXIMO_A_BUSCAR, tipoDePropiedadABuscar);
        assertNull(casasEncontradasEnElRango);
    }
	
	@org.junit.Test(expected = UmbralMinimoNoAlcanzadoException.class)
	public void queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoExceptio()
			throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario nuevoPropietario = new Propietario("Tonello", "40143300");
		Direccion direccion = new Direccion("Bs As", "Salguero", "1232");
		Propiedad nuevaCasa = new Casa(nuevoPropietario, direccion, 2000.00, 1, TipoDeOperacion.VENTA);

		assertTrue(inmobiliaria.darDeAltaPropiedad(nuevaCasa));
	}
	
/* ------------------------- Test adicionales para corroborar el correcto funcionamiento -------------- */
	
	
	@org.junit.Test(expected = ClienteNoEncontradoException.class)
	public void queAlNoEncontrarUnClienteEnLaInmobiliariaConUnNumeroDeDocumentoLanzeUnaExcepction () throws ClienteNoEncontradoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Cliente nuevoCliente = new Propietario("Tonello", "40143300");
		
		inmobiliaria.addCliente(nuevoCliente);
		
		inmobiliaria.buscarClientePorDNI("32143");
		
	}
	
	@org.junit.Test(expected = PropiedadNoDisponibleException.class)
	public void queNoSePuedaRealizarUnaVentaSiLaPropiedadNoFueAgregadaALaInmobiliariaParaSerVendida () throws  PropiedadNoDisponibleException, ClienteNoEncontradoException, PropiedadNoEncontradaException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Cliente propietario = new Propietario("Tonello", "40143300");
		Cliente posibleComprador = new Cliente("Juan Monteagudo", "3800000");

		Direccion direccion = new Direccion("Bs As", "Salguero", "1232");
		TipoDeOperacion tipoDeOperacionARealizar = TipoDeOperacion.VENTA;
		
		Propiedad nuevaCasaPuestaParaAlquiler = new Casa((Propietario)propietario, direccion, 10000.00, 1, TipoDeOperacion.ALQUILER );
		inmobiliaria.addCliente(posibleComprador);
		inmobiliaria.darDeAltaPropiedad(nuevaCasaPuestaParaAlquiler);
		
		inmobiliaria.realizarOperacion(posibleComprador.getDni(), nuevaCasaPuestaParaAlquiler.getCodigoDePropiedad(), tipoDeOperacionARealizar);
		
	}
	
	@org.junit.Test(expected = PropiedadNoDisponibleException.class)
	public void queNoSePuedaRealizarUnAlquilerSiLaPropiedadNoFueAgregadaALaInmobiliariaParaSerAlquilada () throws  PropiedadNoDisponibleException, ClienteNoEncontradoException, PropiedadNoEncontradaException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Cliente propietario = new Propietario("Tonello", "40143300");
		Cliente posibleInquilino = new Inquilino("Juan Monteagudo", "3800000");

		Direccion direccion = new Direccion("Bs As", "Salguero", "1232");
		TipoDeOperacion tipoDeOperacionAlquiler = TipoDeOperacion.ALQUILER;
	
		Propiedad nuevaCasaPuestaParaVender = new Casa((Propietario)propietario, direccion, 10000.00, 1, TipoDeOperacion.VENTA );
		inmobiliaria.addCliente(posibleInquilino);
		inmobiliaria.darDeAltaPropiedad(nuevaCasaPuestaParaVender);
		
		inmobiliaria.realizarOperacion(posibleInquilino.getDni(), nuevaCasaPuestaParaVender.getCodigoDePropiedad(), tipoDeOperacionAlquiler);
		
	}
		
}
