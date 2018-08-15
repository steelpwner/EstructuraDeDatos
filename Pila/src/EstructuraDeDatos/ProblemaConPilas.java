/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDeDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author dmolina
 */
public class ProblemaConPilas {
    public static void main(String[] args) throws FileNotFoundException, IOException {
    Pila<String> miPila= new Pila();
    BufferedReader bf=new BufferedReader(new FileReader("H:/Estructura/Profesor Hernán/Pila/datos.txt"));
    String ecuacion=bf.readLine();
        for (int i = 0; i < ecuacion.length(); i++) {
           switch (ecuacion.substring(i,i+1)) {
               case "(": miPila.push(ecuacion.substring(i, i+1));
               break;
               case ")": if (miPila.peek().getValor().equals("(")) {
               miPila.pull();
               } else {
               miPila.push(ecuacion.substring(i, i+1));
               }
               break;
               case "{": miPila.push(ecuacion.substring(i, i+1));
               break;
               case "}": if (miPila.peek().getValor().equals("{")) {
               miPila.pull();
               } else {
               miPila.push(ecuacion.substring(i, i+1));
               }
               break;
               case "[": miPila.push(ecuacion.substring(i, i+1));
               break;
               case "]": if (miPila.peek().getValor().equals("[")) {
               miPila.pull();
               } else {
               miPila.push(ecuacion.substring(i, i+1));
               }
               break;
           }
        }
      if (miPila.isEmpty()) 
            System.out.println("La ecuación estaba bien");
      else 
            System.out.println("La ecuación tenía problema");
     
      miPila.display();
    }
 
}
