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
public enum Currency {

    PENNIES(1),
    NICKELS(5),
    DIMES(10),
    QUARTERS(25),
    ONE_DOLLAR_BILLS(100);

    private final int value;

    Currency(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
