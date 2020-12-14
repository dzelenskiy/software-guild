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
public class LongInMiddleTest {
    
    LongInMiddle lim = new LongInMiddle();
    
    public LongInMiddleTest() {
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
    
    // Given 2 Strings, a and b, return a String of the form 
    // short+long+short, with the shorter String on the outside 
    // and the longer String on the inside. The Strings will not 
    // be the same length, but they may be empty (length 0). 
    //
    // longInMiddle("Hello", "hi") -> "hiHellohi"
    // longInMiddle("hi", "Hello") -> "hiHellohi"
    // longInMiddle("aaa", "b") -> "baaab"

    /**
     * Test of longInMiddle method, of class LongInMiddle.
     */
    @Test
    public void testHelloHi() {
        assertEquals(lim.longInMiddle("Hello", "hi"), "hiHellohi");
    }
    
    @Test
    public void testHiHello() {
        assertEquals(lim.longInMiddle("hi", "Hello"), "hiHellohi");
    }
    
    @Test
    public void testAaaB() {
        assertEquals(lim.longInMiddle("aaa", "b"), "baaab");
    }
    
}
