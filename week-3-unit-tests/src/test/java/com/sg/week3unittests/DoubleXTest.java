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
public class DoubleXTest {
    
    DoubleX xx = new DoubleX();
    
    public DoubleXTest() {
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
    
    // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    
    /**
     * Test of doubleX method, of class DoubleX.
     */
    @Test
    public void xxTest1True() {
       assertTrue(xx.doubleX("axxbb")); 
    }
    
    @Test
    public void xxTest2False() {
        assertFalse(xx.doubleX("axaxxax"));
    }
    
    @Test
    public void xxTest3True() {
        assertTrue(xx.doubleX("xxxxx"));
    }
}
