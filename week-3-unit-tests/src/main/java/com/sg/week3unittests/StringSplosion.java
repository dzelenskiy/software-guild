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
public class StringSplosion {
    
    // Given a non-empty String like "Code" return a String like 
    // â€œCCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    
    
    public String stringSplosion(String str) {
        
        String newStr = "";
        
        for(int i = 0; i < str.length(); i ++) {
            newStr += str.substring(0, i + 1);
        }
         return newStr;
    }
    
}
