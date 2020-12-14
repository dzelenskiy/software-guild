/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.javapractice;

/**
 *
 * @author DZ
 */
public class AnagramPractice {

    public static void main(String[] args) {
        String string1 = "say";
        String string2 = "say";

        char[] array1;
        char[] array2;

        array1 = string1.toCharArray();
        array2 = string2.toCharArray();

        int letterCount = 0;

        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array2.length; j++) {
                    if (array2[j] == array1[i]) {
                        letterCount++;
                        System.out.println(letterCount);
                    }
                }
            }
        }

        if (letterCount == array2.length) {
            System.out.println("You Have Anagrams!");
        } else {
            System.out.println("You do not have Anagrams!");
        }

    }

}
