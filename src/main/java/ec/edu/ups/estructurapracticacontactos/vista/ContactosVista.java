/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.estructurapracticacontactos.vista;

import java.util.Scanner;

/**
 *
 * @author casa
 */
public class ContactosVista {
    private static Scanner scanner = new Scanner(System.in);

    public static int mostrarMenu() {
        System.out.println("------MENÚ------");
        System.out.println("\n1. Agregar Contacto \n2. Buscar Contacto \n3. Eliminar Contacto \n4. Agregar Correo \n5. Agregar Red Social \n6. Imprimir árbol: Preorder \n7. Imprimir árbol: Inorder \n8. Imprimir árbol: Postorder \n9. Imprimir árbol: Anchura \n10. Obtener número de contactos \n11. Obtener número de niveles \n0. Salir");
        System.out.println("Ingrese una opción: ");
        return scanner.nextInt();
    }

    public static String ingresarNombreContacto() {
        System.out.print("Ingrese el nombre del contacto: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static String ingresarNumeroTelefono() {
        System.out.print("Ingrese el número de teléfono: ");
        return scanner.nextLine();
    }

    public static String ingresarCorreo() {
        System.out.print("Ingrese el correo: ");
        return scanner.nextLine();
    }

    public static String ingresarRedSocial() {
        System.out.print("Ingrese la red social (clave): ");
        return scanner.nextLine();
    }

    public static String ingresarURL() {
        System.out.print("Ingrese la URL: ");
        return scanner.nextLine();
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static String ingresarOpcion(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
