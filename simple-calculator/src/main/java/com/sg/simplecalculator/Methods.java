/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class Methods implements UserIO {
    
    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        double num = sc.nextDouble();
        System.out.println(prompt);
        return num;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double num;
        do {
            System.out.println(prompt + min + max);
            num = sc.nextDouble();
        } while (num > min || num > max);
        return num;
    }

    @Override
    public float readFloat(String prompt) {
        float num = sc.nextFloat();
        System.out.println(prompt);
        return num;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float num;
        do{
            System.out.println(prompt + min + max);
            num = sc.nextFloat();
        } while (num > min || num > max);
        return num;
    }

    @Override
    public int readInt(String prompt) {
        int num = sc.nextInt();
        System.out.println(prompt);
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int num;
        do {
            System.out.println(prompt + min + max);
            num = sc.nextInt();
        } while (num > min || num > max);
        return num;
    }

    @Override
    public long readLong(String prompt) {
        long num = sc.nextLong();
        System.out.println(prompt);
        return num;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long num;
        do {
            System.out.println(prompt + min + max);
            num = sc.nextLong();
        } while (num > min || num > max);
        return num;
    }
    
    @Override
    public String readString(String prompt) {
        prompt = sc.next();
        return prompt;
    }

    public Methods() {
    }


}
