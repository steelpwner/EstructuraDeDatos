package Pruebas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import EstructuraDeDatos.Pila;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dmolina
 */
public class PilaTest {
    
    public PilaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
   
    @Before
    public void setUp() {
    }
    
    @Test
    public void testPushEnPilaVacia() {
    Pila<String> pila = new Pila();
    pila.push("prueba");
    assertEquals("El top no es igual al nodo creado",pila.getTop(), pila.peek());
    assertEquals("Tamaño inicial no es uno",pila.getSize(), 1);
    assertEquals("El link no es nulo",pila.getTop().getLink(), pila.peek().getLink());
    }
    
    @After
    public void tearDown() {
    }
    
     @AfterClass
    public static void tearDownClass() {
    }
    
}
