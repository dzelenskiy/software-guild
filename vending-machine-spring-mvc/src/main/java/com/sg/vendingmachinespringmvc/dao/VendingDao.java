/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.dto.Item;
import java.util.List;

/**
 *
 * @author DZ
 */
public interface VendingDao {

    void loadInventory() throws
            VendingInventoryPersistenceException;

    void saveInventory() throws
            VendingInventoryPersistenceException;

    List<Item> getAllItems()
            throws VendingInventoryPersistenceException;

    Item getItem(int menuOption)
            throws VendingInventoryPersistenceException;

}
