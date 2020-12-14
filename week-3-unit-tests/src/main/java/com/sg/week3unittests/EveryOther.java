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
public class EveryOther {
    
    // Given a String, return a new String made of every other 
    // char starting with the first, so "Hello" yields "Hlo". 
    //
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"
    
    public String everyOther(String str) {

        StringBuilder sb = new StringBuilder(str);
        
        for(int i = str.length() - 1; i > 0; i --) {
            if(i % 2 == 1) {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }

}
