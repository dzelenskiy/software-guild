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
public class BalancedDelimeter {
    public static String hold;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.println("Enter a string to check:");
            String sample = sc.nextLine();
            hold = sample;
            eatBabies();
            
            System.out.println(hold);
            
            boolean validity = isBalanced();
            System.out.println(validity);

            System.out.println("Again");
            sample = sc.nextLine();
            if (sample.equalsIgnoreCase("y")) {
                done = false;
            } else {
                done = true;
            }
        }
    }

    private static boolean isBalanced() {
        if (hold.length() % 2 == 1) { //check if odd
            return false;
        }

        while (hold.length() > 0) {
            if (insideBalance()) {
                //do nothing and keep going
            } else {
                return false;
            }
        }
        return true;

    }

    private static boolean insideBalance() {
        StringBuilder sb = new StringBuilder(hold);

        for (int i = 0; i < hold.length() / 2 + 1; i++) {
            if (hold.charAt(i) == ']') {
                if (hold.charAt(i - 1) == '[') {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i - 1);
                    hold = sb.toString();
                    return true;
                }
            }

            if (hold.charAt(i) == '}') {
                if (hold.charAt(i - 1) == '{') {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i - 1);
                    hold = sb.toString();
                    return true;
                }
            }

            if (hold.charAt(i) == ')') {
                if (hold.charAt(i - 1) == '(') {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i - 1);
                    hold = sb.toString();
                    return true;
                }
            }

        }
        return false;
    }

    private static void eatBabies() {
        StringBuilder sb = new StringBuilder(hold);
        for (int i = hold.length() - 1; i > 0; i--) {
            if (hold.charAt(i) == '(' ||
                    hold.charAt(i) == '[' ||
                    hold.charAt(i) == '{' ||
                    hold.charAt(i) == '}' ||
                    hold.charAt(i) == ']' ||
                    hold.charAt(i) == ')') {
                //do nothing
            } else {
                sb.deleteCharAt(i);
            }
        }
        hold = sb.toString();
    }
}
