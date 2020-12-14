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
public class InsertWord {
    
    // Given an "out" String length 4, such as "<<>>", and a 
    // word, return a new String where the word is in the middle 
    // of the out String, e.g. "<<word>>".
    //
    // Hint: SubStrings are your friend here 
    //
    // insertWord("<<>>", "Yay") -> "<<Yay>>"
    // insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
    // insertWord("[[]]", "word") -> "[[word]]"
    
    public static String insertWord(String container, String word) {
        
        StringBuilder sb = new StringBuilder(container);
        StringBuilder sb2 = new StringBuilder(container);
        
        int split = sb.length() / 2;
        
        sb.delete(split, sb.length());
        String containerFirstHalf = sb.toString();
        sb2.delete(0, split);
        String containerSecondHalf = sb2.toString();
        
        return containerFirstHalf + word + containerSecondHalf;
        
    }
    
}
