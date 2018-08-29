package Metodos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmolina
 */
public class Nodo<E> {
    private E valor;
    private Nodo link;

    public Nodo() {
    }

    public Nodo(E valor) {
        this.valor = valor;
        this.link=null;
    }
    
    public E getValor() {
        return valor;
    }

    public void setValor(E valor) {
        this.valor = valor;
    }

    public Nodo getLink() {
        return link;
    }

    public void setLink(Nodo link) {
        this.link = link;
    }
    
}
