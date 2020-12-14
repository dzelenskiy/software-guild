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
public class CheckSumArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter sum to check: ");
        int sum = sc.nextInt();

        int[] numCheck = {2, 4, 5, 6};

        boolean sumCheck = false;

        for (int i = 0; i < numCheck.length; i++) {
            for (int j = 0; j < numCheck.length; j++) {
                if (numCheck[i] + numCheck[j] == sum && numCheck[i] != numCheck[j]) {
                    sumCheck = true;
                    System.out.println(numCheck[i] + "+" + numCheck[j] + "=" + sum);
                    System.out.println("True");
                } else {
                    sumCheck = false;
                    System.out.println("False");
                }
            }
        }
        if (sumCheck == false) {
            System.out.println("None of the numbers in the array add up to your number.");
        } else if (sumCheck == true) {
            System.out.println("One or more numbers in the array add up to your number.");
        }

    }

}
