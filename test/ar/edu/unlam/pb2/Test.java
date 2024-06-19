package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
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
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Varela", "1324" );
		Propiedad casaAgregar = new Casa( propi, direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad casaAgregar2 = new Casa( propi, direccion2, 12000.00, 2, TipoDeOperacion.VENTA );
		
		assertTrue(inmobiliaria.darDeAltaPropiedad(casaAgregar));
		assertTrue(inmobiliaria.darDeAltaPropiedad(casaAgregar2));
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
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Varela", "1232" );
		Departamento nuevoDepa = new Departamento(propi, direccion1, 12000.00, 1, 2, "Dep1",TipoDeOperacion.VENTA );
		Departamento nuevoDepa2 = new Departamento(propi, direccion2, 12000.00, 2, 3, "Dep2", TipoDeOperacion.VENTA );

		assertTrue(inmo.darDeAltaPropiedad(nuevoDepa));
		assertTrue(inmo.darDeAltaPropiedad(nuevoDepa2));
	}

	@org.junit.Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() throws UmbralMinimoNoAlcanzadoException {
		final Double VALOR_PROMEDIO_ESPERADO = 100000.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;

		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1432" );
		Direccion direccion4 = new Direccion("Bs As", "Mataderos", "9832" );
		Propiedad casaAgregar = new Casa( propi,direccion1, 25000.00, 1, TipoDeOperacion.VENTA );
		Propiedad casaAgregar2 = new Casa( propi, direccion2, 175000.00, 2, TipoDeOperacion.VENTA );
		Propiedad casaAgregar3 = new Casa( propi, direccion3, 100000.00, 3, TipoDeOperacion.VENTA );
		Propiedad departamento = new Departamento(propi, direccion4, 50000.00,4, 1, "Dep90", TipoDeOperacion.VENTA);
		
		inmo.darDeAltaPropiedad(casaAgregar);
		inmo.darDeAltaPropiedad(casaAgregar2);
		inmo.darDeAltaPropiedad(casaAgregar3);
		inmo.darDeAltaPropiedad(departamento);

		assertEquals(VALOR_PROMEDIO_ESPERADO, inmo.obtenerValorPromedioDePropiedades(tipoDePropiedadABuscar), 0.01);
	}
	
	@org.junit.Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() throws UmbralMinimoNoAlcanzadoException {
		final Double VALOR_PROMEDIO_ESPERADO = 40000.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.DEPARTAMENTO;

		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1432" );
		
		Departamento depa1 = new Departamento(propi, direccion1, 40000.00,1, 2, "Dep1", TipoDeOperacion.VENTA);
		Departamento depa2 = new Departamento(propi, direccion2, 40000.00, 2, 2, "Dep1", TipoDeOperacion.VENTA);
		Departamento depa3 = new Departamento(propi, direccion3, 40000.00,3, 2, "Dep1", TipoDeOperacion.VENTA);
		
		inmo.darDeAltaPropiedad(depa1);
		inmo.darDeAltaPropiedad(depa2);
		inmo.darDeAltaPropiedad(depa3);
		
		assertEquals(VALOR_PROMEDIO_ESPERADO, inmo.obtenerValorPromedioDePropiedades(tipoDePropiedadABuscar), 0.01);
	}
	
	@org.junit.Test
	public void queSePuedaAgregarUnClienteALaInmobiliaria() {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Cliente nuevoCliente = new Cliente("Tonello", "40143300");
				
		assertTrue(inmo.addCliente(nuevoCliente));
	}
	
	@org.junit.Test
	public void queNoSePuedanAgregarDosClientesConUnMismoDni() {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Cliente nuevoCliente = new Cliente("Tonello", "40143300");
		Cliente nuevoClienteConMismoDni = new Cliente("Monteagudo", "40143300");
		
		inmo.addCliente(nuevoCliente);
		assertFalse(inmo.addCliente(nuevoClienteConMismoDni));
		assertEquals(1, inmo.getClientes().size());
		assertTrue(inmo.getClientes().contains(nuevoClienteConMismoDni));
	}
	
	@org.junit.Test
	    public void queSePuedaRealizarLaVentaDeUnaPropiedad() throws ClienteNoEncontradoException, PropiedadNoEncontradaException, PropiedadNoDisponibleException, UmbralMinimoNoAlcanzadoException {
			Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
			Cliente propietarioActual = new Propietario("Tonello", "40143300");
			Cliente nuevoPropietario = new Propietario("Monteagudo", "333333");
			TipoDeOperacion venta = TipoDeOperacion.VENTA;

			Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
			Propiedad casaAgregar = new Casa((Propietario)propietarioActual,direccion1, 40000.00, 1, TipoDeOperacion.VENTA);
	        inmo.darDeAltaPropiedad(casaAgregar);
	        inmo.addCliente(nuevoPropietario);
	        
	        assertTrue(inmo.realizarOperacion(nuevoPropietario.getDni(), casaAgregar.getCodigoDePropiedad(), venta));
	        assertEquals(nuevoPropietario.getDni(), casaAgregar.getDueño().getDni());  
	    }
	
	@org.junit.Test
    public void queSePuedaRealizarElAlquilerDeUnaPropiedad() throws ClienteNoEncontradoException, PropiedadNoEncontradaException, PropiedadNoDisponibleException, UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Cliente propietarioActual = new Propietario("Tonello", "40143300");
		Cliente nuevoInquilino = new Inquilino("Monteagudo", "333333");
		TipoDeOperacion alquiler = TipoDeOperacion.ALQUILER;


		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Propiedad casaAgregar = new Casa((Propietario)propietarioActual,direccion1, 40000.00, 1, TipoDeOperacion.ALQUILER);
        inmo.darDeAltaPropiedad(casaAgregar);
        inmo.addCliente(nuevoInquilino);
        
        assertTrue(inmo.realizarOperacion(nuevoInquilino.getDni(), casaAgregar.getCodigoDePropiedad(), alquiler));
        assertEquals(casaAgregar.getInquilino(), nuevoInquilino);
        
    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaPermutaDeDosPropiedades() throws ClienteNoEncontradoException, PropiedadNoEncontradaException, UmbralMinimoNoAlcanzadoException, PropiedadNoDisponibleException {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Cliente propietarioCasaX = new Propietario("Tonello", "40143300");
		Cliente propietarioCasaY = new Propietario("Monteagudo", "333333");


		Direccion direccionCasaX = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccionCasaY = new Direccion("Bs As", "Varela", "1983" );
		Propiedad propiedadCasaX = new Casa((Propietario)propietarioCasaX,direccionCasaX, 40000.00, 1, TipoDeOperacion.PERMUTA);
		Propiedad propiedadCasaY = new Casa((Propietario)propietarioCasaY,direccionCasaY, 40000.00, 2, TipoDeOperacion.PERMUTA);

        inmo.darDeAltaPropiedad(propiedadCasaX);
        inmo.darDeAltaPropiedad(propiedadCasaY);
        
        assertTrue(inmo.realizarPermuta(1, 2));
        assertEquals(propietarioCasaY, propiedadCasaX.getDueño());
        assertEquals(propietarioCasaX, propiedadCasaY.getDueño());
    }
	
	
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		final Double VALOR_MINIMO_A_BUSCAR = 1000.00;
		final Double VALOR_MAXIMO_A_BUSCAR = 70000.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );
		Direccion direccion4 = new Direccion("Mar del Plata", "Av. Peron", "1432" );


		Propiedad casaAgregar = new Casa( propi,direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad casaAgregar2 = new Casa( propi, direccion2, 15000.00, 2, TipoDeOperacion.VENTA );
		Propiedad casaAgregar3 = new Casa( propi, direccion3, 14000.00, 3, TipoDeOperacion.VENTA );
		Propiedad depa1 = new Departamento(propi, direccion4, 16000.00,1, 2, "Dep1", TipoDeOperacion.VENTA);
		
		inmo.darDeAltaPropiedad(casaAgregar);
		inmo.darDeAltaPropiedad(casaAgregar2);
		inmo.darDeAltaPropiedad(casaAgregar3);
		inmo.darDeAltaPropiedad(depa1);

		
		TreeSet<Propiedad> casasEncontradasEnElRango = inmo.buscarPropiedadesPorRangoDePrecio(VALOR_MINIMO_A_BUSCAR, VALOR_MAXIMO_A_BUSCAR, tipoDePropiedadABuscar);
        
		assertEquals(casaAgregar2, casasEncontradasEnElRango.first());
		assertEquals(casaAgregar, casasEncontradasEnElRango.last());
		assertFalse(casasEncontradasEnElRango.contains(depa1));
    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		final String ciudadABuscar = "Bs As";
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;

		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Balguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Aalguero", "1432" );
		Direccion direccion3 = new Direccion("San Justo", "Varela", "1111" );

		Propiedad casaAgregar = new Casa( propi,direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad casaAgregar2 = new Casa( propi, direccion2, 15000.00, 2, TipoDeOperacion.VENTA );
		Propiedad casaAgregar3 = new Casa( propi, direccion3, 14000.00, 3, TipoDeOperacion.VENTA );

		
		inmo.darDeAltaPropiedad(casaAgregar);
		inmo.darDeAltaPropiedad(casaAgregar2);
		inmo.darDeAltaPropiedad(casaAgregar3);
		
		ArrayList<Propiedad> casasEncontradasEnElRango = inmo.buscarPropiedadesPorCiudad(ciudadABuscar, tipoDePropiedadABuscar);        
		assertNotNull(casasEncontradasEnElRango);
		assertFalse(casasEncontradasEnElRango.contains(casaAgregar3));
		assertTrue(casasEncontradasEnElRango.contains(casaAgregar2));
		assertTrue(casasEncontradasEnElRango.contains(casaAgregar));
		assertEquals(casasEncontradasEnElRango.get(0), casaAgregar2);
    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		final Double VALOR_MINIMO_A_BUSCAR = 1000.00;
		final Double VALOR_MAXIMO_A_BUSCAR = 70000.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.DEPARTAMENTO;
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );
		Direccion direccion4 = new Direccion("Mar del Plata", "Av. Peron", "1432" );


		Propiedad casaAgregar = new Casa( propi,direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad casaAgregar2 = new Casa( propi, direccion2, 15000.00, 2, TipoDeOperacion.VENTA );
		Propiedad casaAgregar3 = new Casa( propi, direccion3, 14000.00, 3, TipoDeOperacion.VENTA );
		Propiedad depa1 = new Departamento(propi, direccion4, 15000.00,4, 2, "Dep1", TipoDeOperacion.VENTA);
		Propiedad depa2 = new Departamento(propi, direccion4, 13000.00,5, 2, "Dep2", TipoDeOperacion.VENTA);

		
		inmo.darDeAltaPropiedad(casaAgregar);
		inmo.darDeAltaPropiedad(casaAgregar2);
		inmo.darDeAltaPropiedad(casaAgregar3);
		inmo.darDeAltaPropiedad(depa1);
		inmo.darDeAltaPropiedad(depa2);

		
		TreeSet<Propiedad> departamentosEncontradosEnElRango = inmo.buscarPropiedadesPorRangoDePrecio(VALOR_MINIMO_A_BUSCAR, VALOR_MAXIMO_A_BUSCAR, tipoDePropiedadABuscar);
        
		assertEquals(depa1, departamentosEncontradosEnElRango.first());
    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		final String ciudadABuscar = "Bs As";
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.DEPARTAMENTO;
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );

		Propiedad casaAgregar = new Casa( propi,direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad depa1 = new Departamento(propi, direccion2, 15000.00,4, 2, "Dep1", TipoDeOperacion.VENTA);
		Propiedad depa2 = new Departamento(propi, direccion3, 13000.00,5, 2, "Dep2", TipoDeOperacion.VENTA);
		
		inmo.darDeAltaPropiedad(casaAgregar);
		inmo.darDeAltaPropiedad(depa1);
		inmo.darDeAltaPropiedad(depa2);
		
		ArrayList<Propiedad> casasEncontradasEnElRango = inmo.buscarPropiedadesPorCiudad(ciudadABuscar, tipoDePropiedadABuscar);        
		assertNotNull(casasEncontradasEnElRango);
		assertFalse(casasEncontradasEnElRango.contains(casaAgregar));
		assertTrue(casasEncontradasEnElRango.contains(depa1));
		assertTrue(casasEncontradasEnElRango.contains(depa2));
    }
	
	@org.junit.Test(expected = SinResultadosException.class)
    public void queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		final Double VALOR_MINIMO_A_BUSCAR = 1000.00;
		final Double VALOR_MAXIMO_A_BUSCAR = 1500.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );
		Direccion direccion4 = new Direccion("Mar del Plata", "Av. Peron", "1432" );


		Propiedad casaAgregar = new Casa( propi,direccion1, 12000.00, 1, TipoDeOperacion.VENTA );
		Propiedad casaAgregar2 = new Casa( propi, direccion2, 15000.00, 2, TipoDeOperacion.VENTA );
		Propiedad casaAgregar3 = new Casa( propi, direccion3, 14000.00, 3, TipoDeOperacion.VENTA );
		Propiedad depa1 = new Departamento(propi, direccion4, 11000.00,1, 2, "Dep1", TipoDeOperacion.VENTA);
		
		inmo.darDeAltaPropiedad(casaAgregar);
		inmo.darDeAltaPropiedad(casaAgregar2);
		inmo.darDeAltaPropiedad(casaAgregar3);
		inmo.darDeAltaPropiedad(depa1);
		
		TreeSet<Propiedad> casasEncontradasEnElRango = inmo.buscarPropiedadesPorRangoDePrecio(VALOR_MINIMO_A_BUSCAR, VALOR_MAXIMO_A_BUSCAR, tipoDePropiedadABuscar);
        assertNull(casasEncontradasEnElRango);
    }
	
	@org.junit.Test(expected = UmbralMinimoNoAlcanzadoException.class)
	public void queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoExceptio () throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Test", "Testing Direccion");
		Propietario nuevaPropiedad = new Propietario("Tonello", "40143300");
		Direccion direccion = new Direccion("Bs As", "Salguero", "1232" );
		Propiedad nuevaCasa = new Casa(nuevaPropiedad, direccion, 2000.00, 1, TipoDeOperacion.VENTA );
		
		assertTrue(inmobiliaria.darDeAltaPropiedad(nuevaCasa));
	}
	
	
		
}
