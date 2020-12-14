/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.dto.Item;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DZ
 */
//@Repository
public class VendingDaoImpl implements VendingDao {

    private Map<Integer, Item> items = new HashMap<>();

    public File f = new File(getClass().getClassLoader().getResource("inventory.txt").getFile());

    public static final String DELIMETER = "::";

    @Override
    public void loadInventory() throws VendingInventoryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new VendingInventoryPersistenceException("!!Could not load inventory data into memory!!", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMETER);
            Item currentItem = new Item(Integer.parseInt(currentTokens[0]));
            currentItem.setName(currentTokens[1]);
            currentItem.setPrice(currentTokens[2]);
            currentItem.setQuantity(Integer.parseInt(currentTokens[3]));
            items.put(currentItem.getId(), currentItem);
        }
        scanner.close();
    }

    @Override
    public void saveInventory() throws VendingInventoryPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(f));
        } catch (IOException e) {
            throw new VendingInventoryPersistenceException("!!Could not save inventory data!!", e);
        }
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            out.println(currentItem.getId() + DELIMETER + currentItem.getName()
                    + DELIMETER + currentItem.getPrice() + DELIMETER + currentItem.getQuantity());
            out.flush();
        }
        out.close();
    }

    @Override
    public List<Item> getAllItems() throws VendingInventoryPersistenceException {
        loadInventory();
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItem(int id) throws VendingInventoryPersistenceException {
        loadInventory();
        return items.get(id);
    }

}
