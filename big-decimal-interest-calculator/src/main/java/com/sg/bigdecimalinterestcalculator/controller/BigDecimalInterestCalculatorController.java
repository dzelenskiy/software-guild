/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bigdecimalinterestcalculator.controller;

import com.sg.bigdecimalinterestcalculator.ui.BigDecimalInterestCalculatorView;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author DZ
 */
public class BigDecimalInterestCalculatorController {

    BigDecimalInterestCalculatorView view;

    public BigDecimalInterestCalculatorController(BigDecimalInterestCalculatorView view) {
        this.view = view;
    }

    String investment;
    int yearsToInvest;
    String annualInterest;
    int interestCompound;
    int yearCount = 0;
    int quarterCount = 0;
    int monthCount = 0;
    int dayCount = 0;
    BigDecimal beginPrincipal;
    BigDecimal endPrincipal;
    BigDecimal interestEarned;
    //BigDecimal invest;
    //BigDecimal annInter;

    public void run() {
        boolean proceed = true;

        while (proceed) {
            view.welcome();
            investment = view.initInvestment();
            BigDecimal invest = new BigDecimal(investment);
            yearsToInvest = view.yearsToInvest();
            annualInterest = view.annualInterest();
            BigDecimal annInter = new BigDecimal(annualInterest);
            interestCompound = view.interestCompound();

            switch (interestCompound) {
                case 1:
                    calcYearlyCompound(invest, annInter, yearsToInvest);
                    break;
                case 2:
                    calcQuarterlyCompound(invest, annInter, yearsToInvest);
                    break;
                case 3:
                    calcMonthlyCompound(invest, annInter, yearsToInvest);
                    break;
                case 4:
                    calcDailyCompound(invest, annInter, yearsToInvest);
                    break;
            }
            int exit = view.proceed();
            if (exit == 2) {
                view.goodBye();
                proceed = false;
            }
        }

    }

    public void calcYearlyCompound(BigDecimal invest, BigDecimal annInter, int yearsToInvest) {
        beginPrincipal = invest;
        for (int i = 0; i < yearsToInvest; i++) {
            yearCount++;
            interestEarned = beginPrincipal.multiply(annInter);
            endPrincipal = beginPrincipal.add(interestEarned);
            view.printYearResult(yearCount, beginPrincipal.setScale(2, RoundingMode.HALF_DOWN),
                    interestEarned.setScale(2, RoundingMode.HALF_DOWN), endPrincipal.setScale(2, RoundingMode.HALF_DOWN));
            beginPrincipal = endPrincipal;
        }
        //view.printFinalResult();
    }

    public void calcQuarterlyCompound(BigDecimal invest, BigDecimal annInter, int yearsToInvest) {
        beginPrincipal = invest;
        for (int i = 0; i < yearsToInvest; i++) {
            yearCount++;
            for (int j = 0; j < (yearsToInvest * 4); j++) {
                quarterCount++;
                interestEarned = beginPrincipal.multiply(annInter.divide(4));
                endPrincipal = beginPrincipal.add(interestEarned);
                view.printYearResult(yearCount, beginPrincipal.setScale(2, RoundingMode.HALF_DOWN),
                interestEarned.setScale(2, RoundingMode.HALF_DOWN), endPrincipal.setScale(2, RoundingMode.HALF_DOWN));
                beginPrincipal = endPrincipal;
            }
            view.printYearResult(yearCount, beginPrincipal.setScale(2, RoundingMode.HALF_DOWN),
                interestEarned.setScale(2, RoundingMode.HALF_DOWN), endPrincipal.setScale(2, RoundingMode.HALF_DOWN));
                beginPrincipal = endPrincipal;
        }
    }

    public void calcMonthlyCompound(BigDecimal invest, BigDecimal annInter, int yearsToInvest) {
        beginPrincipal = invest;
        for (int i = 0; i < yearsToInvest; i++) {
            yearCount++;
            for (int j = 0; j < (yearsToInvest * 12); j++) {
                
                
            }
            
        }
    }

    public void calcDailyCompound(BigDecimal invest, BigDecimal annInter, int yearsToInvest) {
        beginPrincipal = invest;
        for (int i = 0; i < yearsToInvest; i++) {
            yearCount++;
            for (int j = 0; j < (yearsToInvest * 365); j++) {
                
                
            }
            
        }
    }

}
