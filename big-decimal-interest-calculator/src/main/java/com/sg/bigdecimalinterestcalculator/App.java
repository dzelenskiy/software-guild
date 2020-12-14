/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bigdecimalinterestcalculator;

import com.sg.bigdecimalinterestcalculator.controller.BigDecimalInterestCalculatorController;
import com.sg.bigdecimalinterestcalculator.ui.BigDecimalInterestCalculatorView;
import com.sg.bigdecimalinterestcalculator.ui.UserIO;
import com.sg.bigdecimalinterestcalculator.ui.UserIOConsoleImpl;
import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class App {
    
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        BigDecimalInterestCalculatorView view = new BigDecimalInterestCalculatorView(io);
        BigDecimalInterestCalculatorController controller = new BigDecimalInterestCalculatorController(view);
    
        controller.run();
    }
    
      
}
