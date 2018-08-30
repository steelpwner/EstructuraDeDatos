/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Ventanas.Dialogo;
import Ventanas.Principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dmolina
 */
public class Metodos {
   
    public static Cola cargarDatos(String ruta) {
        Cola<String> colaNueva = new Cola();
        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            try {
                while (lector.ready()) {
                    colaNueva.enqueue(lector.readLine());
                }
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return colaNueva;
    }
    
    
    public static void colaATabla(Cola<String> cola, JTable tabla) {
        DefaultTableModel tm = new DefaultTableModel(cola.getSize(), 1);
        Iterator<String> iterador = cola.iterator();
        int i = 0;
        while (iterador.hasNext()) {
            String next = iterador.next();
             String nombreArchivo="";
             int j=0;
             while (next.charAt(j)!=',') {
             nombreArchivo+=next.charAt(j);
             j++;
             }
            tm.setValueAt(nombreArchivo, i, 0);
            i++;
        }
        tabla.setModel(tm);
    }
 
    public static void iniciarSimulacion (Cola impresiones, Dialogo dialogo) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<String> iterador = impresiones.iterator();
                while (iterador.hasNext()) {
                    String next = iterador.next();
                    String nombreArchivo = "", cadenaTiempo = "";
                    int i = 0;
                    while (next.charAt(i) != ',') {
                        nombreArchivo += next.charAt(i);
                        i++;
                    }
                    i++;
                    while (i < next.length()) {
                        cadenaTiempo += next.charAt(i);
                        i++;
                    }
                    long tiempo = Long.parseLong(cadenaTiempo);

                    dialogo.setNombreLabel(nombreArchivo);
                    dialogo.setVisible(true);
                    try {
                        Thread.sleep(tiempo);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dialogo.dispose();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    public static void main(String[] args) {
    
    }   
    
}
