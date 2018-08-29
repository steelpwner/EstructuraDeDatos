/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDeDatos;

import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author dmolina
 */
public class Tiempo {
   
    public static void main(String[] args) {
    Timer t= new Timer();
     TimerTask task= new TimerTask() {
    int tic=0;
    @Override
    public void run() {
    if (tic%2==0)
    System.out.println("TIC");
    else
    System.out.println("TOC");
    tic++;
    }
    };
    t.schedule(task, 0,3000);
    }
   
}

