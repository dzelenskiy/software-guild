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
public class Order {

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    
    int orderNumber;
    
    String customerName;
    
    String state;
    
    String taxRate;
    
    String product;
    
    String area;
    
    String materialCostPerSqFoot;
    
    String laborCostPerSqFoot;
    
    String materialCost;
    
    String laborCost;
    
    String tax;
    
    String total;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMaterialCostPerSqFoot() {
        return materialCostPerSqFoot;
    }

    public void setMaterialCostPerSqFoot(String materialCostPerSqFoot) {
        this.materialCostPerSqFoot = materialCostPerSqFoot;
    }

    public String getLaborCostPerSqFoot() {
        return laborCostPerSqFoot;
    }

    public void setLaborCostPerSqFoot(String laborCostPerSqFoot) {
        this.laborCostPerSqFoot = laborCostPerSqFoot;
    }

    public String getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(String materialCost) {
        this.materialCost = materialCost;
    }

    public String getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(String laborCost) {
        this.laborCost = laborCost;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
}
