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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmolina
 */
public class PilaZ {
    public static void main(String[] args) throws FileNotFoundException, IOException {
     /*   Pila<String> miPila = new Pila();
        miPila.push("Embappe");
        miPila.push("James");
        miPila.push("Jerry");
        miPila.push("Modrick");
        miPila.push("Lukakus");
        miPila.display();
        System.out.println("En el tope está:" + miPila.peek().getValor());
        System.out.println(miPila.getSize());
        System.out.println(miPila.pull().getValor());
        System.out.println(miPila.getSize());*/
        BufferedReader br=new BufferedReader(new FileReader("H:/Estructura/Profesor Hernán/Pila/datos.txt"));
        String cadena= getString("datos.txt");
        System.out.println(cadena);
        if (validarExpresion(cadena))
            System.out.println("La cadena está bien");
        else 
            System.out.println("La cadena tiene error");
    }
    
    public static String getString (String archivo) {
        String cadena="";
        try {
             FileReader file = new FileReader(archivo);
             BufferedReader br= new BufferedReader(file);
            try {
                cadena=br.readLine();
            } catch (IOException ex) {
                System.out.println("Error en lectura de archivo");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no existe");
        }
        return cadena;
    }
    public static boolean validarExpresion(String cadena) {
    Pila<Character> pila= new Pila();
       char actual, anterior;
        for (int i = 0; i < cadena.length(); i++) {
        actual=cadena.charAt(i);
            if (actual == '(' || actual == '[' || actual == '{') {
            pila.push(actual);
            } else if (!pila.isEmpty()){
            anterior=pila.peek().getValor();
            if ((actual==')' && anterior=='(') || (actual=='}' && anterior=='{') || (actual==']' && anterior=='[')) {
            pila.pull();
            }
            }
        }
    return pila.isEmpty(); 
    }
}
