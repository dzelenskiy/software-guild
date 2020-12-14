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
public class SumTest {
    
    Sum s = new Sum();
    
    public SumTest() {
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
    
    // Given an array of ints, return the sum of all the elements. 
    //
    // sum({1, 2, 3}) -> 6
    // sum({5, 11, 2}) -> 18
    // sum({7, 0, 0}) -> 7

    
    /**
     * Test of sum method, of class Sum.
     */
    @Test
    public void testArray1() {
        int[] array = {1, 2, 3};
        assertEquals(6, s.sum(array));
    }
    
    @Test
    public void testArray2() {
        int[] array = {5, 11, 2};
        assertEquals(18, s.sum(array));
    }
    
    @Test
    public void testArray3() {
        int[] array = {7, 0, 0};
        assertEquals(7, s.sum(array));
    }
    
    @Test
    public void testArray4() {
        int[] array = {1, 2, 3, 5, 11, 2, 7, 0, 0};
        assertEquals(31, s.sum(array));
    }
}
