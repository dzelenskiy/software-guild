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
public class InsertWordTest {
    
    InsertWord iw = new InsertWord();
    
    public InsertWordTest() {
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

    // Given an "out" String length 4, such as "<<>>", and a 
    // word, return a new String where the word is in the middle 
    // of the out String, e.g. "<<word>>".
    //
    // Hint: SubStrings are your friend here 
    //
    // insertWord("<<>>", "Yay") -> "<<Yay>>"
    // insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
    // insertWord("[[]]", "word") -> "[[word]]"
    
    
    @Test
    public void test1() {
        String yay1 = "<<Yay>>";
        String yay2 = iw.insertWord("<<>>", "Yay");
        assertEquals(yay1, yay2);
    }
    
     @Test
    public void test2() {
        String yay1 = "<<{[Yay]}>>";
        String yay2 = iw.insertWord("<<{[]}>>", "Yay");
        assertEquals(yay1, yay2);
    }
    
    @Test
    public void test3() {
        String wooHoo1 = "<<WooHoo>>";
        String wooHoo2 = iw.insertWord("<<>>", "WooHoo");
        assertEquals(wooHoo1, wooHoo2);
    }
    
    @Test
    public void test4() {
        String word1 = "[[word]]";
        String word2 = iw.insertWord("[[]]", "word");
        assertEquals(word1, word2);
    }
    
}
