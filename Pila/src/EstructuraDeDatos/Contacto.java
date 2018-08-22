/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDeDatos;

import java.util.Enumeration;
import java.util.Hashtable;
/**
 *
 * @author dmolina
 */
public class Contacto {
    private Hashtable<String, Persona> contactos;

    public Contacto() {
        this.contactos = new Hashtable<>();
    }

    public void adicionar(Persona p) {
        this.contactos.put(p.getCedula(), p);
    }

    public boolean eliminar(String cedula) {
        if (contactos.isEmpty()) {
            return false;
        } else if (this.contactos.contains(cedula)) {
            this.contactos.remove(cedula);
            return true;
        } else {
            return false;
        }
    }

    public Persona buscar(String cedula) {
        if (!this.contactos.isEmpty()) {
            if (this.contactos.containsKey(cedula)) {
                return this.contactos.get(cedula);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void display() {
        System.out.println("El tamaño de la lista es: " + this.contactos.size());
        Enumeration<Persona> elementos = this.contactos.elements();
        while (elementos.hasMoreElements()) {
            Persona next = elementos.nextElement();
            System.out.println(next.toString());
        }
    }

    public void eliminarTodos() {
    Enumeration<Persona> elementos = this.contactos.elements();
    while (elementos.hasMoreElements()) {
    this.contactos.remove(elementos.nextElement().getCedula());
    }
    System.out.println("La eliminacion fue completa");
    }

    public boolean modificar(String Cedula, Persona p) {
    return true;
    }
}
