/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.sl;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author DZ
 */
public class ServiceLayerTest {

    private ServiceLayer sl;

    public ServiceLayerTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        sl = ctx.getBean("sl", ServiceLayer.class);
    }

    int resetOrderCount;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        resetOrderCount = sl.getOrderCount();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of todaysDate method, of class ServiceLayer.
     */
    @Test
    public void testTodaysDate() {
        LocalDate ld = LocalDate.now();
        String todaysDate = ld.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        String slDate = sl.todaysDate();
        assertEquals(todaysDate, slDate);
    }

    /**
     * Test of calcMaterialCost method, of class ServiceLayer.
     */
    @Test
    public void testCalcMaterialCost() {
        String slCalc = sl.calcMaterialCost("10", "10");
        assertEquals(slCalc, "100.00");
        String slCalc2 = sl.calcMaterialCost("20", "20");
        assertEquals(slCalc2, "400.00");
        assertFalse(slCalc.equalsIgnoreCase("100.000"));
        assertFalse(slCalc.equalsIgnoreCase("400.00"));
    }

    /**
     * Test of calcLaborCost method, of class ServiceLayer.
     */
    @Test
    public void testCalcLaborCost() {
        String slCalc = sl.calcLaborCost("10", "10");
        assertEquals(slCalc, "100.00");
        String slCalc2 = sl.calcLaborCost("20", "20");
        assertEquals(slCalc2, "400.00");
        assertFalse(slCalc.equalsIgnoreCase("100.000"));
        assertFalse(slCalc.equalsIgnoreCase("400.00"));
    }

    /**
     * Test of calcTax method, of class ServiceLayer.
     */
    @Test
    public void testCalcTax() {
        String slCalc = sl.calcTax("10", "10", "10");
        assertEquals(slCalc, "2.00");
        String slCalc2 = sl.calcTax("20", "20", "20");
        assertEquals(slCalc2, "8.00");
        assertFalse(slCalc.equalsIgnoreCase("2"));
        assertFalse(slCalc2.equalsIgnoreCase("8.0"));
    }

    /**
     * Test of calcTotal method, of class ServiceLayer.
     */
    @Test
    public void testCalcTotal() {
        String slCalc = sl.calcTotal("10", "10", "10");
        assertEquals(slCalc, "22.00");
        String slCalc2 = sl.calcTotal("20", "20", "20");
        assertEquals(slCalc2, "48.00");
        assertFalse(slCalc.equalsIgnoreCase("22"));
        assertFalse(slCalc.equalsIgnoreCase("48.0"));
    }

    /**
     * Test of getOrderCount method, of class ServiceLayer.
     */
    @Test
    public void testGetOrderCount() throws Exception {
        //Pass through from dao, no test required.
    }

    /**
     * Test of getTaxes method, of class ServiceLayer.
     */
    @Test
    public void testGetTaxes() throws Exception {
        //Pass through from dao, no test required.
    }

    /**
     * Test of getProducts method, of class ServiceLayer.
     */
    @Test
    public void testGetProducts() throws Exception {
        //Pass through from dao, no test required.
    }

    /**
     * Test of getAllOrders method, of class ServiceLayer.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        //Pass through from dao, no test required.
    }

    /**
     * Test of clearMap method, of class ServiceLayer.
     */
    @Test
    public void testClearMap() {
        //Pass through from dao, no test required.
    }

    /**
     * Test of addOrder method, of class ServiceLayer.
     */
    @Test
    public void testAddOrder() throws Exception {
        assertTrue(sl.getAllOrders("test").isEmpty());
        Order order = new Order(resetOrderCount);
        boolean trainingMode = sl.addOrder("test", resetOrderCount, order);
        sl.clearMap();
        if (trainingMode) {
            assertTrue(sl.getAllOrders("test").isEmpty());
        } else {
            assertFalse(sl.getAllOrders("test").isEmpty());
            assertTrue(sl.getAllOrders("test").size() == 1);
            sl.removeOrder("test", resetOrderCount);
        }
    }

    /**
     * Test of editOrder method, of class ServiceLayer.
     */
    @Test
    public void testEditOrder() throws Exception {
        assertTrue(sl.getAllOrders("test").isEmpty());
        Order order = new Order(resetOrderCount);
        boolean trainingMode = sl.addOrder("test", resetOrderCount, order);
        sl.clearMap();
        if (trainingMode) {
            assertTrue(sl.getAllOrders("test").isEmpty());
        } else {
            order.setCustomerName("Edited Name");
            trainingMode = sl.editOrder("test", resetOrderCount, order);
            sl.clearMap();
            if (trainingMode) {
                assertFalse("Edited Name".equalsIgnoreCase(order.getCustomerName()));
            } else {
                assertTrue("Edited Name".equalsIgnoreCase(order.getCustomerName()));
                sl.removeOrder("test", resetOrderCount);
            }
        }
    }

    /**
     * Test of getOrder method, of class ServiceLayer.
     */
    @Test
    public void testGetOrder() throws Exception {
        //Pass through from dao, no test required.
    }

    /**
     * Test of removeOrder method, of class ServiceLayer.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        //Pass through from dao, no test required.
    }

}
