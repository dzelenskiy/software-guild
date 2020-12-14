/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class UserIOImpl implements UserIO {

    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }
    
    @Override
    public int readInt(String prompt) {
        int num = 0;
        boolean inputError = true;
        do {
            System.out.println(prompt);
            if(sc.hasNextInt()) {
                num = sc.nextInt();
                sc.nextLine();
                inputError = false;
            } else {
                sc.next();
            }
        } while (inputError);
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int num = 0;
        boolean inputError = true;
        do {
            System.out.println(prompt);
            if(sc.hasNextInt()) {
                num = sc.nextInt();
                sc.nextLine();
                inputError = false;
            } else {
                sc.next();
            }
        } while (num < min || num > max || inputError);
        return num;
    }

    @Override
    public double readDouble(String prompt) {
        double num = sc.nextDouble();
        sc.nextLine();
        System.out.println(prompt);
        return num;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double num;
        do {
            System.out.println(prompt);
            num = sc.nextDouble();
            sc.nextLine();
        } while (num < min || num > max);
        return num;
    }

    @Override
    public float readFloat(String prompt) {
        float num = sc.nextFloat();
        sc.nextLine();
        System.out.println(prompt);
        return num;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float num;
        do {
            System.out.println(prompt);
            num = sc.nextFloat();
            sc.nextLine();
        } while (num < min || num > max);
        return num;
    }

    @Override
    public long readLong(String prompt) {
        long num = sc.nextLong();
        sc.nextLine();
        System.out.println(prompt);
        return num;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long num;
        do {
            System.out.println(prompt);
            num = sc.nextLong();
            sc.nextLine();
        } while (num < min || num > max);
        return num;
    }

    @Override
    public String readBigDecimal(String prompt) {
        BigDecimal num = new BigDecimal("0");
        boolean inputError = true;
        do {
            System.out.println(prompt);
            if(sc.hasNextBigDecimal()) {
                num = sc.nextBigDecimal();
                sc.nextLine();
                inputError = false;
            } else {
                sc.next();
            }
        } while (inputError);
        return num.toString();            
        
    }

    @Override
    public String readBigDecimal(String prompt, double min, double max) {
        BigDecimal num = new BigDecimal("0");
        boolean inputError = true;
        do {
            System.out.println(prompt);
            if(sc.hasNextBigDecimal()) {
                num = sc.nextBigDecimal();
                sc.nextLine();
                inputError = false;
            } else {
                sc.next();
            }
        } while (num.doubleValue() < min || num.doubleValue() > max || inputError);
        return num.toString();    
    }
    
    
}
