/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.javapractice;

import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class Factorizer {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("What number would you like to factor?");
        int num = inputReader.nextInt();
        int perfectNumber = 0;
        System.out.println("Your number is: " + num);
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                System.out.println(i);
                perfectNumber += i;
            }
        }
        if (num == perfectNumber) {
            System.out.println("Your number " + num + " is a Perfect Number.");
        } else {
            System.out.println("Your number " + num + " is not a Perfect Number.");
        }
        if (perfectNumber == 1) {
            System.out.println("Your number " + num + " is a Prime Number");
        } else {
            System.out.println("Your number " + num + " is not a Prime Number");
        }
        if (perfectNumber > num) {
            System.out.println("Your number " + num + " is an Abundant Number");
        } else {
            System.out.println("Your number " + num + " is not an Abundant Number");
        }
    }
}
