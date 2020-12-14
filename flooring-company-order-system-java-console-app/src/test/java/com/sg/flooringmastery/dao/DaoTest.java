/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
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

    private Dao dao = new DaoImpl();

    public DaoTest() {
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
        resetOrderCount = dao.getOrderCount();
        Order orderOne = new Order(1);
        orderOne.setCustomerName("Customer One");
        Order orderTwo = new Order(2);
        orderTwo.setCustomerName("Customer Two");
        Order orderThree = new Order(3);
        orderThree.setCustomerName("Customer Three");
        dao.addOrder("test", 1, orderOne);
        dao.addOrder("test", 2, orderTwo);
        dao.addOrder("test", 3, orderThree);
        dao.clearMap();
    }

    @After
    public void tearDown() throws Exception {
        dao.removeOrder("test", 1);
        dao.removeOrder("test", 2);
        dao.removeOrder("test", 3);
        Order orderNine = new Order(resetOrderCount);
        orderNine.setCustomerName("Customer Nine");
        dao.addOrder("test", resetOrderCount, orderNine);
        dao.removeOrder("test", resetOrderCount);
        dao.clearMap();
    }

    /**
     * Test of getMode method, of class Dao.
     */
    @Test
    public void testGetMode() throws Exception {
        boolean trainingMode = dao.getMode();
        assertNotNull(trainingMode);
        assertTrue(trainingMode == true || trainingMode == false);
    }

    /**
     * Test of getOrderCount method, of class Dao.
     */
    @Test
    public void testGetOrderCount() throws Exception {
        assertNotNull(dao.getOrderCount());
        assertEquals(3, dao.getOrderCount());
    }

    /**
     * Test of getTaxes method, of class Dao.
     */
    @Test
    public void testGetTaxes() throws Exception {
        assertNotNull(dao.getTaxes());
        assertFalse(dao.getTaxes().isEmpty());
        assertNotNull(dao.getTaxes().get(0));
    }

    /**
     * Test of getProducts method, of class Dao.
     */
    @Test
    public void testGetProducts() throws Exception {
        assertNotNull(dao.getProducts());
        assertFalse(dao.getProducts().isEmpty());
        assertNotNull(dao.getProducts().get(0));
    }

    /**
     * Test of getAllOrders method, of class Dao.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        assertEquals(dao.getAllOrders("test").size(), 3);
        assertFalse(dao.getAllOrders("test").isEmpty());
        assertNotNull(dao.getAllOrders("test").get(0));
        assertNotNull(dao.getAllOrders("test").get(1));
        assertNotNull(dao.getAllOrders("test").get(2));
    }

    /**
     * Test of clearMap method, of class Dao.
     */
    @Test
    public void testClearMap() throws Exception {
        dao.getAllOrders("test");
        assertNotNull(dao.getOrder("noDate", 1));
        assertNotNull(dao.getOrder("noDate", 2));
        assertNotNull(dao.getOrder("noDate", 3));
        dao.clearMap();
        assertNull(dao.getOrder("noDate", 1));
        assertNull(dao.getOrder("noDate", 2));
        assertNull(dao.getOrder("noDate", 3));
    }

    /**
     * Test of addOrder method, of class Dao.
     */
    @Test
    public void testAddOrder() throws Exception {
        int preAdd = dao.getAllOrders("test").size();
        Order orderFour = new Order(4);
        orderFour.setCustomerName("Customer Four");
        dao.addOrder("test", 4, orderFour);
        dao.clearMap();
        int postAdd = dao.getAllOrders("test").size() - 1;
        assertEquals(preAdd, postAdd);
        dao.clearMap();
        Order retrievedOrder = dao.getAllOrders("test").get(3);
        assertNotNull(retrievedOrder.getCustomerName());
        assertEquals("Customer Four", retrievedOrder.getCustomerName());
        dao.removeOrder("test", 4);
        dao.clearMap();
    }

    /**
     * Test of editOrder method, of class Dao.
     */
    @Test
    public void testEditOrder() throws Exception {
        Order orderFourPreEdit = new Order(4);
        orderFourPreEdit.setCustomerName("Customer Four");
        dao.addOrder("test", 4, orderFourPreEdit);
        dao.clearMap();
        String preEditName = dao.getOrder("test", 4).getCustomerName();
        dao.clearMap();
        Order orderFourEdit = dao.getOrder("test", 4);
        orderFourEdit.setCustomerName("CustomerFour Edited");
        dao.editOrder("test", 4, orderFourEdit);
        dao.clearMap();
        Order orderFourPostEdit = dao.getOrder("test", 4);
        String postEditName = orderFourPostEdit.getCustomerName();
        assertFalse(preEditName.equalsIgnoreCase(postEditName));
        assertFalse(orderFourPreEdit.equals(orderFourPostEdit));
        dao.removeOrder("test", 4);
        dao.clearMap();
    }

    /**
     * Test of getOrder method, of class Dao.
     */
    @Test
    public void testGetOrder() throws Exception {
        assertNotNull(dao.getOrder("test", 1));
        assertNotNull(dao.getOrder("test", 2));
        assertNotNull(dao.getOrder("test", 3));
        assertNull(dao.getOrder("test", 4));
        dao.clearMap();
        assertNull(dao.getOrder("noDate", 1));
    }

    /**
     * Test of removeOrder method, of class Dao.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        int preAdd = dao.getAllOrders("test").size();
        dao.clearMap();
        Order orderFour = new Order(4);
        orderFour.setCustomerName("Customer Four");
        dao.addOrder("test", 4, orderFour);
        dao.clearMap();
        assertNotNull(dao.getOrder("test", 4));
        dao.clearMap();
        int preRemove = dao.getAllOrders("test").size();
        dao.removeOrder("test", 4);
        dao.clearMap();
        assertNull(dao.getOrder("test", 4));
        int postRemove = dao.getAllOrders("test").size();
        assertEquals(preAdd, postRemove);
        assertEquals(preRemove - 1, postRemove);
        assertFalse(preRemove == postRemove);
        assertFalse(preAdd == preRemove);
    }

}
