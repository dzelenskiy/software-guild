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
public class SimpleSort {

    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];

        boolean unordered = true;

        int k = 0;
        int temp;

        for (int i = 0; i < firstHalf.length; i++) {
            wholeNumbers[i] = secondHalf[i];
        }
        for (int i = 0, j = 12; i < secondHalf.length; i++, j++) {
            wholeNumbers[j] = firstHalf[i];
        }
        while (unordered) {
            unordered = false;
            k++;
            for (int i = 0; i < wholeNumbers.length - k; i++) {
                if (wholeNumbers[i] > wholeNumbers[i + 1]) {
                    temp = wholeNumbers[i];
                    wholeNumbers[i] = wholeNumbers[i + 1];
                    wholeNumbers[i + 1] = temp;
                    unordered = true;
                }
            }
        }
        for (int element : wholeNumbers) {
            System.out.print(element + " ");
        }
    }

}
