/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.util.Objects;

/**
 *
 * @author DZ
 */
public class Item {

    private int menuOption;
    private String item;
    private String price;
    private int quantity;

    public Item(int menuOption) {
        this.menuOption = menuOption;
    }

    public int getMenuOption() {
        return menuOption;
    }

    public void setMenuOption(int menuOption) {
        this.menuOption = menuOption;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.menuOption;
        hash = 11 * hash + Objects.hashCode(this.item);
        hash = 11 * hash + Objects.hashCode(this.price);
        hash = 11 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.menuOption != other.menuOption) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

}
