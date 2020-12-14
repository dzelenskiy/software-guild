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
public class BiggerBetterAdder {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int number1 = 0;
        int number2 = 0;
        int number3 = 0;
        System.out.println("Please input first number to add: ");
        number1 = inputReader.nextInt();
        System.out.println("Please input second number to add: ");
        number2 = inputReader.nextInt();
        System.out.println("Please input third number to add: ");
        number3 = inputReader.nextInt();
        int sum = number1 + number2 + number3;
        System.out.println("Thank you! Please wait while we add for you.");
        System.out.println("Your result for " + number1 + "+" + number2 + "+" + number3 + " is " + sum);

    }
}
