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
public class AlarmClockTest {
    
    AlarmClock ac = new AlarmClock();
    
    public AlarmClockTest() {
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
    
    // Given a day of the week encoded as 
    // 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating 
    // if we are on vacation, return a String of the form "7:00" 
    // indicating when the alarm clock should ring. Weekdays, the 
    // alarm should be "7:00" and on the weekend it should be "10:00". 
    // Unless we are on vacation -- then on weekdays it should be 
    // â€œ10:00" and weekends it should be "off". 
    //
    // alarmClock(1, false) â†’ "7:00"
    // alarmClock(5, false) â†’ "7:00"
    // alarmClock(0, false) â†’ "10:00"
    

    /**
     * Test of alarmClock method, of class AlarmClock.
     */
    @Test
    public void test1False() {
        assertEquals("7:00", ac.alarmClock(1, false));
    }
    
    @Test
    public void test5False() {
        assertEquals("7:00", ac.alarmClock(5, false));
    }
    
    @Test
    public void test0False() {
        assertEquals("10:00", ac.alarmClock(0, false));
    }
    
        @Test
    public void test0True() {
        assertEquals("off", ac.alarmClock(0, true));
    }
    
    @Test
    public void test6True() {
        assertEquals("off", ac.alarmClock(6, true));
    }
    
    @Test
    public void test6False() {
        assertEquals("10:00", ac.alarmClock(6, false));
    }
    
    @Test
    public void test4True() {
        assertEquals("10:00", ac.alarmClock(4, true));
    }
    
    @Test
    public void test1True() {
        assertEquals("10:00", ac.alarmClock(1, true));
    }
    
}
