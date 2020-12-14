/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sgprojectweek1;

/**
 *
 * @author DZ
 */
public class SummativeSums {

    public static void main(String[] args) {

        int[] array1 = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] array2 = {999, -60, -77, 14, 160, 301};
        int[] array3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99};

        int array1Sum = addIntArray(array1);
        System.out.println("Array 1 sum is: " + array1Sum);

        int array2Sum = addIntArray(array2);
        System.out.println("Array 2 sum is: " + array2Sum);

        int array3Sum = addIntArray(array3);
        System.out.println("Array 3 sum is: " + array3Sum);

    }

    public static int addIntArray(int[] intArray) {

        int sumTotal = 0;

        for (int i = 0; i < intArray.length; i++) {
            sumTotal += intArray[i];
        }
        return sumTotal;
    }
}
