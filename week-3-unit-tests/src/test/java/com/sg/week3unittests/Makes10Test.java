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
public class Makes10Test {
    
    Makes10 m10 = new Makes10();
    
    public Makes10Test() {
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
    
    
    // Given two ints, a and b, return true if one if them is 10 
    // or if their sum is 10. 
    //
    // makes10(9, 10) -> true
    // makes10(9, 9) -> false
    // makes10(1, 9) -> true
    

    /**
     * Test of makes10 method, of class Makes10.
     */
    @Test
    public void test9and10() {
        assertTrue(m10.makes10(9, 10));
    }
    
    @Test
    public void test9and9() {
        assertFalse(m10.makes10(9, 9));
    }
    
    @Test
    public void test1and9() {
        assertTrue(m10.makes10(1, 9));
    }
    
    
    
}
