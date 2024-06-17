package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test {

	@org.junit.Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria () {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Casa casaAgregar = new Casa(propi, direccion1, 2000.00, 1 );
		
		assertTrue(inmo.darDeAltaPropiedad(casaAgregar));
	}
	
	@org.junit.Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Varela", "1324" );
		Casa casaAgregar = new Casa( propi, direccion1, 2000.00, 1);
		Casa casaAgregar2 = new Casa( propi, direccion2, 2000.00, 2);
		
		assertTrue(inmo.darDeAltaPropiedad(casaAgregar));
		assertTrue(inmo.darDeAltaPropiedad(casaAgregar2));
	}
	
	@org.junit.Test
	public void queNoSePuedanDarDeAltaDosCasasConUnaMismaDireccion() {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1232" );
		Casa casaAgregar = new Casa( propi,direccion1, 2000.00, 1 );
		Casa casaAgregar2 = new Casa( propi, direccion2, 2000.00, 2 );
		
		assertTrue(inmo.darDeAltaPropiedad(casaAgregar));
		assertFalse(inmo.darDeAltaPropiedad(casaAgregar2));
	}
	
	@org.junit.Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Departamento nuevoDepa = new Departamento(propi, direccion1,2000.00,1, 2, "DEp1");
		
		assertTrue(inmo.darDeAltaPropiedad(nuevoDepa));
	}
	
	@org.junit.Test
	public void queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria () {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Varela", "1232" );
		Departamento nuevoDepa = new Departamento(propi, direccion1,2000.00, 1, 2, "Dep1");
		Departamento nuevoDepa2 = new Departamento(propi, direccion2,2000.00, 2, 3, "Dep2");

		assertTrue(inmo.darDeAltaPropiedad(nuevoDepa));
		assertTrue(inmo.darDeAltaPropiedad(nuevoDepa2));
	}
	
	@org.junit.Test
	public void queNoSePuedanDarDeAltaDosDepartamentoConUnaMismaDireccion() {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1232" );
		Departamento nuevoDepa = new Departamento(propi, direccion1,2000.00, 1, 2, "Dep1");
		Departamento nuevoDepa2 = new Departamento(propi, direccion2, 2000.00, 2, 2, "Dep1");

		assertTrue(inmo.darDeAltaPropiedad(nuevoDepa));
		assertFalse(inmo.darDeAltaPropiedad(nuevoDepa2));
	}

	@org.junit.Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		final Double VALOR_PROMEDIO_ESPERADO = 50000.00;
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1432" );
		Direccion direccion4 = new Direccion("Bs As", "Mataderos", "9832" );
		Casa casaAgregar = new Casa( propi,direccion1, 50000.00, 1 );
		Casa casaAgregar2 = new Casa( propi, direccion2, 50000.00, 2 );
		Casa casaAgregar3 = new Casa( propi, direccion3, 50000.00, 3 );
		Departamento departamento = new Departamento(propi, direccion4, 50000.00,4, 1, "Dep90");
		
		inmo.darDeAltaPropiedad(casaAgregar);
		inmo.darDeAltaPropiedad(casaAgregar2);
		inmo.darDeAltaPropiedad(casaAgregar3);
		inmo.darDeAltaPropiedad(departamento);

		assertEquals(VALOR_PROMEDIO_ESPERADO, inmo.obtenerValorPromedioDeCasas(), 0.01);
	}
	
	@org.junit.Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		final Double VALOR_PROMEDIO_ESPERADO = 40000.00;
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1432" );
		
		Departamento depa1 = new Departamento(propi, direccion1, 40000.00,1, 2, "Dep1");
		Departamento depa2 = new Departamento(propi, direccion2, 40000.00, 2, 2, "Dep1");
		Departamento depa3 = new Departamento(propi, direccion3, 40000.00,3, 2, "Dep1");
		
		inmo.darDeAltaPropiedad(depa1);
		inmo.darDeAltaPropiedad(depa2);
		inmo.darDeAltaPropiedad(depa3);
		
		assertEquals(VALOR_PROMEDIO_ESPERADO, inmo.obtenerValorPromedioDeDepartamentos(), 0.01);
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
	}
	
	@org.junit.Test
	public void queSePuedaBuscarUnClienteEnLaInmobiliariaPorDNI() {
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		
		inmo.addCliente(propi);
		assertNotNull(inmo.buscarClientePorDNI("40143300"));
		
	}
	
	@org.junit.Test
	    public void queSePuedaRealizarUnaVenta() {
			Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
			Cliente nuevoCliente = new Propietario("Tonello", "40143300");
			Cliente nuevoCliente2 = new Propietario("Monteagudo", "333333");

			Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
			Casa casaAgregar = new Casa((Propietario)nuevoCliente,direccion1, 40000.00, 1 );
	        inmo.darDeAltaPropiedad(casaAgregar);

	        Venta venta = new Venta(casaAgregar, (Propietario) nuevoCliente2);
	        inmo.realizarOperacion(venta);

	        assertEquals(nuevoCliente2.getDni(), casaAgregar.getDueño().getDni());
	        
	    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException {
		final Double VALOR_MINIMO_A_BUSCAR = 1000.00;
		final Double VALOR_MAXIMO_A_BUSCAR = 70000.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );
		Direccion direccion4 = new Direccion("Mar del Plata", "Av. Peron", "1432" );


		Casa casaAgregar = new Casa( propi,direccion1, 2000.00, 1 );
		Casa casaAgregar2 = new Casa( propi, direccion2, 5000.00, 2 );
		Casa casaAgregar3 = new Casa( propi, direccion3, 4000.00, 3 );
		Departamento depa1 = new Departamento(propi, direccion4, 1000.00,1, 2, "Dep1");
		
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
    public void queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws SinResultadosException {
		final String ciudadABuscar = "Bs As";
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;

		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("San Justo", "Varela", "1111" );

		Casa casaAgregar = new Casa( propi,direccion1, 2000.00, 1 );
		Casa casaAgregar2 = new Casa( propi, direccion2, 5000.00, 2 );
		Casa casaAgregar3 = new Casa( propi, direccion3, 4000.00, 3 );

		
		inmo.darDeAltaPropiedad(casaAgregar);
		inmo.darDeAltaPropiedad(casaAgregar2);
		inmo.darDeAltaPropiedad(casaAgregar3);
		
		ArrayList<Propiedad> casasEncontradasEnElRango = inmo.buscarPropiedadesPorCiudad(ciudadABuscar, tipoDePropiedadABuscar);        
		assertNotNull(casasEncontradasEnElRango);
		assertFalse(casasEncontradasEnElRango.contains(casaAgregar3));
		assertTrue(casasEncontradasEnElRango.contains(casaAgregar2));
		assertTrue(casasEncontradasEnElRango.contains(casaAgregar));
    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException {
		final Double VALOR_MINIMO_A_BUSCAR = 1000.00;
		final Double VALOR_MAXIMO_A_BUSCAR = 70000.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.DEPARTAMENTO;
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );
		Direccion direccion4 = new Direccion("Mar del Plata", "Av. Peron", "1432" );


		Casa casaAgregar = new Casa( propi,direccion1, 2000.00, 1 );
		Casa casaAgregar2 = new Casa( propi, direccion2, 5000.00, 2 );
		Casa casaAgregar3 = new Casa( propi, direccion3, 4000.00, 3 );
		Departamento depa1 = new Departamento(propi, direccion4, 5000.00,4, 2, "Dep1");
		Departamento depa2 = new Departamento(propi, direccion4, 3000.00,5, 2, "Dep2");

		
		inmo.darDeAltaPropiedad(casaAgregar);
		inmo.darDeAltaPropiedad(casaAgregar2);
		inmo.darDeAltaPropiedad(casaAgregar3);
		inmo.darDeAltaPropiedad(depa1);
		inmo.darDeAltaPropiedad(depa2);

		
		TreeSet<Propiedad> departamentosEncontradosEnElRango = inmo.buscarPropiedadesPorRangoDePrecio(VALOR_MINIMO_A_BUSCAR, VALOR_MAXIMO_A_BUSCAR, tipoDePropiedadABuscar);
        
		assertEquals(depa1, departamentosEncontradosEnElRango.first());
    }
	
	@org.junit.Test
    public void queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws SinResultadosException {
		final String ciudadABuscar = "Bs As";
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.DEPARTAMENTO;
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );

		Casa casaAgregar = new Casa( propi,direccion1, 2000.00, 1 );
		Departamento depa1 = new Departamento(propi, direccion2, 5000.00,4, 2, "Dep1");
		Departamento depa2 = new Departamento(propi, direccion3, 3000.00,5, 2, "Dep2");
		
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
    public void queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException() throws SinResultadosException {
		final Double VALOR_MINIMO_A_BUSCAR = 1000.00;
		final Double VALOR_MAXIMO_A_BUSCAR = 1500.00;
		final TipoDePropiedad tipoDePropiedadABuscar = TipoDePropiedad.CASA;
		Inmobiliaria inmo = new Inmobiliaria("Test", "Testing Direccion");
		Propietario propi = new Propietario("Tonello", "40143300");
		Direccion direccion1 = new Direccion("Bs As", "Salguero", "1232" );
		Direccion direccion2 = new Direccion("Bs As", "Salguero", "1432" );
		Direccion direccion3 = new Direccion("Bs As", "Varela", "1111" );
		Direccion direccion4 = new Direccion("Mar del Plata", "Av. Peron", "1432" );


		Casa casaAgregar = new Casa( propi,direccion1, 2000.00, 1 );
		Casa casaAgregar2 = new Casa( propi, direccion2, 5000.00, 2 );
		Casa casaAgregar3 = new Casa( propi, direccion3, 4000.00, 3 );
		Departamento depa1 = new Departamento(propi, direccion4, 1000.00,1, 2, "Dep1");
		
		inmo.darDeAltaPropiedad(casaAgregar);
		inmo.darDeAltaPropiedad(casaAgregar2);
		inmo.darDeAltaPropiedad(casaAgregar3);
		inmo.darDeAltaPropiedad(depa1);

		
		TreeSet<Propiedad> casasEncontradasEnElRango = inmo.buscarPropiedadesPorRangoDePrecio(VALOR_MINIMO_A_BUSCAR, VALOR_MAXIMO_A_BUSCAR, tipoDePropiedadABuscar);
        assertNull(casasEncontradasEnElRango);
    }
		
}
