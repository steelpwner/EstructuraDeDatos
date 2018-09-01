package Metodos;

import Ventanas.Dialogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
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
        DefaultTableModel modeloTabla = new DefaultTableModel(cola.getSize(), 1);
        Iterator<String> iterador = cola.iterator();
        int i = 0;
        while (iterador.hasNext()) {
            String next = iterador.next();
            String nombreArchivo = "";
            int j = 0;
            while (next.charAt(j) != ',') {
                nombreArchivo += next.charAt(j);
                j++;
            }
            modeloTabla.setValueAt(nombreArchivo, i, 0);
            i++;
        }
        tabla.setModel(modeloTabla);
    }

    public static void iniciarSimulacion(String next,Cola impresiones, Dialogo dialogo) {

            String nombreArchivo = sacarNombreArchivo(next);
            dialogo.setNombreLabel(nombreArchivo);
            Timer temporizador = new Timer(1000, new ActionListener() {
                long tiempo = sacarSegundosArchivo(next) * 1000;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tiempo > 0) {
                        dialogo.setLblEspera("Espere " + tiempo / 1000 + " segundos");
                        tiempo -= 1000;
                    } else {
                        dialogo.setVisible(false);
                    }
                }
            });
            boolean continuar = true;
            dialogo.setLblEspera("Espere...");
            dialogo.setVisible(true);
            while (continuar) {
                temporizador.start();
                if (!dialogo.isVisible()) {
                    temporizador.stop();
                    continuar = false;
                }
            }
    }
    
    public static String sacarNombreArchivo(String next) {
        int i=0;
        String nombreArchivo = "";
        while (next.charAt(i) != ',') {
            nombreArchivo += next.charAt(i);
            i++;
        }
        i++;
        return nombreArchivo;
    }
    
    public static long sacarSegundosArchivo(String next) {
        int i=0;
        while (next.charAt(i) != ',') {
            i++;
        }
        i++;
        String cadenaTiempo = "";
        while (i < next.length()) {
            cadenaTiempo += next.charAt(i);
            i++;
        }
        return Long.parseLong(cadenaTiempo);
    }
   public static void actualizadorTabla (JTable tabla, Cola<String> impresiones) {
   DefaultTableModel modeloTabla= new DefaultTableModel(tabla.getRowCount()-1,1);
   impresiones.dequeue();
   Iterator<String> iterador= impresiones.iterator();
    int i=0;
       while (iterador.hasNext()) {
           String next = iterador.next();
            String nombreArchivo = "";
            int j = 0;
            while (next.charAt(j) != ',') {
                nombreArchivo += next.charAt(j);
                j++;
            }
            modeloTabla.setValueAt(nombreArchivo, i, 0);
            i++;
       }
   tabla.setModel(modeloTabla);
   }
  
    public static void main(String[] args) {
 
    }

}
