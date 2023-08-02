/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.estructurapracticacontactos.controlador;

import ec.edu.ups.estructurapracticacontactos.modelo.Contacto;
import ec.edu.ups.estructurapracticacontactos.vista.ContactosVista;

/**
 *
 * @author casa
 */
public class VistaControlador {

    ArbolContactos arbolContactos;

    public VistaControlador() {
        arbolContactos = new ArbolContactos();
    }

    public void ejecutarMenu() {

        int opcion;

        do {
            opcion = ContactosVista.mostrarMenu();
            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:
                    eliminarContacto();
                    break;
                case 4:
                    agregarCorreo();
                    break;
                case 5:
                    agregarRedSocial();
                    break;
                case 6:
                    arbolContactos.imprimirPreorder();
                    break;
                case 7:
                    arbolContactos.imprimirInorder();
                    break;
                case 8:
                    arbolContactos.imprimirPostorder();
                    break;
                case 9:
                    arbolContactos.imprimirAnchura();
                    break;
                case 10:
                    mostrarNumeroContactos();
                    break;
                case 11:
                    mostrarNumeroNiveles();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    ContactosVista.mostrarMensaje("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private void agregarContacto() {
        String nombre = ContactosVista.ingresarNombreContacto();
        String numeroTelefono = ContactosVista.ingresarNumeroTelefono();
        Contacto nuevoContacto = new Contacto(nombre, numeroTelefono);
        arbolContactos.agregarContacto(nuevoContacto);
        ContactosVista.mostrarMensaje("Contacto agregado correctamente.");
    }

    private void buscarContacto() {
        String nombre = ContactosVista.ingresarNombreContacto();
        Contacto contactoEncontrado = arbolContactos.buscarContacto(nombre);
        if (contactoEncontrado != null) {
            ContactosVista.mostrarMensaje("Contacto encontrado:\n" + contactoEncontrado);
        } else {
            ContactosVista.mostrarMensaje("Contacto no encontrado.");
            String opcionAgregar = ContactosVista.ingresarOpcion("¿Desea agregar un nuevo contacto con ese nombre? (S/N): ");
            if (opcionAgregar.equalsIgnoreCase("S")) {
                String numeroTelefono = ContactosVista.ingresarNumeroTelefono();
                Contacto nuevoContacto = new Contacto(nombre, numeroTelefono);
                arbolContactos.agregarContacto(nuevoContacto);
                ContactosVista.mostrarMensaje("Nuevo contacto agregado correctamente.");
            }
        }
    }

    private void eliminarContacto() {
        String nombre = ContactosVista.ingresarNombreContacto();
        arbolContactos.eliminarContacto(nombre);
        ContactosVista.mostrarMensaje("Contacto eliminado correctamente.");
    }

    private void agregarCorreo() {
        String nombre = ContactosVista.ingresarNombreContacto();
        String correo = ContactosVista.ingresarCorreo();
        arbolContactos.agregarCorreo(nombre, correo);
    }

    private void agregarRedSocial() {
        String nombre = ContactosVista.ingresarNombreContacto();
        String redSocial = ContactosVista.ingresarRedSocial();
        String url = ContactosVista.ingresarURL();
        arbolContactos.agregarRedSocial(nombre, redSocial, url);
    }

    private void mostrarNumeroContactos() {
        int numeroContactos = arbolContactos.obtenerNumeroContactos();
        ContactosVista.mostrarMensaje("Número de contactos: " + numeroContactos);
    }

    private void mostrarNumeroNiveles() {
        int numeroNiveles = arbolContactos.obtenerNumeroNiveles();
        ContactosVista.mostrarMensaje("Número de niveles del árbol: " + numeroNiveles);
    }
}
