# UNIVERSIDAD POLITECNICA SALESIANA
![Logo Universidad Politécnica Salesiana del Ecuador](https://upload.wikimedia.org/wikipedia/commons/b/b0/Logo_Universidad_Polit%C3%A9cnica_Salesiana_del_Ecuador.png)

### REALIZADO POR:
Jennyfer Camila Ramirez Saeteros
### MATERIA:
Estructura de Datos
### GRUPO N°1
### PERIODO 62

# SISTEMA DE GESTION DE CONTACTOS TELEFONICOS
**Descripción:** 
<p>Se necesita desarrollar un programa para gestionar una lista de contactos telefónicos. Cada contacto tiene un nombre, un número de teléfono, 
una Coleccion de Correos y un Diccionario que almacenara las redes sociales del contacto donde la red social sera la clave del diccionario ( Ejem: 
{'"acebook": "link_facebook_profile"} ). El programa debe permitir agregar, buscar y eliminar contactos de la lista utilizando un árbol binario de 
búsqueda.</p>
<p>Este proyecto implementa un sistema de gestión de contactos telefónicos utilizando el patrón Modelo-Vista-Controlador (MVC). 
A continuación, se detalla la estructura del proyecto y se brinda una explicación sobre los diccionarios y HashMap utilizados.</p>

**Requerimientos:** 
<p>Implementa una clase "Contacto" con atributos para el nombre y el número de teléfono.
Implementa una clase "Nodo" que represente los nodos del árbol binario de búsqueda. Cada nodo debe contener un objeto "Contacto" y referencias a 
los nodos hijo izquierdo y derecho. Implementa una clase "ArbolContactos" que represente el árbol binario de búsqueda. Esta clase debe tener métodos 
para agregar un nuevo contacto, buscar un contacto por nombre y eliminar un contacto. Utiliza las propiedades del árbol binario de búsqueda para 
insertar los contactos de forma ordenada, según el nombre de contacto. El criterio utilizado es comparar el nombre de cada nuevo contacto con el nombre
de los contactos existentes en el árbol para determinar en qué posición se debe insertar.
Implementa los métodos de recorrido (preorder, inorder, postorder, achura) para mostrar los contactos en diferentes órdenes. Crea un programa principal 
  donde se puedan realizar las operaciones de gestión de contactos utilizando objetos de las clases mencionadas anteriormente. 
El programa debe mostrar un menú de opciones al usuario y ejecutar las operaciones correspondientes.</p>

## Estructura del Proyecto de Gestion de Contactos Telefonicos
El siguiente proyecto a continuacion esta dividido en: 
###### Paquete Modelo
En este paquete contenemos las clases que se podrian decir que son las bases para prosegir con la buena ejecucion de los metodos y del programa en si:
**Contacto:** <p>En esta clase primero creamos los atributos nombre de tipo String, telefono de tipo String, una lista tipo String llamada correos, un 
Diccionario con valores tipo String llamado redesSociales, asi para luego ser instanciadas en el constrcutor de la clase, sin embargo solo se pasan como 
parámetros el nombre y el teléfono ya que la lista y diccionario se van añadiendo valores despues, continuamos con los getters y setters de los tipo 
String, continuamos con los métodos para agregar correos a la lista y el método para agregar una red social, y finalizamos con el método sobrescrito 
“toString”, que nos permite imprimir al contacto.</p>

**Node:** <p>En esta clase primero creamos los atributos que tiene que contener, primero creamos el atributo del valor que en este proyecto es el 
contacto y también sus dos nodos hijos (left y right), en su constructor pasamos como parámetro el contacto e instanciamos a sus hijos como null y 
finalizamos con sus getters y setters.

###### Paquete Controlador
En este paquete contenemos las clases: 
**ArbolContactos:**
El siguiente código representa una implementación en Java de un árbol de búsqueda binaria para gestionar contactos. La clase `ArbolContactos` contiene métodos para agregar, buscar y eliminar contactos, así como para agregar correos electrónicos y detalles de redes sociales a un contacto. También proporciona métodos para imprimir el árbol en diferentes órdenes (preorden, inorden, postorden y en anchura), y obtener el número de contactos y niveles en el árbol.

El árbol se estructura mediante la clase `Node`, que representa un nodo individual con un objeto `Contacto` y dos punteros (`left` y `right`) a los nodos hijos izquierdo y derecho. La adición, búsqueda y eliminación de contactos se realizan de forma recursiva, manteniendo la estructura del árbol de búsqueda binaria y garantizando que los contactos estén ordenados alfabéticamente por su nombre.

El método `agregarContacto` permite agregar nuevos contactos de manera ordenada al árbol, evitando duplicados. El método `buscarContacto` busca un contacto por su nombre y devuelve su información, si existe. El método `eliminarContacto` elimina un contacto por su nombre, reajustando los nodos para mantener la estructura del árbol. Además, se pueden agregar correos electrónicos y detalles de redes sociales a los contactos existentes mediante los métodos `agregarCorreo` y `agregarRedSocial`.

Para visualizar el contenido del árbol, se proporcionan métodos para imprimirlo en diferentes órdenes. El recorrido preorden muestra primero la raíz, seguido por sus hijos izquierdo y derecho. El recorrido inorden muestra los contactos en orden ascendente. El recorrido postorden muestra los hijos antes de la raíz. Y el recorrido en anchura imprime los contactos nivel por nivel.

Por último, se ofrecen métodos para obtener el número total de contactos y el número de niveles en el árbol, utilizando funciones recursivas para contar los elementos mientras se recorre el árbol.


**VistaControlador:**
El código representa el controlador de la vista para gestionar contactos utilizando un árbol de búsqueda binaria en Java. La clase `VistaControlador` interactúa con la clase `ContactosVista`, que muestra el menú y recopila la entrada del usuario.

El método `ejecutarMenu()` muestra el menú y permite al usuario seleccionar diversas opciones para agregar, buscar y eliminar contactos, así como agregar correos electrónicos y detalles de redes sociales. También permite imprimir el árbol en diferentes órdenes, mostrar el número de contactos y el número de niveles en el árbol.

Los métodos privados como `agregarContacto()`, `buscarContacto()`, `eliminarContacto()`, `agregarCorreo()`, `agregarRedSocial()`, `mostrarNumeroContactos()` y `mostrarNumeroNiveles()` realizan las operaciones correspondientes en el árbol de búsqueda binaria utilizando la clase `ArbolContactos`, que se crea y se inicializa en el constructor de `VistaControlador`.
#### Método `agregarContacto()`
- Solicita al usuario que ingrese el nombre y el número de teléfono del nuevo contacto mediante los métodos `ContactosVista.ingresarNombreContacto()` y `ContactosVista.ingresarNumeroTelefono()`.
- Crea un nuevo objeto `Contacto` con el nombre y número de teléfono ingresados.
- Agrega el nuevo contacto al árbol de búsqueda binaria utilizando el método `arbolContactos.agregarContacto(nuevoContacto)`.
- Muestra un mensaje indicando que el contacto ha sido agregado correctamente con `ContactosVista.mostrarMensaje("Contacto agregado correctamente.")`.

#### Método `buscarContacto()`
- Solicita al usuario que ingrese el nombre del contacto que desea buscar mediante `ContactosVista.ingresarNombreContacto()`.
- Busca el contacto en el árbol de búsqueda binaria utilizando el método `arbolContactos.buscarContacto(nombre)`.
- Si el contacto es encontrado, muestra un mensaje con la información del contacto mediante `ContactosVista.mostrarMensaje("Contacto encontrado:\n" + contactoEncontrado)`.
- Si el contacto no es encontrado, muestra un mensaje indicando que no se encontró el contacto y pregunta si desea agregar un nuevo contacto con el mismo nombre. Si el usuario responde "S", repite el proceso para ingresar el número de teléfono y crea un nuevo contacto, que es agregado al árbol.

#### Método `eliminarContacto()`
- Solicita al usuario que ingrese el nombre del contacto que desea eliminar mediante `ContactosVista.ingresarNombreContacto()`.
- Elimina el contacto con el nombre ingresado del árbol de búsqueda binaria utilizando el método `arbolContactos.eliminarContacto(nombre)`.
- Muestra un mensaje indicando que el contacto ha sido eliminado correctamente con `ContactosVista.mostrarMensaje("Contacto eliminado correctamente.")`.

#### Método `agregarCorreo()`
- Solicita al usuario que ingrese el nombre del contacto al que desea agregar el correo electrónico mediante `ContactosVista.ingresarNombreContacto()`.
- Solicita al usuario que ingrese el correo electrónico mediante `ContactosVista.ingresarCorreo()`.
- Agrega el correo electrónico al contacto correspondiente en el árbol de búsqueda binaria utilizando el método `arbolContactos.agregarCorreo(nombre, correo)`.

#### Método `agregarRedSocial()`
- Solicita al usuario que ingrese el nombre del contacto al que desea agregar la red social mediante `ContactosVista.ingresarNombreContacto()`.
- Solicita al usuario que ingrese el nombre de la red social y su URL mediante `ContactosVista.ingresarRedSocial()` y `ContactosVista.ingresarURL()`.
- Agrega los detalles de la red social al contacto correspondiente en el árbol de búsqueda binaria utilizando el método `arbolContactos.agregarRedSocial(nombre, redSocial, url)`.

#### Método `mostrarNumeroContactos()`
- Obtiene el número total de contactos en el árbol de búsqueda binaria utilizando el método `arbolContactos.obtenerNumeroContactos()`.
- Muestra un mensaje con el número de contactos mediante `ContactosVista.mostrarMensaje("Número de contactos: " + numeroContactos)`.

#### Método `mostrarNumeroNiveles()`
- Obtiene el número de niveles en el árbol de búsqueda binaria utilizando el método `arbolContactos.obtenerNumeroNiveles()`.
- Muestra un mensaje con el número de niveles mediante `ContactosVista.mostrarMensaje("Número de niveles del árbol: " + numeroNiveles)`.

###### Paquete Vista
En este paquete contenemos la clase:
**ContactosVista:**
El código representa la clase `ContactosVista`, que proporciona métodos para interactuar con el usuario mediante la consola para gestionar contactos utilizando un árbol de búsqueda binaria.

El método `mostrarMenu()` muestra el menú de opciones para el usuario, que incluye operaciones como agregar, buscar y eliminar contactos, así como imprimir el árbol en diferentes órdenes y obtener el número de contactos y niveles en el árbol. El usuario puede ingresar el número correspondiente a la opción deseada.

Los métodos `ingresarNombreContacto()`, `ingresarNumeroTelefono()`, `ingresarCorreo()`, `ingresarRedSocial()` y `ingresarURL()` permiten al usuario ingresar información como el nombre del contacto, número de teléfono, correo electrónico, red social y URL, respectivamente.

El método `mostrarMensaje(String mensaje)` muestra un mensaje en la consola para informar al usuario sobre el resultado de una operación o cualquier otra información relevante.

El método `ingresarOpcion(String mensaje)` muestra un mensaje en la consola y permite al usuario ingresar una opción (S/N) para ciertas interacciones.

###### Paquete Main
En este paquete contenemos la clase principal la cual se encarga de la ejecucion de todo el sistema:
**EstrucuturaPracticaContactos:**
El código representa la clase principal `EstructuraPracticaContactos`, que es el punto de entrada del programa para gestionar contactos utilizando un árbol de búsqueda binaria en Java.

El método `main` crea una instancia de `VistaControlador`, que actúa como el controlador de la vista y del árbol de búsqueda binaria. Luego, llama al método `ejecutarMenu()` de `VistaControlador` para mostrar el menú de opciones y permitir al usuario interactuar con el programa.
