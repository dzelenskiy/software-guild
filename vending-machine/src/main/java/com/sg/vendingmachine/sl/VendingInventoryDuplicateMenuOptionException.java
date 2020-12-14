/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.sl;

/**
 *
 * @author DZ
 */
public class VendingInventoryDuplicateMenuOptionException extends Exception {
    
    public VendingInventoryDuplicateMenuOptionException(String message) {
        super(message);
    }

    public VendingInventoryDuplicateMenuOptionException(String message,
            Throwable cause) {
        super(message, cause);
    }
    
}
