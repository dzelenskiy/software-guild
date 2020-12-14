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
public class CaughtSpeedingTest {
    
    CaughtSpeeding cs = new CaughtSpeeding();
    
    public CaughtSpeedingTest() {
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
    
    // You are driving a little too fast, and a police 
    // officer stops you. Write code to compute the 
    // result, encoded as an int value: 0=no ticket, 
    // 1=small ticket, 2=big ticket. If speed is 60 or 
    // less, the result is 0. If speed is between 61 
    // and 80 inclusive, the result is 1. If speed is 
    // 81 or more, the result is 2. Unless it is your 
    // birthday -- on that day, your speed can be 5 
    // higher in all cases. 
    //
    // caughtSpeeding(60, false) â†’ 0
    // caughtSpeeding(65, false) â†’ 1
    //caughtSpeeding(65, true) â†’ 0
    

    /**
     * Test of caughtSpeeding method, of class CaughtSpeeding.
     */
    @Test
    public void testSpeeding60False() {
        assertEquals(0, cs.caughtSpeeding(60, false));
    }
    
    @Test
    public void testSpeeding60True() {
        assertEquals(0, cs.caughtSpeeding(60, true));
    }
    
     @Test
    public void testSpeeding61True() {
        assertEquals(0, cs.caughtSpeeding(61, true));
    }
    
     @Test
    public void testSpeeding61False() {
        assertEquals(1, cs.caughtSpeeding(61, false));
    }
    
     @Test
    public void testSpeeding64True() {
        assertEquals(0, cs.caughtSpeeding(64, true));
    }
    
     @Test
    public void testSpeeding64False() {
        assertEquals(1, cs.caughtSpeeding(64, false));
    }
    
     @Test
    public void testSpeeding65False() {
        assertEquals(1, cs.caughtSpeeding(65, false));
    }
    
     @Test
    public void testSpeeding65True() {
        assertEquals(0, cs.caughtSpeeding(65, true));
    }
    
    @Test
    public void testSpeeding66True() {
        assertEquals(1, cs.caughtSpeeding(66, true));
    }
    
     @Test
    public void testSpeeding66False() {
        assertEquals(1, cs.caughtSpeeding(66, false));
    }
    
     @Test
    public void testSpeeding80False() {
        assertEquals(1, cs.caughtSpeeding(80, false));
    }
    
    @Test
    public void testSpeeding81False() {
        assertEquals(2, cs.caughtSpeeding(81, false));
    }
    
    @Test
    public void testSpeeding81True() {
        assertEquals(1, cs.caughtSpeeding(81, true));
    }
    
    @Test
    public void testSpeeding86True() {
        assertEquals(2, cs.caughtSpeeding(86, true));
    }
    
    @Test
    public void testSpeeding86False() {
        assertEquals(2, cs.caughtSpeeding(86, false));
    }
    
    @Test
    public void testSpeeding85True() {
        assertEquals(1, cs.caughtSpeeding(85, true));
    }
    
    @Test
    public void testSpeeding85False() {
        assertEquals(2, cs.caughtSpeeding(85, false));
    }
    
    
}
