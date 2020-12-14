/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.OrderCount;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class DaoImpl implements Dao {

    private Map<Integer, Order> orders = new HashMap<>();

    private Map<String, Product> products = new HashMap<>();

    private Map<String, Tax> taxes = new HashMap<>();

    public static final String PRODUCTS_FILE = "Products.txt";

    public static final String TAXES_FILE = "Taxes.txt";

    public static final String CONFIG_FILE = "config.txt";

    public static final String ORDER_COUNT_FILE = "orderCount.txt";

    public static final String DELIMETER = ",";

    private void loadOrders(String date) throws DataFileError {
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader("./Orders/Orders_" + date + ".txt")));
        } catch (FileNotFoundException fnfe) {
            throw new DataFileError("Could not load data from orders.txt!");
        }
        String line;
        String[] field;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            field = line.split(DELIMETER);
            Order order = new Order(Integer.parseInt(field[0]));
            order.setCustomerName(field[1]);
            order.setState(field[2]);
            order.setTaxRate(field[3]);
            order.setProduct(field[4]);
            order.setArea(field[5]);
            order.setMaterialCostPerSqFoot(field[6]);
            order.setLaborCostPerSqFoot(field[7]);
            order.setMaterialCost(field[8]);
            order.setLaborCost(field[9]);
            order.setTax(field[10]);
            order.setTotal(field[11]);
            orders.put(order.getOrderNumber(), order);
        }
        sc.close();
    }

    private void loadProducts() throws DataFileError {
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(PRODUCTS_FILE)));
        } catch (FileNotFoundException fnfe) {
            throw new DataFileError("Could not load data from products.txt!");
        }
        String line;
        String[] field;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            field = line.split(DELIMETER);
            Product product = new Product(field[0]);
            product.setMaterialCostPerSqFoot(field[1]);
            product.setLaborCostPerSqFoot(field[2]);
            products.put(product.getProductName(), product);
        }
        sc.close();
    }

    private void loadTaxes() throws DataFileError {
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(TAXES_FILE)));
        } catch (FileNotFoundException fnfe) {
            throw new DataFileError("Could not load data from Taxes.txt!");
        }
        String line;
        String[] field;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            field = line.split(DELIMETER);
            Tax tax = new Tax(field[0]);
            tax.setTaxRate(field[1]);
            taxes.put(tax.getStateName(), tax);
        }
        sc.close();
    }

    private int loadOrderCount() throws DataFileError {
        int orderCount = 0;
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(ORDER_COUNT_FILE)));
        } catch (FileNotFoundException fnfe) {
            throw new DataFileError("Could not load data from orderCount.txt!");
        }
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            orderCount = Integer.parseInt(line);
        }
        sc.close();
        return orderCount;
    }

    private boolean loadConfig() throws DataFileError {
        boolean trainingMode = true;
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(CONFIG_FILE)));
        } catch (FileNotFoundException fnfe) {
            throw new DataFileError("Could not load data from config.txt!");
        }
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            trainingMode = Boolean.parseBoolean(line.trim().toLowerCase());
        }
        sc.close();
        return trainingMode;
    }

    private void saveOrders(String date) throws DataFileError {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter("./Orders/Orders_" + date + ".txt"));
        } catch (IOException ioe) {
            throw new DataFileError("Could not save data to Orders_" + date + ".txt!");
        }
        List<Order> orders = this.getAllOrders(date);
        for (Order currentOrder : orders) {
            pw.println(currentOrder.getOrderNumber() + DELIMETER + currentOrder.getCustomerName() + DELIMETER
                    + currentOrder.getState() + DELIMETER + currentOrder.getTaxRate() + DELIMETER
                    + currentOrder.getProduct() + DELIMETER + currentOrder.getArea() + DELIMETER
                    + currentOrder.getMaterialCostPerSqFoot() + DELIMETER + currentOrder.getLaborCostPerSqFoot() + DELIMETER
                    + currentOrder.getMaterialCost() + DELIMETER + currentOrder.getLaborCost() + DELIMETER
                    + currentOrder.getTax() + DELIMETER + currentOrder.getTotal());
            pw.flush();
        }
        pw.close();
    }

    private void saveOrderCount(int orderNumber) throws DataFileError {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter(ORDER_COUNT_FILE));
        } catch (IOException ioe) {
            throw new DataFileError("Could not save data to orderCount.txt!");
        }
        pw.println(orderNumber);
        pw.flush();
        pw.close();
    }

    @Override
    public boolean getMode() throws DataFileError {
        boolean trainingMode = loadConfig();
        return trainingMode;
    }

    @Override
    public int getOrderCount() throws DataFileError {
        int orderCount = loadOrderCount();
        return orderCount;
    }

    @Override
    public List<Tax> getTaxes() throws DataFileError {
        loadTaxes();
        return new ArrayList<Tax>(taxes.values());
    }

    @Override
    public List<Product> getProducts() throws DataFileError {
        loadProducts();
        return new ArrayList<Product>(products.values());
    }

    @Override
    public List<Order> getAllOrders(String date) throws DataFileError {
        try {
            loadOrders(date);
        } catch (DataFileError dfe) {
            //Tries to load file but file does not exist yet for the day. Do nothing.
        }
        return new ArrayList<Order>(orders.values());
    }

    @Override
    public void clearMap() {
        if (orders.isEmpty()) {
            //Do nothing.
        } else {
            orders.clear();
        }
    }

    @Override
    public Order addOrder(String date, int orderNumber, Order order) throws DataFileError {
        Order newOrder = orders.put(orderNumber, order);
        try {
            loadOrders(date);
        } catch (DataFileError dfe) {
            //Tries to load file but file does not exist yet for the day. Do nothing.
        }
        saveOrderCount(orderNumber);
        saveOrders(date);
        return newOrder;
    }

    @Override
    public Order editOrder(String date, int orderNumber, Order order) throws DataFileError {
        try {
            loadOrders(date);
        } catch (DataFileError dfe) {
            //Tries to load file but file does not exist yet for the day. Do nothing.
        }
        orders.remove(orderNumber);
        Order newOrder = orders.put(orderNumber, order);
        saveOrders(date);
        return newOrder;
    }

    @Override
    public Order getOrder(String date, int orderNumber) throws DataFileError {
        try {
            loadOrders(date);
        } catch (DataFileError dfe) {
            //Tries to load file but file does not exist yet for the day. Do nothing.
        }
        return orders.get(orderNumber);
    }

    @Override
    public Order removeOrder(String date, int orderNumber) throws DataFileError {
        try {
            loadOrders(date);
        } catch (DataFileError dfe) {
            //Tries to load file but file does not exist yet for the day. Do nothing.
        }
        Order removedOrder = orders.remove(orderNumber);
        saveOrders(date);
        return removedOrder;
    }

}
