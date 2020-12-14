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
public class SkipSumTest {
    
    SkipSum ss = new SkipSum();
    
    public SkipSumTest() {
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

    // Given 2 ints, a and b, return their sum. However, sums 
    // in the range 10..19 inclusive are forbidden, so in that case just return 20. 
    //
    // skipSum(3, 4) â†’ 7
    // skipSum(9, 4) â†’ 20
    // skipSum(10, 11) â†’ 21

    
    /**
     * Test of skipSum method, of class SkipSum.
     */
    @Test
    public void testThreeFour() {
        assertEquals(7, ss.skipSum(3, 4));
    }
    
    @Test
    public void testNineFour() {
        assertEquals(20, ss.skipSum(9, 4));
    }
    
    @Test
    public void testTenEleven() {
        assertEquals(21, ss.skipSum(10, 11));
    }
    
    @Test
    public void testThreeSeven() {
        assertEquals(20, ss.skipSum(3, 7));
    }
    
    @Test
    public void testTenZero() {
        assertEquals(20, ss.skipSum(10, 0));
    }
    
    @Test
    public void testEightOne() {
        assertEquals(9, ss.skipSum(8, 1));
    }
    
    @Test
    public void testTenNine() {
        assertEquals(20, ss.skipSum(10, 9));
    }
    
    @Test
    public void testTenTen() {
        assertEquals(20, ss.skipSum(10, 10));
    }
    
}
