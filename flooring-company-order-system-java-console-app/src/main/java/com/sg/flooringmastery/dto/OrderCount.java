/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

/**
 *
 * @author DZ
 */
public class OrderCount {

    int orderCounter;

    public OrderCount(int orderCounter) {
        this.orderCounter = orderCounter;
    }

    public int getOrderCounter() {
        return orderCounter;
    }

    public void setOrderCounter(int orderCounter) {
        this.orderCounter = orderCounter;
    }

}
