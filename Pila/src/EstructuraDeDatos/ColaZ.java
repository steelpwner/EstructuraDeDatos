/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDeDatos;

import java.util.Arrays;

/**
 *
 * @author dmolina
 */
public class ColaZ {
    public static void main(String[] args) {
        Cola<String> cola = new Cola();
        cola.enqueue("E20");
        cola.enqueue("E22");
        cola.enqueue("F10");
        cola.enqueue("F20");
        cola.enqueue("E25");
        cola.display();
        Nodo<String> nodo= cola.dequeue();
        System.out.println("Se atendió el nodo: "+nodo.getValor());
        cola.display();
    }
}
