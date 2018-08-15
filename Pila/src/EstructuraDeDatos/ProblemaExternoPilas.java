/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDeDatos;

import java.util.Scanner;

/**
 *
 * @author Diego
 */
//HACER UNA SERIE DE SUMAS, RESTAS, MULTIPLICACIONES Y DIVISIONES DE UN NÚMERO, REGISTRAR EN UNA PILA CADA UNO Y HACER UN MENÚ QUE PERMITA VOLVER ATRÁS Y ADELANTE.
public class ProblemaExternoPilas {
    public static void main(String[] args) {
        double valor=0;
        Scanner lectura= new Scanner(System.in);
        Pila<Double> irHaciaAtrasNumeros= new Pila();
        Pila<String> irHaciaAtrasSignos= new Pila();
        Pila<Double> numerosInsertados= new Pila();
        Pila<String> signosInsertados= new Pila();
        boolean salir=false;
        while (!salir) {
            System.out.println("Valor actual: "+valor);
            System.out.println("Digite:\n "
                    + "1. Sumar\n"
                    + "2. Restar\n"
                    + "3. Multiplicar\n"
                    + "4. Dividir\n"
                    + "5. Ir atrás\n"
                    + "6. Ir adelante\n"
                    + "7. Salir\n"
                    + "------------------");
        int operacion=lectura.nextInt();
        switch (operacion) {
            case 1: System.out.println("Digite el número a sumar: ");
            double valorSuma=lectura.nextDouble();
            valor+=valorSuma;
            signosInsertados.push("+");
            numerosInsertados.push(valorSuma);
            irHaciaAtrasSignos.vaciarPila();
            irHaciaAtrasNumeros.vaciarPila();
            break;
            case 2: System.out.println("Digite el número a restar: ");
            double valorResta=lectura.nextDouble();
            valor-=valorResta;
            signosInsertados.push("-");
            numerosInsertados.push(valorResta);
            irHaciaAtrasSignos.vaciarPila();
            irHaciaAtrasNumeros.vaciarPila();
            break;
            case 3: System.out.println("Digite el número a multiplicar: ");
            double valorMultiplicacion=lectura.nextDouble();
            valor*=valorMultiplicacion;
            signosInsertados.push("*");
            numerosInsertados.push(valorMultiplicacion);
            irHaciaAtrasSignos.vaciarPila();
            irHaciaAtrasNumeros.vaciarPila();
            break;
            case 4: System.out.println("Digite el número a dividir: ");
            double valorDivision=lectura.nextDouble();
            valor/=valorDivision;
            signosInsertados.push("/");
            numerosInsertados.push(valorDivision);
            irHaciaAtrasSignos.vaciarPila();
            irHaciaAtrasNumeros.vaciarPila();
            break;
            case 5: 
                if (!signosInsertados.isEmpty() && !numerosInsertados.isEmpty()) {
                String signo=signosInsertados.pull().getValor();
                double numero=numerosInsertados.pull().getValor();
                switch(signo) {
                case "+": valor-=numero;
                irHaciaAtrasNumeros.push(numero);
                irHaciaAtrasSignos.push(signo);
                break;
                case "-": valor+=numero;
                irHaciaAtrasNumeros.push(numero);
                irHaciaAtrasSignos.push(signo);
                break;
                case "*": valor/=numero;
                irHaciaAtrasNumeros.push(numero);
                irHaciaAtrasSignos.push(signo);
                break;
                case "/": valor*=numero;
                irHaciaAtrasNumeros.push(numero);
                irHaciaAtrasSignos.push(signo);
                break;
             }
             } else {
                    System.out.println("No se puede ir atrás");
                }
             break;
            case 6: 
            if (irHaciaAtrasNumeros.isEmpty() && irHaciaAtrasSignos.isEmpty()) 
                    System.out.println("No hay opción de ir hacia alante.");
            else {
                String signo=irHaciaAtrasSignos.pull().getValor();
                double numero=irHaciaAtrasNumeros.pull().getValor();
                switch (signo) {
                 case "+": valor+=numero;
                numerosInsertados.push(numero);
                signosInsertados.push(signo);
                break;
                case "-": valor-=numero;
                 numerosInsertados.push(numero);
                 signosInsertados.push(signo);
                break;
                case "*": valor*=numero;
                 numerosInsertados.push(numero);
                 signosInsertados.push(signo);
                break;
                case "/": valor/=numero;
                numerosInsertados.push(numero);
                signosInsertados.push(signo);
                break;
                }
            }
            break;
            case 7: salir=true;
            break;
            default: System.out.println("No seleccionó una opción válida");
            break;
        }
            System.out.println("---------------------------------");
        }
        
    }
}
