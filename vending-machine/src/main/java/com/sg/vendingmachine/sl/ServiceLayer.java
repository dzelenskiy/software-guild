/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.sl;

import com.sg.vendingmachine.dao.VendingInventoryPersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author DZ
 */
public interface ServiceLayer {

    void loadInventory() throws
            VendingInventoryPersistenceException;

    void saveInventory() throws
            VendingInventoryPersistenceException;

    List<Item> getAllItems() throws
            VendingInventoryPersistenceException;

    Item getItem(int menuOption) throws
            VendingInventoryPersistenceException;

    String vendItem(int menuItem, String cash) throws
            VendingInventoryPersistenceException,
            InsufficientFundsException,
            NoItemInventoryException;

}
