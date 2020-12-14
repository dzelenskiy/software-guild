/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.javapractice;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class CoinDice {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean proceed = true;
        int userChoice;

        while (proceed) {
            do {
                System.out.println("Roll Dice? 1=yes 2=no");
                userChoice = sc.nextInt();
                if (userChoice == 1) {
                    CoinDice cd = new CoinDice();
                    System.out.println(cd.rollDice());
                } else if (userChoice == 2) {
                    proceed = false;
                }
            } while (userChoice < 1 || userChoice < 2);

        }
    }

    public int coinToss() {
        Random random = new Random();
        int coinToss = random.nextInt(2) + 1;
        coinToss = coinToss - 1;
        System.out.println(coinToss);
        return coinToss;
    }

    public int rollDice() {
        int side1 = coinToss();
        int side2 = coinToss();
        int side3 = coinToss();
        int side4 = coinToss();
        int side5 = coinToss();
        int side6 = coinToss();
        int sum = side1 + side2 + side3 + side4 + side5 + side6;
        if(sum == 0) {
            sum = 1;
        }
        return sum;
    }

}
