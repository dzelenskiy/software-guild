/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.possibleanagramsclassexercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word to see the all the possible anagrams:");

        String original = sc.nextLine().toLowerCase().trim();

        char[] originalArray = original.toCharArray();

        System.out.println(Arrays.toString(originalArray));

        for (int i = 0; i < originalArray.length; i++) {
            char[] newArray = new char[originalArray.length];
            newArray[i] = originalArray[originalArray.length - (i + 1)];
            System.out.println(Arrays.toString(newArray));

            for (int j = i + 1; j < i; j++) {

            }

        }

    }

}
