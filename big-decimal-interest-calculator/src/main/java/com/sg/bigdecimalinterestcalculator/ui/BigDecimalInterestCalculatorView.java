/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bigdecimalinterestcalculator.ui;

import java.math.BigDecimal;

/**
 *
 * @author DZ
 */
public class BigDecimalInterestCalculatorView {

    private UserIO io;

    public BigDecimalInterestCalculatorView(UserIO io) {
        this.io = io;
    }

    public void welcome() {
        io.print("Hi. Welcome to the Big Decimal Interest Calculator!");
    }
    
    public String initInvestment() {
        return io.readString("Enter you initial investment in numbers and decimals only (No special characters please): ");
    }
    
    public int yearsToInvest() {
        return io.readInt("Enter the number of years you would like to invest: ");
    }
    
    public String annualInterest() {
        return io.readString("Enter your annual interest rate in decimal form(No special characters please): ");
    }
    
    public int interestCompound() {
        return io.readInt("Compound interest period? 1=yearly, 2=quarterly, 3=monthly, 4=daily: ", 1, 4);
    }
    
    public int proceed() {
        return io.readInt("Would you like to calculate again or exit calculator? 1=again, 2=exit: ", 1, 2);
    }
    
    public void goodBye() {
        io.print("Thank you for using Big Decimal Interest Calculator. Good Bye!");
    }
    
    public void printYearResult(int yearCount, BigDecimal beginPrincipal, BigDecimal interestEarned, BigDecimal endPrincipal) {
        io.print("YEAR:" + yearCount + "    YEAR BEGINING PRINCIPAL:" + beginPrincipal + "    INTEREST EARNED:" + interestEarned + 
                "    YEAR END PRINCIPAL: " + endPrincipal);
    }
    
    public void printQuarterResult(int quarterCount, BigDecimal beginPrincipal, BigDecimal interestEarned, BigDecimal endPrincipal) {
        
        
    }
    
    public void printMonthlyResult(int yearCount, BigDecimal beginPrincipal, BigDecimal interestEarned, BigDecimal endPrincipal) {
        
        
    }
    
    public void printDailyResult(int yearCount, BigDecimal beginPrincipal, BigDecimal interestEarned, BigDecimal endPrincipal) {
        
        
    }
    
    public void printFinalResult(String result) {
        io.print(result);
    }

}
