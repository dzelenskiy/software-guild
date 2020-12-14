/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.sl;

import com.sg.vendingmachine.dao.AuditDao;
import com.sg.vendingmachine.dao.AuditDaoImpl;
import com.sg.vendingmachine.dao.Dao;
import com.sg.vendingmachine.dao.DaoImpl;
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
public class ServiceLayerTest {

    private ServiceLayer sl;

    public ServiceLayerTest() {
        Dao dao = new DaoImpl();
        AuditDao auditDao = new AuditDaoImpl();
        sl = new ServiceLayerImpl(dao, auditDao);
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
     * Test of loadInventory method, of class ServiceLayer.
     */
    @Test
    public void testLoadInventory() throws Exception {
        //No test, pass-through Dao method.
    }

    /**
     * Test of saveInventory method, of class ServiceLayer.
     */
    @Test
    public void testSaveInventory() throws Exception {
        //No test, pass-through Dao method.
    }

    /**
     * Test of getAllItems method, of class ServiceLayer.
     */
    @Test
    public void testGetAllItems() throws Exception {
        //No test, pass-through Dao method.
    }

    /**
     * Test of getItem method, of class ServiceLayer.
     */
    @Test
    public void testGetItem() throws Exception {
        //No test, pass-through Dao method.
    }

    /**
     * Test of vendItem method, of class ServiceLayer.
     */
    @Test
    public void testVendItem() throws Exception {
        sl.loadInventory();
        int item1Quantity = sl.getItem(1).getQuantity();
        sl.getItem(1).setQuantity(item1Quantity + 1);
        sl.saveInventory();
        sl.loadInventory();
        int item1BeforeVendQuantity = sl.getItem(1).getQuantity();
        String cash = sl.getItem(1).getPrice();
        sl.vendItem(1, cash);
        sl.saveInventory();
        sl.loadInventory();
        int item1AfterVendQuantity = sl.getItem(1).getQuantity();
        assertTrue(item1BeforeVendQuantity == item1AfterVendQuantity + 1);
    }

}
