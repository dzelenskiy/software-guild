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
public class EveryOtherTest {
    
    EveryOther eo = new EveryOther();
    
    public EveryOtherTest() {
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
    
    // Given a String, return a new String made of every other 
    // char starting with the first, so "Hello" yields "Hlo". 
    //
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"

    @Test
    public void testHello() {
        assertEquals("Hlo", eo.everyOther("Hello"));
    }
    
    @Test
    public void testHi() {
        assertEquals("H", eo.everyOther("Hi"));
    }
    
    @Test
    public void testHeeololeo() {
        assertEquals("Hello", eo.everyOther("Heeololeo"));
    }
}
