/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.estructurapracticacontactos;

import ec.edu.ups.estructurapracticacontactos.controlador.ArbolContactos;
import ec.edu.ups.estructurapracticacontactos.modelo.Contacto;

/**
 *
 * @author casa
 */
public class EstructuraPracticaContactos {

    public static void main(String[] args) {
        ArbolContactos arbolContactos = new ArbolContactos();
        
        Contacto contacto1 = new Contacto("Juan", "12345");
        Contacto contacto2 = new Contacto("Maria", "12345");
        Contacto contacto3 = new Contacto("Pedro", "12345");
        Contacto contacto4 = new Contacto("Pablo", "12345");
        
        arbolContactos.insert(contacto1);
        arbolContactos.insert(contacto2);
        arbolContactos.insert(contacto3);
        arbolContactos.insert(contacto4);
        
        arbolContactos.insert(new Contacto("Julina", "12345"));
        arbolContactos.insert(new Contacto("Jhon", "12345"));
    }
}
