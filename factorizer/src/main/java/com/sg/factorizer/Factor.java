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
public class Factor {

    private int num;
    private int[] factors;
    private boolean perfectNumber = false;
    private boolean primeNumber = false;
    private boolean abundantNumber = false;
    int perfNumTrac = 0;

    public int[] factors(int num) {
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                System.out.println(i);
                perfNumTrac += i;
            }
        }
        return factors;
    }

    public boolean perfectNum(int num) {
        return true;
    }

    public boolean primeNum(int num) {
        return true;
    }

    public boolean abundantNum(int num) {
        return true;
    }

}
