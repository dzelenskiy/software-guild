/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

/**
 *
 * @author DZ
 */
public class VendingInventoryPersistenceException extends Exception {

    public VendingInventoryPersistenceException(String message) {
        super(message);
    }

    public VendingInventoryPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
