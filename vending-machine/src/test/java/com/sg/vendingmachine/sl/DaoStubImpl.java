/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.sl;

import com.sg.vendingmachine.dao.Dao;
import com.sg.vendingmachine.dao.VendingInventoryPersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DZ
 */
public class DaoStubImpl implements Dao {
//Set up for potential future use. Currently ServiceLayerTest uses the regular DaoImpl for testing and resets quantity back to original state.

    Item onlyItem;
    List<Item> itemList = new ArrayList<>();

    public DaoStubImpl() {
        onlyItem = new Item(1);
        onlyItem.setItem("Soda");
        onlyItem.setPrice("2.00");
        onlyItem.setQuantity(10);

        itemList.add(onlyItem);
    }

    @Override
    public List<Item> getAllItems() throws VendingInventoryPersistenceException {
        return itemList;
    }

    @Override
    public Item getItem(int menuOption) throws VendingInventoryPersistenceException {
        if (menuOption == onlyItem.getMenuOption()) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public void loadInventory() throws VendingInventoryPersistenceException {
        //This is a StubImpl of Dao. This function is not used.
    }

    @Override
    public void saveInventory() throws VendingInventoryPersistenceException {
        //This is a StubImpl of Dao. This function is not used.
    }

}
