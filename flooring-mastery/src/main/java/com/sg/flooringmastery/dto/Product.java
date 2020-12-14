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
public class Product {

    String productName;

    String materialCostPerSqFoot;

    String laborCostPerSqFoot;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

}
