/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.estructurapracticacontactos.controlador;

import ec.edu.ups.estructurapracticacontactos.modelo.Contacto;
import ec.edu.ups.estructurapracticacontactos.modelo.Node;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author casa
 */
public class ArbolContactos {

    private Node root;

    public ArbolContactos() {
        this.root = null;
    }

    public void agregarContacto(Contacto contacto) {
        root = agregarContactoRecursivo(root, contacto);
    }

    private Node agregarContactoRecursivo(Node nodo, Contacto contacto) {
        if (nodo == null) {
            return new Node(contacto);
        }

        String nombreActual = nodo.getContacto().getNombre();
        String nuevoNombre = contacto.getNombre();

        if (nuevoNombre.compareTo(nombreActual) < 0) {
            nodo.setLeft(agregarContactoRecursivo(nodo.getLeft(), contacto));
        } else if (nuevoNombre.compareTo(nombreActual) > 0) {
            nodo.setRight(agregarContactoRecursivo(nodo.getRight(), contacto));
        } else {
            System.out.println("El contacto ya existe. ¿Desea actualizar el número de teléfono? (S/N)");
            Scanner scanner = new Scanner(System.in);
            String opcion = scanner.nextLine().trim().toUpperCase();
            if (opcion.equals("S")) {
                nodo.getContacto().setTelefono(contacto.getTelefono());
                System.out.println("Número de teléfono actualizado.");
            } else {
                System.out.println("Contacto existente no actualizado.");
            }
        }
        return nodo;
    }

    public Contacto buscarContacto(String nombre) {
        return buscarContactoRecursivo(root, nombre);
    }

    private Contacto buscarContactoRecursivo(Node nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        String nombreActual = nodo.getContacto().getNombre();

        if (nombre.equals(nombreActual)) {
            return nodo.getContacto();
        } else if (nombre.compareTo(nombreActual) < 0) {
            return buscarContactoRecursivo(nodo.getLeft(), nombre);
        } else {
            return buscarContactoRecursivo(nodo.getRight(), nombre);
        }
    }

    public void eliminarContacto(String nombre) {
        root = eliminarContactoRecursivo(root, nombre);
    }

    private Node eliminarContactoRecursivo(Node nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        String nombreActual = nodo.getContacto().getNombre();

        if (nombre.compareTo(nombreActual) < 0) {
            nodo.setLeft(eliminarContactoRecursivo(nodo.getLeft(), nombre));
        } else if (nombre.compareTo(nombreActual) > 0) {
            nodo.setRight(eliminarContactoRecursivo(nodo.getRight(), nombre));
        } else {
            if (nodo.getLeft()== null) {
                return nodo.getRight();
            } else if (nodo.getRight()== null) {
                return nodo.getLeft();
            }

            Node sucesor = encontrarSucesor(nodo.getRight());
            nodo.getContacto().setNombre(sucesor.getContacto().getNombre());
            nodo.getContacto().setTelefono(sucesor.getContacto().getTelefono());
            nodo.setRight(eliminarContactoRecursivo(nodo.getRight(), sucesor.getContacto().getNombre()));
        }

        return nodo;
    }

    private Node encontrarSucesor(Node nodo) {
        if (nodo.getLeft()== null) {
            return nodo;
        }
        return encontrarSucesor(nodo.getLeft());
    }

    public void agregarCorreo(String nombre, String correo) {
        Node nodoContacto = buscarNodoContacto(root, nombre);
        if (nodoContacto != null) {
            nodoContacto.getContacto().agregarCorreos(correo);
            System.out.println("Correo agregado correctamente.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void agregarRedSocial(String nombre, String redSocial, String URL) {
        Node nodoContacto = buscarNodoContacto(root, nombre);
        if (nodoContacto != null) {
            nodoContacto.getContacto().agregarRedesSociales(redSocial, URL);
            System.out.println("Red social agregada correctamente.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    private Node buscarNodoContacto(Node nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        String nombreActual = nodo.getContacto().getNombre();

        if (nombre.equals(nombreActual)) {
            return nodo;
        } else if (nombre.compareTo(nombreActual) < 0) {
            return buscarNodoContacto(nodo.getLeft(), nombre);
        } else {
            return buscarNodoContacto(nodo.getRight(), nombre);
        }
    }

    public void imprimirPreorder() {
        System.out.println("Árbol en Preorder:");
        imprimirPreorderRecursivo(root);
    }

    private void imprimirPreorderRecursivo(Node nodo) {
        if (nodo != null) {
            System.out.println(nodo.getContacto());
            imprimirPreorderRecursivo(nodo.getLeft());
            imprimirPreorderRecursivo(nodo.getRight());
        }
    }

    public void imprimirInorder() {
        System.out.println("Árbol en Inorder:");
        imprimirInorderRecursivo(root);
    }

    private void imprimirInorderRecursivo(Node nodo) {
        if (nodo != null) {
            imprimirInorderRecursivo(nodo.getLeft());
            System.out.println(nodo.getContacto());
            imprimirInorderRecursivo(nodo.getRight());
        }
    }

    public void imprimirPostorder() {
        System.out.println("Árbol en Postorder:");
        imprimirPostorderRecursivo(root);
    }

    private void imprimirPostorderRecursivo(Node nodo) {
        if (nodo != null) {
            imprimirPostorderRecursivo(nodo.getLeft());
            imprimirPostorderRecursivo(nodo.getRight());
            System.out.println(nodo.getContacto());
        }
    }

    public void imprimirAnchura() {
        System.out.println("Árbol en Anchura:");
        Queue<Node> cola = new LinkedList<>();
        cola.add(root);

        while (!cola.isEmpty()) {
            Node nodo = cola.poll();
            System.out.println(nodo.getContacto());

            if (nodo.getLeft()!= null) {
                cola.add(nodo.getLeft());
            }

            if (nodo.getRight()!= null) {
                cola.add(nodo.getRight());
            }
        }
    }

    public int obtenerNumeroContactos() {
        return obtenerNumeroContactosRecursivo(root);
    }

    private int obtenerNumeroContactosRecursivo(Node nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + obtenerNumeroContactosRecursivo(nodo.getLeft()) + obtenerNumeroContactosRecursivo(nodo.getRight());
    }

    public int obtenerNumeroNiveles() {
        return obtenerNumeroNivelesRecursivo(root);
    }

    private int obtenerNumeroNivelesRecursivo(Node nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(obtenerNumeroNivelesRecursivo(nodo.getLeft()), obtenerNumeroNivelesRecursivo(nodo.getRight()));
    }
    public Node getRaiz() {
        return root;
    }

    public void setRaiz(Node raiz) {
        this.root = raiz;
    }
}
