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
public class CommonEndTest {

    CommonEnd ce = new CommonEnd();

    public CommonEndTest() {
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

    // Given 2 arrays of ints, a and b, return true if they 
    // have the same first element or they have the same 
    // last element. Both arrays will be length 1 or more. 
    //
    // commonEnd({1, 2, 3}, {7, 3}) -> true
    // commonEnd({1, 2, 3}, {7, 3, 2}) -> false
    // commonEnd({1, 2, 3}, {1, 3}) -> true
    /**
     * Test of commonEnd method, of class CommonEnd.
     */
    @Test
    public void testArraySet1True() {
        int[] a = {1, 2, 3};
        int[] b = {7, 3};
        assertTrue(ce.commonEnd(a, b));
    }

    @Test
    public void testArraySet2False() {
        int[] a = {1, 2, 3};
        int[] b = {7, 3, 2};
        assertFalse(ce.commonEnd(a, b));
    }

    @Test
    public void testArraySet3True() {
        int[] a = {1, 2, 3};
        int[] b = {1, 3};
        assertTrue(ce.commonEnd(a, b));
    }

    @Test
    public void testArraySet4True() {
        int[] a = {7};
        int[] b = {7};
        assertTrue(ce.commonEnd(a, b));
    }

    @Test
    public void testArraySet5False() {
        int[] a = {9};
        int[] b = {7};
        assertFalse(ce.commonEnd(a, b));
    }

    @Test
    public void testArraySet6False() {
        int[] a = {1, 5, 7, 8, 9, 3};
        int[] b = {7, 10, 15, 25, 28, 19, 29, 33};
        assertFalse(ce.commonEnd(a, b));
    }

    @Test
    public void testArraySet7False() {
        int[] a = {77, 5, 7, 8, 9, 3};
        int[] b = {7, 10, 15, 25, 28, 19, 29, 33};
        assertFalse(ce.commonEnd(a, b));
    }

}
