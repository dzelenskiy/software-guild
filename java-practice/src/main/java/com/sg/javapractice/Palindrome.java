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
public class Palindrome {

    public static void main(String[] args) {
        String word = "rotor";
        System.out.println(isPalindrome(word));
    }

    public static boolean isPalindrome(String word) {
        boolean palindrome = false;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - (i + 1))) {
                palindrome = false;
                break;
            } else {
                palindrome = true;
            }
        }
        return palindrome;
    }

}
