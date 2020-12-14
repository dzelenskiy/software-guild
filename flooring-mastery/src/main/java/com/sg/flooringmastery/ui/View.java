/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;



/**
 *
 * @author DZ
 */
public class View {
    
    private UserIO io;
    
    public View(UserIO io) {
        this.io = io;
    }
    
    //main menu-----------------------------------------------------------------------------------------------------------------------
    
    public int mainMenu() {
        io.print(" ");
        io.print("___________________________FLOORING MASTERY MAIN MENU___________________________");
        io.print("________________________________________________________________________________");
        io.print(" ");
        io.print("                                1. View Orders");
        io.print("                                2. Add Order");
        io.print("                                3. Edit Order");
        io.print("                                4. Remove Order");
        io.print("                                5. Exit");
        io.print(" ");
        return io.readInt("                         Enter number from above options", 1, 5);
    }
    
    //viewing orders------------------------------------------------------------------------------------------------------------------
    
    public void viewOrderBanner() {
        io.print(" ");
        io.print("__________________________________VIEW ORDER____________________________________");
        io.print("________________________________________________________________________________");
        io.print(" ");
    }    
    
    public String orderDate() {
        int intDate = io.readInt("                      Enter order date in MMDDYYYY format:", 01012000, 12122050);
        String stringDate = String.format("%08d", intDate);
        return stringDate;
    }
    
    public void viewOrder(int orderNumber, String customerName, String stateName, String taxRate, String product, 
            String matCostSqFt, String labCostSqFt, String area, String matCost, String labCost, String tax, String total) {
        io.print("Order " + orderNumber + ": " + customerName + ", " + area + " sq ft of " + product + " at $" + matCostSqFt +
                " material/sq ft and $" + labCostSqFt + " labor/sq ft with");
        io.print(stateName + " tax rate of " + taxRate + 
                "% amounts to $" + matCost + " materials $" + labCost + " labor $" + tax + " tax $" + total + " invoice total.");
        io.print(" ");
    }
    
    public void noOrdersThisDate(String date) {
        io.print("                    No orders file found for " + date + ".");
    }
    
    //adding new orders----------------------------------------------------------------------------------------------------------------
    
    public void addOrderBanner() {
        io.print(" ");
        io.print("___________________________________ADD ORDER____________________________________");
        io.print("________________________________________________________________________________");
        io.print(" ");
    }
    
    public void orderNumber(int orderNumber) {
        io.print("                                 Order number: " + orderNumber);
    }
    
    public String enterCustomerName() {
        return io.readString("                               Enter cutomer name:");
    }
    
    public void stateBanner() {
        io.print("                        Select from the following states:");
    }
    
    public void displayState(int optionNumber, String state) {
        io.print("                                     " + optionNumber + ". " + state);
    }
    
    public void displayState(String stateName, String taxRate) {
        io.print("                                   " + stateName + " " + taxRate + "% tax.");
    }
    
    public int selectState (int max) {
        return io.readInt("                         Enter number from above options:", 1, max);
    }
    
    public void taxRate(String state, String taxRate) {
        io.print("                                 " + state + " tax rate: " + taxRate + "%");
    }
    
    public void productBanner() {
        io.print("                        Select from the following products:");
    }
    
    public void displayProduct (int optionNumber, String product) {
        io.print("                                   " + optionNumber + ". " + product);
    }
    
    public void displayProduct (String product, String matCostSqFt, String labCostSqFt) {
        io.print("     " + product + " $" + matCostSqFt + " material cost per square foot. $" + labCostSqFt + " labor cost per square foot.");
    }
    
    public int selectProduct (int max) {
        return io.readInt("                         Enter number from above options:", 1, max);        
    }
    
    public String enterArea() {
        return io.readBigDecimal("                  Enter flooring area in square feet (numbers only):", 1, 1000000);
    } 

    public void orderInfo(String customerName, String area, String product, String matCost, String labCost, String stateName, String tax, String total) {
        io.print("               You selected " + area +" square feet of " + product + " for " + customerName + ".");
        io.print("Your billing summary is $" + matCost + " for materials, $" + labCost + " for labor and $" + tax + " for " + stateName + " tax for a total of $" + total + ".");
        io.print(" ");
    }
            
    public int submitOrder() {
        return io.readInt("        Save order?(enter 1 to save or 0 to discard changes and return to main menu.):", 0, 1);
    }
    
    public void discardChanges() {
        io.print("                  Order cancelled. Changes have been discarded.");
        io.print(" ");
    }
    
    public void addSuccess() {
        io.print("                        ***Order Successfully Added!***");
    }
    
    public void trainingMode() {
        io.print("   Could not save order. You are in TRAINNING MODE. Your changes have been discarded.");
        io.print("          To gain PRODUCTION access change false in config.txt file to true.");
        io.print(" ");
    }
    
    
    //editing orders---------------------------------------------------------------------------------------------------------------------
    
    public int enterOrderNumber() {
        return io.readInt("                             Enter order number:");
    }
    
    public void editOrderBanner() {
        io.print(" ");
        io.print("___________________________________EDIT ORDER___________________________________");
        io.print("________________________________________________________________________________");
        io.print(" ");
    }
    
    public String enterCustomerName(String currentName) {
        io.print("                    If no changes leave blank and hit enter. ");
        return io.readString("                  Customer name is " + currentName + ". Replace with:");
    }
    
    public String editState(String currentState) {
        io.print("                     If no changes leave blank and hit enter. ");        
        return io.readString("              State is " + currentState + ". Enter any character to select new state.");
    }
    
    public String editProduct (String currentProduct) {
        io.print("                    If no changes leave blank and hit enter. ");       
        return io.readString("              Product is " + currentProduct + ". Enter any character to select new product.");       
    }
    
    public String enterArea(String currentArea) {
        io.print("                    If no changes leave blank and hit enter. ");        
        return io.readString("                Area is " + currentArea + "sq feet. Replace with (numbers only):");
    } 
    
    public void editSuccess() {
        io.print("                        ***Order Successfully Changed!***");
    }

    //removing orders---------------------------------------------------------------------------------------------------------------------
    
    
    public void removeOrderBanner() {
        io.print(" ");
        io.print("_________________________________REMOVE ORDER_____________________________________");
        io.print("__________________________________________________________________________________");
        io.print(" ");
    }
    
    public void removeSuccess() {
        io.print("                        ***Order Successfully Removed!***");
    }
    
    //errors------------------------------------------------------------------------------------------------------------------------------
    
    public void errorMessage(String errorMessage) {
        io.print(errorMessage);
    }
    
    public void noOrderExists(int orderNumber, String date) {
        io.print("                   No order number " + orderNumber + " found for date " + date);
    } 
    
}
