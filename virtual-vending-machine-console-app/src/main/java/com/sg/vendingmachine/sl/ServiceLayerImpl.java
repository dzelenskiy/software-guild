/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.sl;

import com.sg.vendingmachine.dao.AuditDao;
import com.sg.vendingmachine.dao.Dao;
import com.sg.vendingmachine.dao.VendingInventoryPersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;



/**
 *
 * @author DZ
 */
public class ServiceLayerImpl implements ServiceLayer {
    
    Dao dao;
    AuditDao auditDao;
    
    public ServiceLayerImpl(Dao dao, AuditDao auditDao) {
        this.dao = dao;
        this.auditDao =  auditDao;
    }
    
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
    public Item getItem(int menuOption) throws VendingInventoryPersistenceException {
        return dao.getItem(menuOption);
    }

    @Override
    public String vendItem(int menuItem, String cash) throws VendingInventoryPersistenceException, InsufficientFundsException,
            NoItemInventoryException {
        
        Item vendChoice = dao.getItem(menuItem);
        BigDecimal userCash = new BigDecimal(cash);
        BigDecimal price = new BigDecimal(vendChoice.getPrice());
        if(price.doubleValue() > userCash.doubleValue()) {
            throw new InsufficientFundsException (
                    "Price of this item exceeds the cash you put in.");
        } else if(vendChoice.getQuantity() == 0) {
            throw new NoItemInventoryException (
                    "Selection is currently out of stock.");
        } else {
            BigDecimal change = userCash.subtract(price);
            int currentQuantity = vendChoice.getQuantity();
            vendChoice.setQuantity(currentQuantity - 1);
            dao.saveInventory();
            return vendChoice.getItem() + " and your change " + getChange(change);
            
        }
    }
    
    private String getChange(BigDecimal change) {
        
            int remainingAmount = (int)(change.multiply(BigDecimal.valueOf(100)).intValue());
            
            int oneDollarBills = remainingAmount / Currency.ONE_DOLLAR_BILLS.getValue();
            remainingAmount = remainingAmount % Currency.ONE_DOLLAR_BILLS.getValue();
            
            int quarters = remainingAmount / Currency.QUARTERS.getValue();
            remainingAmount = remainingAmount % Currency.QUARTERS.getValue();
            
            int dimes = remainingAmount / Currency.DIMES.getValue();
            remainingAmount = remainingAmount % Currency.DIMES.getValue();
            
            int nickels = remainingAmount / Currency.NICKELS.getValue();
            remainingAmount = remainingAmount % Currency.NICKELS.getValue();
            
            int pennies = remainingAmount;
            
            return oneDollarBills + " dollars, " + quarters + " quarters, " + dimes + " dimes, " + nickels + 
                    " nickels, " + pennies + " pennies." ;
           
    }
    
}
