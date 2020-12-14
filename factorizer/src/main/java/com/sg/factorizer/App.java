/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizer;
/**
 *
 * @author DZ
 */
public class App {
    public static void main(String[] args) {
        
        int num;
        int[] factors;
        boolean perfectNumber;
        boolean primeNumber;
        boolean abundantNumber;
        
        AskUser start = new AskUser();
        num = start.ask("What number would you like to factor?");
        
        Factor factorize = new Factor();
        factors = factorize.factors(num);
        perfectNumber = factorize.perfectNum(num);
        primeNumber = factorize.primeNum(num);
        abundantNumber = factorize.abundantNum(num);
        
        
        if (perfectNumber = true) {
            System.out.println("Your number " + num + " is a Perfect Number.");
        } else {
            System.out.println("Your number " + num + " is not a Perfect Number.");
        }
        if (primeNumber = true) {
            System.out.println("Your number " + num + " is a Prime Number");
        } else {
            System.out.println("Your number " + num + " is not a Prime Number");
        }
        if (abundantNumber = true) {
            System.out.println("Your number " + num + " is an Abundant Number");
        } else {
            System.out.println("Your number " + num + " is not an Abundant Number");
        }
    }
 }

    
    

