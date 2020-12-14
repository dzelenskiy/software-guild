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
public class PosNegTest {
    PosNeg pn = new PosNeg();
    
    public PosNegTest() {
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
    
    // Given two int values, return true if one is negative and 
    // one is positive. Except if the parameter "negative" is 
    // true, then return true only if both are negative. 
    //
    // posNeg(1, -1, false) -> true
    // posNeg(-1, 1, false) -> true
    // posNeg(-4, -5, true) -> true

    /**
     * Test of posNeg method, of class PosNeg.
     */
    @Test
    public void test1AndNeg1False() {
        assertTrue(pn.posNeg(1, -1, false));
    }
    
    @Test
    public void testNeg1And1False() {
        assertTrue(pn.posNeg(-1, 1, false));
    }
    
    @Test
    public void testNeg4AndNeg5True() {
        assertTrue(pn.posNeg(-4, -5, true));
    }
    
    @Test
    public void testNeg8AndNeg7False() {
        assertTrue(pn.posNeg(-8, -7, false));
    }
    
    @Test
    public void test0And0False() {
        assertFalse(pn.posNeg(0, 0, false));
    }
    
    @Test
    public void test0And0True() {
        assertFalse(pn.posNeg(0, 0, true));
    }
    
    @Test
    public void test0And5True() {
        assertFalse(pn.posNeg(0, 0, true));
    }
    
    @Test
    public void test4And0False() {
        assertFalse(pn.posNeg(0, 0, false));
    }
    
}
