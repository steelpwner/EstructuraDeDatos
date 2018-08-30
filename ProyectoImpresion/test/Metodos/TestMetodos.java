/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Metodos.*;
import Ventanas.*;
import java.util.Iterator;
import org.junit.Assert;

/**
 *
 * @author Diego
 */
public class TestMetodos {

    public TestMetodos() {
   
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMetodoCola() {
    Assert.assertEquals(6,Metodos.cargarDatos("spool.txt").getSize());
    Cola<String> cola= new Cola();
    cola.enqueue("testing");
    Assert.assertEquals(cola.getEnd(), cola.peek());
    }
    
    @Test
    public void testIterator() {
    Cola<String> cola= new Cola();
    cola.enqueue("testingiterator");
    Iterator<String> iterador= cola.iterator();
    String next=iterador.next();
    Assert.assertEquals(next, cola.peek().getValor());
    }
    
    @Test
    public void testSize() {
    Cola<String> cola= new Cola();
    Assert.assertEquals(cola.isEmpty(),cola.getSize()==0);
    cola.enqueue("testingsize");
    Assert.assertEquals(cola.isEmpty(),cola.getSize()==0);
    }
    
}
