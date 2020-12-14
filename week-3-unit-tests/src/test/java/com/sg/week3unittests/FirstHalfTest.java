/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.week3unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DZ
 */
public class FirstHalfTest {
    
    FirstHalf fh = new FirstHalf();
    
    public FirstHalfTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    // Given a String of even length, return the first half. 
    // So the String "WooHoo" yields "Woo". 
    //
    // firstHalf("WooHoo") -> "Woo"
    // firstHalf("HelloThere") -> "Hello"
    // firstHalf("abcdef") -> "abc"

    /**
     * Test of firstHalf method, of class FirstHalf.
     */
    @Test
    public void testWooHoo() {
        assertEquals("Woo", fh.firstHalf("WooHoo"));
    }
    
    @Test
    public void testHelloThere() {
        assertEquals("Hello", fh.firstHalf("HelloThere"));
    }
    
    @Test
    public void testAbcdef() {
        assertEquals("abc", fh.firstHalf("abcdef"));
    }
    
    @Test
    public void testUnevenSentences() {
        assertEquals("UnevenSentences", fh.firstHalf("UnevenSentences"));
    }
    
}
