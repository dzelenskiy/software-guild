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
public class DoubleX {
    
    // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    
    public boolean doubleX(String str) {
        
        boolean dbl = false;
        char[] strChar;
        strChar = str.toCharArray();
        for(int i = 0; i < strChar.length - 2; i++) {
            char x = 'x';
            if (strChar[i] == x) {
               if (strChar[i + 1] == x) {
                   dbl = true;
               } else {
                   break;
               }
            } 
        }
        return dbl;
    }
    
}
