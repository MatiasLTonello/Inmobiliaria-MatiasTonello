
# Programación Básica 2 - Inmobiliaria

Trabajo práctico progresivo realizado para la materia programación básica 2 de la Universidad de La Matanza. 

## ¿Qué debemos hacer?

Nos contratan para desarrollar un software que permita gestionar una inmobiliaria.
Las inmobiliarias se encargan de la comercialización de Propiedades (Casas, Departamentos, PH, Terrenos, Campos).

El objetivo principal de una inmobiliaria es realizar Operaciones (Ventas, Alquileres o Permutas).

La Venta es una operación donde una propiedad es vendida, es decir pasa de un Propietario A a su nuevo Propietario B.

El Alquiler es una operación donde una propiedad es alquilada, es decir, durante un período de tiempo, esa casa, departamento , PH, terreno o campo, además de Tener un Propietario, también tiene un Inquilino.

La Permuta es una Operación donde una propiedad A cambia su Propietario X a su nuevo Propietario Y, y al mismo tiempo la propiedad cambia su Propietario Y a X. Es un intercambio de propiedades entre los dueños.

1.	Se solicita desarrollar un software en Java, con un menú de opciones que permita:

a.	Agregar nuevas propiedades (Las propiedad se pueden repetir, porque distintos vendedores pueden cargar una misma propiedad con diferentes valores de venta por ejemplo)

b.	 Modificar propiedad existentes (La búsqueda de propiedad se realiza por código)

c.	Agregar clientes (Son aquellos que se encuentran en búsqueda de una propiedad. No se puede agregar dos clientes con un mismo DNI)

d.	Obtener listado de propiedades ordenado por precio.

e.	Obtener el listado de propiedades ordenado por ubicación.

f.	Buscar propiedades por diferentes parámetros:
i.	Rango de precios
ii.	Ubicación (Ciudad)

g.	Realizar la venta de una propiedad

h.	Realizar el alquiler de una propiedad

i.	Realizar la permuta de dos propiedades

2.	Desarrollar los siguientes casos de prueba en Junit.
a.	queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria

b.	queSePuedanDarDeAltaDosCasasEnLaInmobiliaria

c.	queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria

d.	queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria

e.	queSePuedaObtenerElValorPromedioDeLasCasas

f.	queSePuedaObtenerElValorPromedioDeLosDepartamentos

g.	queSePuedaAgregarUnClienteALaInmobiliaria

h.	queNoSePuedanAgregarDosClientesConUnMismoDni

i.	queSePuedaRealizarLaVentaDeUnaPropiedad

j.	queSePuedaRealizarElAlquilerDeUnaPropiedad

k.	queSePuedaRealizarLaPermutaDeDosPropiedades

l.queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio

m. queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion

n.	queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio

o.	queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion

p.	queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException

q.	queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoException

3.	Características del Proyecto:
a.	El nombre del proyecto debe ser Inmobiliaria-ApellidoNombre, donde ApellidoNombre debe ser reemplazado por el apellido y el nombre de cada alumno.

b.	Generar un repositorio en GIT de manera local y agregar su proyecto.

c.	Subir su repositorio a Github de manera privada.

d.	Compartir el repositorio con los docentes de la materia (julian94.-@hotmail.com y jmonteagudo@gmail.com).



