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
public class CommonEnd {
    
// Given 2 arrays of ints, a and b, return true if they 
    // have the same first element or they have the same 
    // last element. Both arrays will be length 1 or more. 
    //
    // commonEnd({1, 2, 3}, {7, 3}) -> true
    // commonEnd({1, 2, 3}, {7, 3, 2}) -> false
    // commonEnd({1, 2, 3}, {1, 3}) -> true
    
    public boolean commonEnd(int[] a, int[] b) {
        if(a[0] == b[0]) {
            return true;
        } else if (a[a.length - 1] == b[b.length - 1]) {
            return true;
        } else {
            return false;
        }
    }            
}
