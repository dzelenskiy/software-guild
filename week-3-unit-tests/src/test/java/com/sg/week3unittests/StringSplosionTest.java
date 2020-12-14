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
public class StringSplosionTest {
    
    StringSplosion ss = new StringSplosion();
    
    public StringSplosionTest() {
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
    
    // Given a non-empty String like "Code" return a String like 
    // â€œCCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"

    /**
     * Test of stringSplosion method, of class SpringSplosion.
     */
    
    @Test
    public void testCode() {
        assertEquals(ss.stringSplosion("Code"), "CCoCodCode");
    }
    
    @Test
    public void testAbc() {
        assertEquals(ss.stringSplosion("abc"), "aababc");
    }
    
    @Test
    public void testAb() {
        assertEquals(ss.stringSplosion("ab"), "aab");
    }
    
}
