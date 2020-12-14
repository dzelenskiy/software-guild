/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingInventoryPersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.sl.InsufficientFundsException;
import com.sg.vendingmachine.sl.NoItemInventoryException;
import com.sg.vendingmachine.sl.ServiceLayer;
import com.sg.vendingmachine.ui.View;
import java.util.List;

/**
 *
 * @author DZ
 */
public class Controller {

    View view;
    ServiceLayer sl;

    public Controller(ServiceLayer sl, View view) {
        this.sl = sl;
        this.view = view;
    }

    public void run() {
        boolean proceed = true;

        try {
            sl.loadInventory();
            String cash = null;
            while (proceed) {
                view.welcome();
                List<Item> itemList = sl.getAllItems();
                currentOptions(itemList);
                if (cash != null) {
                    view.dispCurrentCash(cash);
                } else {
                    cash = view.inputCash();
                }
                int selection = view.select(itemList.size());

                if (selection == 0) {
                    proceed = false;
                } else {
                    try {
                        view.vend(sl.vendItem(selection, cash));
                        cash = null;

                    } catch (InsufficientFundsException e) {
                        view.dispInsufficientFundsError(e.getMessage());

                    } catch (NoItemInventoryException e) {
                        view.dispNoItemInventoryError(e.getMessage());
                    }
                }

            }
        } catch (VendingInventoryPersistenceException e) {

            view.dispVendingInventoryPersistenceError(e.getMessage());

        }
    }

    public void currentOptions(List<Item> itemList) {
        for (Item currentItem : itemList) {
            if (currentItem.getQuantity() > 0) {
                view.displayInventory(currentItem.getMenuOption(), currentItem.getItem(), currentItem.getPrice(), currentItem.getQuantity());
            }
        }
    }

}
