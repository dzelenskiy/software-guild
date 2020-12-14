/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.util.List;

/**
 *
 * @author DZ
 */
public interface Dao {
    
    boolean getMode() throws DataFileError;
    
    int getOrderCount() throws DataFileError;
    
    List<Tax> getTaxes() throws DataFileError;
    
    List<Product> getProducts() throws DataFileError;
    
    List<Order> getAllOrders(String date)throws DataFileError;
    
    void clearMap();
    
    Order addOrder(String date, int orderNumber, Order order)throws DataFileError;
    
    Order editOrder(String date, int orderNumber, Order order) throws DataFileError;
    
    Order getOrder(String date, int orderNumber)throws DataFileError;
    
    Order removeOrder(String date, int orderNumber)throws DataFileError;
    
}
