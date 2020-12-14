/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingDao;
import com.sg.vendingmachinespringmvc.dao.VendingInventoryPersistenceException;
import com.sg.vendingmachinespringmvc.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author DZ
 */
@Service
public class VendingServiceImpl implements VendingService {

    @Inject
    VendingDao dao;

    @Override
    public void loadInventory() throws VendingInventoryPersistenceException {
        dao.loadInventory();
    }

    @Override
    public void saveInventory() throws VendingInventoryPersistenceException {
        dao.saveInventory();
    }

    @Override
    public List<Item> getAllItems() throws VendingInventoryPersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(int id) throws VendingInventoryPersistenceException {
        return dao.getItem(id);
    }

    @Override
    public String vendItem(int id, String cash) throws VendingInventoryPersistenceException, InsufficientFundsException,
            NoItemInventoryException {

        Item vendChoice = dao.getItem(id);
        BigDecimal userCash = new BigDecimal(cash);
        BigDecimal price = new BigDecimal(vendChoice.getPrice());
        if (vendChoice.getQuantity() == 0) {
            throw new NoItemInventoryException(
                    "SOLD OUT!!!");
        } else if (price.doubleValue() > userCash.doubleValue()) {
            BigDecimal amountShortBD = price.subtract(userCash);
            String amountShort = amountShortBD.setScale(2, RoundingMode.HALF_UP).toString();
            throw new InsufficientFundsException(
                    "Please insert $" + amountShort);
        } else {
            BigDecimal change = userCash.subtract(price);
            int currentQuantity = vendChoice.getQuantity();
            vendChoice.setQuantity(currentQuantity - 1);
            dao.saveInventory();
            return getChange(change);

        }

    }

    @Override
    public String getChange(BigDecimal change) {

        int remainingAmount = (int) (change.multiply(BigDecimal.valueOf(100)).intValue());

        int quarters = remainingAmount / Currency.QUARTERS.getValue();
        remainingAmount = remainingAmount % Currency.QUARTERS.getValue();

        int dimes = remainingAmount / Currency.DIMES.getValue();
        remainingAmount = remainingAmount % Currency.DIMES.getValue();

        int nickels = remainingAmount / Currency.NICKELS.getValue();
        remainingAmount = remainingAmount % Currency.NICKELS.getValue();

        int pennies = remainingAmount;

        return quarters + " quarters, " + dimes + " dimes, " + nickels
                + " nickels, " + pennies + " pennies.";

    }

}
