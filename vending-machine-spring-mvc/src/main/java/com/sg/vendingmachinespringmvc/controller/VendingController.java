/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.dao.VendingInventoryPersistenceException;
import com.sg.vendingmachinespringmvc.dto.Item;
import com.sg.vendingmachinespringmvc.service.InsufficientFundsException;
import com.sg.vendingmachinespringmvc.service.NoItemInventoryException;
import com.sg.vendingmachinespringmvc.service.VendingService;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DZ
 */
@Controller
public class VendingController {

    @Inject
    VendingService service;

    int id = 0;
    String name;
    BigDecimal cash = new BigDecimal("0");
    String message = "";
    String change = "";

    @GetMapping("/")
    public String loadIndex(HttpServletRequest request, Model model) {
        List<Item> itemList = null;
        try {
            service.loadInventory();
            itemList = service.getAllItems();
        } catch (VendingInventoryPersistenceException e) {

        }
        model.addAttribute("itemList", itemList);
        model.addAttribute("name", name);
        model.addAttribute("cash", cash);
        model.addAttribute("message", message);
        model.addAttribute("change", change);
        return "index";
    }

    @PostMapping("/selectItem")
    public String selectItem(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        name = request.getParameter("name");
        message = "";
        change = "";
        return "redirect:/";
    }

    @PostMapping("/inputCash")
    public String inputCash(HttpServletRequest request) {
        BigDecimal newCash = new BigDecimal(request.getParameter("cash"));
        cash = cash.add(newCash);
        message = "";
        change = "";
        return "redirect:/";
    }

    @PostMapping("/vendItem")
    public String vendItem(HttpServletRequest request) {
        try {
            if (id != 0) {
                change = service.vendItem(id, cash.toString());
                cash = new BigDecimal("0");
                message = "Thank You!";
                name = "";
                id = 0;
            } else {
                message = "Please select item!";
            }
        } catch (VendingInventoryPersistenceException vipe) {
            message = vipe.getMessage();
        } catch (InsufficientFundsException ife) {
            message = ife.getMessage();
        } catch (NoItemInventoryException niie) {
            message = niie.getMessage();
        }

        return "redirect:/";
    }

    @PostMapping("/getChange")
    public String getChange(HttpServletRequest request) {
        change = service.getChange(cash);
        message = "";
        name = "";
        id = 0;
        cash = new BigDecimal("0");
        return "redirect:/";
    }
}
