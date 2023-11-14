
# Proyecto Salas ICESI

## 1. Contexto del problema 

En el contexto de la Universidad Icesi, surge la oportunidad de mejorar la experiencia de la comunidad universitaria mediante 
la introducción de salas de trabajo disponibles a través de un portal web de reservas bajo demanda. Sin embargo, como es natural 
en la implementación de innovaciones, surgen retos que merecen atención. La optimización del uso de estas salas se ve obstaculizada
por la falta de herramientas efectivas para anticipar su ocupación dentro de los sistemas de reserva actuales. Para abordar esta cuestión,
se explorarán vías de solución, considerando la viabilidad de implementar páginas web y aplicaciones móviles. Estas soluciones pretenden asegurar una administración 
fluida de las reservas y un acceso sin complicaciones a los espacios, al tiempo que minimizan cualquier carga adicional para el personal universitario involucrado. En este sentido, 
esta introducción examina la perspectiva del lanzamiento propuesto de las salas de trabajo, resaltando los desafíos inherentes y las posibles estrategias para superarlos.

## 2. Propuesta de solución

Mediante la creación de una plataforma se puede llevar a cabo una solución capaz de cumplir con el objetivo de satisfacer la alta demanda de usuarios que requieren espacios, de manera que sea eficiente y eficaz. 
Esta plataforma contaría con características que permitan a los usuarios tomar decisiones respecto a la reserva de una sala disponible. Entre estas características se pueden destacar:

- **Diseño:** Un diseño intuitivo y atractivo que facilite la navegación y la comprensión de las opciones disponibles.

- **Administración de la información:** Un sistema eficiente para gestionar la información de las salas, incluyendo detalles sobre su disponibilidad, capacidad y equipamiento.

- **Acceso fácil a la plataforma:** Facilitar el acceso a través de páginas web y aplicaciones móviles para que los usuarios puedan realizar reservas de manera conveniente.

Esta propuesta busca optimizar la gestión de las reservas y garantizar un acceso sin complicaciones a los espacios, al tiempo que minimiza cualquier carga adicional para el personal universitario involucrado en el proceso.


<em>#login de usuario </em>

Para login de usuario fue necesario de las siguientes cosas en el *backend del proyecto*:

1: Hacer un POST ya que vamos a mandar informacion hacia la aplicacion

2:Hacer una clase que se llame UsuarioDTO que permita recibir email y contraseña desde el front

3:Buscar y filtrar informacion mediante un QUERY en un repositorio de usuarios

4:Retornar el status y el usuario DTO con todos sus atributos

*para el front*

1: Hacer un espacio para digitar email y contraseña

2: un boton para realizar la accion

3:En el javaScript se manda la informacion al back y se recibe un UsuarioDTO que se filtrara para buscar una ceteogoria indicada y redirigir la pagina
