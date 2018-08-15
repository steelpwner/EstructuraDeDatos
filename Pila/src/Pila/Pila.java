package Pila;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmolina
 */
public class Pila<E> {
    private Nodo top;
    private int size;

    public Pila() {
        this.size = 0;
        this.top = null;
    }

    public void push(E valor) {
        Nodo<E> nodo = new Nodo(valor);
        if (this.isEmpty()) {
            this.setTop(nodo);
            top.setLink(null);
        } else {
            nodo.setLink(top);
            this.setTop(nodo);
        }
        this.setSize(this.getSize()+1);
    }

    public Nodo<E> pull() {
        if (!this.isEmpty()) {
            Nodo<E> nodo = this.getTop();
            this.setTop(nodo.getLink());
            this.setSize(this.getSize() - 1);
            nodo.setLink(null);
            return nodo;
        } else {
            return null;
        }
    }

    public Nodo<E> peek() {
       return this.top;
    }

    public Nodo getTop() {
        return top;
    }

    public void setTop(Nodo top) {
        this.top = top;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size > 0) 
            this.size = size;
         else 
            this.size = 0;
        
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void vaciarPila() {
    this.top=null;
    this.size=0;
    }
    public void display() {
        Nodo<E> nodo = this.getTop();
        System.out.println("El tamaño de la pila es: " + this.getSize());
        while (nodo != null) {
            System.out.print(nodo.getValor().toString() + " ");
            nodo = nodo.getLink();
        }
        System.out.println("");
    }

}
