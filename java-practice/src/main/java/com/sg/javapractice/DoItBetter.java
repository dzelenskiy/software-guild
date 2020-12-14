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
public class DoItBetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hey there. How many miles can you run?");
        int miles = sc.nextInt();
        System.out.println("That's it? I can run " + (miles * 2 + 1) + " miles!");
        System.out.println("How many hotdogs can you eat in one sitting?");
        int hotdogs = sc.nextInt();
        System.out.println("That's it? I can eat " + (hotdogs * 2 + 1) + " hotdogs!");
        System.out.println("How many languages do you know?");
        int lang = sc.nextInt();
        System.out.println("That's it? I know " + (lang * 2 + 1) + " languages!");

    }
}
