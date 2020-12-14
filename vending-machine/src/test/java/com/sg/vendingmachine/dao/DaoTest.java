/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.util.List;
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
public class DaoTest {
    
    Dao dao = new DaoImpl();
    
    public DaoTest() {
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

    /**
     * Test of loadInventory method, of class Dao.
     */
    @Test
    public void testLoadInventory() throws Exception {
        dao.loadInventory();
        assertNotNull(dao.getAllItems().size());
        assertFalse(dao.getAllItems().size() == 0);
        assertNotNull(dao.getItem(1));
    }

    /**
     * Test of saveInventory method, of class Dao.
     */
    @Test
    public void testSaveInventory() throws Exception {
        dao.loadInventory();
        int firstQuantity = dao.getItem(1).getQuantity();
        dao.getItem(1).setQuantity(firstQuantity + 1);
        dao.saveInventory();
        dao.loadInventory();
        int secondQuantity = dao.getItem(1).getQuantity();
        assertFalse(firstQuantity == secondQuantity);
        assertTrue(firstQuantity + 1 == secondQuantity);
        dao.getItem(1).setQuantity(firstQuantity);
        dao.saveInventory();
        dao.loadInventory();
        int thirdQuantity = dao.getItem(1).getQuantity();
        assertTrue(firstQuantity == thirdQuantity);
    }

    /**
     * Test of getAllItems method, of class Dao.
     */
    @Test
    public void testGetAllItems() throws Exception {
        dao.loadInventory();
        int listSize = dao.getAllItems().size();
        List list = dao.getAllItems();
        int lastItem = dao.getAllItems().lastIndexOf(list);
        assertNotNull(list);
    }

    /**
     * Test of getItem method, of class Dao.
     */
    @Test
    public void testGetItem() throws Exception {
        dao.loadInventory();
        assertNotNull(dao.getItem(1));
    }
    
}
