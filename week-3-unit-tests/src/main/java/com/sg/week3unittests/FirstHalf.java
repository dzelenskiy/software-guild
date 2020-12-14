/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.week3unittests;

/**
 *
 * @author DZ
 */
public class FirstHalf {
    
    // Given a String of even length, return the first half. 
    // So the String "WooHoo" yields "Woo". 
    //
    // firstHalf("WooHoo") -> "Woo"
    // firstHalf("HelloThere") -> "Hello"
    // firstHalf("abcdef") -> "abc"
    
    
    public String firstHalf(String str) {
        StringBuilder sb = new StringBuilder(str);
        if(str.length() % 2 == 0) {
            sb.delete(str.length()/2, str.length());
        }
        return sb.toString();
    }

    
}
