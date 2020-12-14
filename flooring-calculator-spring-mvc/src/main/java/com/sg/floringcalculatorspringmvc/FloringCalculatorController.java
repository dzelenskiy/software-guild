/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floringcalculatorspringmvc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DZ
 */
@Controller
public class FloringCalculatorController {

    @PostMapping("/calculate")
    public String calculate(HttpServletRequest request, Model model) {

        BigDecimal floorWidth = new BigDecimal(request.getParameter("floorWidth"));
        BigDecimal floorLength = new BigDecimal(request.getParameter("floorLength"));
        BigDecimal costPerSqFt = new BigDecimal(request.getParameter("costPerSqFt"));

        BigDecimal totalSqFt = floorWidth.multiply(floorLength);
        BigDecimal matCost = totalSqFt.multiply(costPerSqFt);

        BigDecimal labCostPerHour = new BigDecimal("86");
        BigDecimal sqFtPerHour = new BigDecimal("20");
        BigDecimal hour = new BigDecimal("60");

        MathContext mc = MathContext.DECIMAL32;

        BigDecimal laborRatePerMin = sqFtPerHour.divide(hour, mc);
        BigDecimal laborTime = totalSqFt.divide(laborRatePerMin, mc);
        BigDecimal laborHour = laborTime.divide(hour, 2, RoundingMode.HALF_UP);
        BigDecimal quarter = new BigDecimal("4");
        BigDecimal laborQuarters = laborHour.multiply(quarter);
        BigDecimal labCostPerQuarter = labCostPerHour.divide(quarter, mc);

        BigDecimal labCost = labCostPerQuarter.multiply(laborQuarters).setScale(2, RoundingMode.HALF_UP);

        BigDecimal total = matCost.add(labCost);


        model.addAttribute("totalSqFt", totalSqFt);
        model.addAttribute("costPerSqFt", costPerSqFt);
        model.addAttribute("laborHour", laborHour);
        model.addAttribute("labCost", labCost);
        model.addAttribute("total", total);
        return "result";
    }

}
