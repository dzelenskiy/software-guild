/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.sl;

import com.sg.flooringmastery.dao.AuditDao;
import com.sg.flooringmastery.dao.Dao;
import com.sg.flooringmastery.dao.DataFileError;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author DZ
 */
public class ServiceLayerImpl implements ServiceLayer {

    Dao dao;
    private AuditDao audit;

    public ServiceLayerImpl(Dao dao, AuditDao audit) {
        this.dao = dao;
        this.audit = audit;
    }

    private boolean loadConfig() throws DataFileError {
        boolean trainingMode = dao.getMode();
        return trainingMode;
    }

    @Override
    public String todaysDate() {
        LocalDate ld = LocalDate.now();
        String todaysDate = ld.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        return todaysDate;
    }

    @Override
    public String calcMaterialCost(String area, String matCostSqFt) {
        BigDecimal ar = new BigDecimal(area);
        BigDecimal mcsf = new BigDecimal(matCostSqFt);
        BigDecimal totalMatCost = ar.multiply(mcsf);
        totalMatCost = totalMatCost.setScale(2, RoundingMode.HALF_DOWN);
        return totalMatCost.toString();
    }

    @Override
    public String calcLaborCost(String area, String labCostSqFt) {
        BigDecimal ar = new BigDecimal(area);
        BigDecimal lcsf = new BigDecimal(labCostSqFt);
        BigDecimal totalLabCost = ar.multiply(lcsf);
        totalLabCost = totalLabCost.setScale(2, RoundingMode.HALF_DOWN);
        return totalLabCost.toString();
    }

    @Override
    public String calcTax(String matCost, String labCost, String taxRate) {
        BigDecimal mc = new BigDecimal(matCost);
        BigDecimal lc = new BigDecimal(labCost);
        BigDecimal preTaxTotal = mc.add(lc);
        BigDecimal taxPercent = new BigDecimal(taxRate);
        BigDecimal oneHunnit = new BigDecimal("100");
        taxPercent = taxPercent.divide(oneHunnit);
        BigDecimal tax = preTaxTotal.multiply(taxPercent);
        tax = tax.setScale(2, RoundingMode.HALF_DOWN);
        return tax.toString();
    }

    @Override
    public String calcTotal(String matCost, String labCost, String taxRate) {
        BigDecimal mc = new BigDecimal(matCost);
        BigDecimal lc = new BigDecimal(labCost);
        BigDecimal preTaxTotal = mc.add(lc);
        BigDecimal taxPercent = new BigDecimal(taxRate);
        BigDecimal oneHunnit = new BigDecimal("100");
        taxPercent = taxPercent.divide(oneHunnit);
        BigDecimal tax = preTaxTotal.multiply(taxPercent);
        BigDecimal total = preTaxTotal.add(tax);
        total = total.setScale(2, RoundingMode.HALF_DOWN);
        return total.toString();
    }

    @Override
    public int getOrderCount() throws DataFileError {
        int orderCount = dao.getOrderCount();
        return orderCount;
    }

    @Override
    public List<Tax> getTaxes() throws DataFileError {
        return dao.getTaxes();
    }

    @Override
    public List<Product> getProducts() throws DataFileError {
        return dao.getProducts();
    }

    @Override
    public List<Order> getAllOrders(String date) throws DataFileError {
        return dao.getAllOrders(date);
    }

    @Override
    public void clearMap() {
        dao.clearMap();
    }

    @Override
    public boolean addOrder(String date, int orderNumber, Order order) throws DataFileError {
        boolean trainingMode = loadConfig();
        if (trainingMode == false) {
            dao.addOrder(date, orderNumber, order);
        }
        return trainingMode;
    }

    @Override
    public boolean editOrder(String date, int orderNumber, Order order) throws DataFileError {
        boolean trainingMode = loadConfig();
        if (trainingMode == false) {
            dao.editOrder(date, orderNumber, order);
        }
        return trainingMode;
    }

    @Override
    public Order getOrder(String date, int orderNumber) throws DataFileError {
        return dao.getOrder(date, orderNumber);
    }

    @Override
    public Order removeOrder(String date, int orderNumber) throws DataFileError {
        return dao.removeOrder(date, orderNumber);
    }

}
