/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

/**
 *
 * @author DZ
 */
public class View {

    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public void welcome() {
        io.print("Welcome to Dmitriy's Overpriced Vending Machine!");
        io.print("Here's our current inventory...");
        io.print("================================================");
    }

    public void displayInventory(int selection, String item, String price, int quantity) {
        io.print(selection + " " + item + " $" + price + " " + quantity + " left");
    }

    public String inputCash() {
        return io.readString("Input cash(no special characters please): ");
    }

    public int select(int maxOption) {
        return io.readInt("Select menu option from above list or 0 to exit: ", 0, maxOption);
    }

    public void vend(String itemAndChange) {
        io.print("Here is your " + itemAndChange);
        io.print("==============================================================================================================");
        io.print(" ");
        io.print(" ");
    }
    
    public void dispInsufficientFundsError(String errorMessage) {
        io.print("!!You don't have enough cash for this item!!");
    }
    
    public void dispNoItemInventoryError(String errorMessage) {
        io.print("!!You're trying to purchase an item that is out of stock!!");
    }
    
    public void dispVendingInventoryPersistenceError(String errorMessage) {
        io.print("!!Could not load inventory. Please call the number on the vending machine for service!!");
    }

    public void dispCurrentCash(String cash) {
        io.print("You have $" + cash + " left to spend. Choose wisely!");
    }
}
