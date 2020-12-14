/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingInventoryPersistenceException;
import com.sg.vendingmachinespringmvc.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author DZ
 */
public interface VendingService {

    void loadInventory() throws
            VendingInventoryPersistenceException;

    void saveInventory() throws
            VendingInventoryPersistenceException;

    List<Item> getAllItems() throws
            VendingInventoryPersistenceException;

    Item getItem(int id) throws
            VendingInventoryPersistenceException;

    String vendItem(int id, String cash) throws
            VendingInventoryPersistenceException,
            InsufficientFundsException,
            NoItemInventoryException;

    String getChange(BigDecimal change);

}
