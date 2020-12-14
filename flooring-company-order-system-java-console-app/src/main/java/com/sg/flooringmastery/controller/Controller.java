/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.DataFileError;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.sl.ServiceLayer;
import com.sg.flooringmastery.ui.View;
import java.util.List;

/**
 *
 * @author DZ
 */
public class Controller {

    View view;
    private ServiceLayer sl;

    public Controller(View view, ServiceLayer sl) {
        this.view = view;
        this.sl = sl;
    }

    public void run() {

        boolean proceed = true;
        int menuSelection = 0;

        try {
            while (proceed) {

                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        viewOrders();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        proceed = false;
                        break;
                }
            }
        } catch (DataFileError dfe) {
            view.errorMessage(dfe.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.mainMenu();
    }

    private void viewOrders() throws DataFileError {
        view.viewOrderBanner();
        String date = view.orderDate();
        List<Order> orders = sl.getAllOrders(date);
        if (orders.isEmpty()) {
            view.noOrdersThisDate(date);
        } else {
            for (Order order : orders) {
                view.viewOrder(order.getOrderNumber(), order.getCustomerName(), order.getState(), order.getTaxRate(),
                        order.getProduct(), order.getMaterialCostPerSqFoot(), order.getLaborCostPerSqFoot(), order.getArea(),
                        order.getMaterialCost(), order.getLaborCost(), order.getTax(), order.getTotal());
            }
        }
        sl.clearMap();
    }

    private void addOrder() throws DataFileError {
        view.addOrderBanner();
        int orderNumber = sl.getOrderCount() + 1;
        Order order = new Order(orderNumber);
        view.orderNumber(orderNumber);
        String customerName;
        do {
            customerName = view.enterCustomerName();
        } while (customerName.trim().isEmpty());
        order.setCustomerName(customerName);
        view.stateBanner();
        List<Tax> taxes = sl.getTaxes();
        for (int i = 0; i < taxes.size(); i++) {
            Tax state = taxes.get(i);
            view.displayState(i + 1, state.getStateName());
        }
        int stateSelection = view.selectState(taxes.size());
        Tax state = taxes.get(stateSelection - 1);
        String stateName = state.getStateName();
        String taxRate = state.getTaxRate();
        view.displayState(stateName, taxRate);
        order.setState(stateName);
        order.setTaxRate(taxRate);
        view.productBanner();
        List<Product> products = sl.getProducts();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            view.displayProduct(i + 1, product.getProductName());
        }
        int productSelection = view.selectProduct(products.size());
        Product product = products.get(productSelection - 1);
        String productName = product.getProductName();
        String matCostSqFt = product.getMaterialCostPerSqFoot();
        String labCostSqFt = product.getLaborCostPerSqFoot();
        view.displayProduct(productName, matCostSqFt, labCostSqFt);
        order.setProduct(productName);
        order.setMaterialCostPerSqFoot(matCostSqFt);
        order.setLaborCostPerSqFoot(labCostSqFt);
        String area = view.enterArea();
        order.setArea(area);
        String matCost = sl.calcMaterialCost(area, matCostSqFt);
        order.setMaterialCost(matCost);
        String labCost = sl.calcLaborCost(area, labCostSqFt);
        order.setLaborCost(labCost);
        String tax = sl.calcTax(matCost, labCost, taxRate);
        order.setTax(tax);
        String total = sl.calcTotal(matCost, labCost, taxRate);
        order.setTotal(total);
        view.orderInfo(customerName, area, productName, matCost, labCost, stateName, tax, total);
        int submit = view.submitOrder();
        String date = sl.todaysDate();
        if (submit == 1) {
            boolean trainingMode = sl.addOrder(date, orderNumber, order);
            if (trainingMode == true) {
                view.trainingMode();
            } else if (trainingMode == false) {
                view.addSuccess();
            }
        } else {
            view.discardChanges();
        }
        sl.clearMap();
    }

    private void editOrder() throws DataFileError {
        view.editOrderBanner();
        String date = view.orderDate();
        int orderNumber = view.enterOrderNumber();
        Order order = sl.getOrder(date, orderNumber);
        if (order == null) {
            view.noOrderExists(orderNumber, date);
        } else {
            String customerName = view.enterCustomerName(order.getCustomerName());
            if (customerName.isEmpty() || customerName.trim().isEmpty()) {
                //No changes.
            } else {
                order.setCustomerName(customerName);
            }
            String changeState = view.editState(order.getState());
            if (changeState.isEmpty() || changeState.trim().isEmpty()) {
                //No changes.
            } else {
                view.stateBanner();
                List<Tax> taxes = sl.getTaxes();
                for (int i = 0; i < taxes.size(); i++) {
                    Tax state = taxes.get(i);
                    view.displayState(i + 1, state.getStateName());
                }
                int stateSelection = view.selectState(taxes.size());
                Tax state = taxes.get(stateSelection - 1);
                String stateName = state.getStateName();
                String taxRate = state.getTaxRate();
                view.displayState(stateName, taxRate);
                order.setState(stateName);
                order.setTaxRate(taxRate);
            }
            String changeProduct = view.editProduct(order.getProduct());
            if (changeProduct.isEmpty() || changeProduct.trim().isEmpty()) {
                //No changes.
            } else {
                view.productBanner();
                List<Product> products = sl.getProducts();
                for (int i = 0; i < products.size(); i++) {
                    Product product = products.get(i);
                    view.displayProduct(i + 1, product.getProductName());
                }
                int productSelection = view.selectProduct(products.size());
                Product product = products.get(productSelection - 1);
                String productName = product.getProductName();
                String matCostSqFt = product.getMaterialCostPerSqFoot();
                String labCostSqFt = product.getLaborCostPerSqFoot();
                view.displayProduct(productName, matCostSqFt, labCostSqFt);
                order.setProduct(productName);
                order.setMaterialCostPerSqFoot(matCostSqFt);
                order.setLaborCostPerSqFoot(labCostSqFt);
            }
            String area = view.enterArea(order.getArea());
            if (area.isEmpty() || area.trim().isEmpty()) {
                //No changes.
            } else {
                order.setArea(area);
            }
            customerName = order.getCustomerName();
            String stateName = order.getState();
            String productName = order.getProduct();
            String taxRate = order.getTaxRate();
            String matCostSqFt = order.getMaterialCostPerSqFoot();
            String labCostSqFt = order.getLaborCostPerSqFoot();
            area = order.getArea();
            String matCost = sl.calcMaterialCost(area, matCostSqFt);
            order.setMaterialCost(matCost);
            String labCost = sl.calcLaborCost(area, labCostSqFt);
            order.setLaborCost(labCost);
            String tax = sl.calcTax(matCost, labCost, taxRate);
            order.setTax(tax);
            String total = sl.calcTotal(matCost, labCost, taxRate);
            order.setTotal(total);
            view.orderInfo(customerName, area, productName, matCost, labCost, stateName, tax, total);
            int submit = view.submitOrder();
            if (submit == 1) {
                boolean trainingMode = sl.editOrder(date, orderNumber, order);
                if (trainingMode == true) {
                    view.trainingMode();
                } else if (trainingMode == false) {
                    view.editSuccess();
                }
            } else {
                view.discardChanges();
            }
        }
        sl.clearMap();
    }

    private void removeOrder() throws DataFileError {
        view.removeOrderBanner();
        String date = view.orderDate();
        int orderNumber = view.enterOrderNumber();
        Order removedOrder = sl.removeOrder(date, orderNumber);
        if (removedOrder != null) {
            view.removeSuccess();
        } else {
            view.noOrderExists(orderNumber, date);
        }
        sl.clearMap();
    }

}
