/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensjavaconsolegame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int maxCashRoll = 0;
        int rollCount = 0;
        int maxCash = 0;

        System.out.println("Please input your starting bet.");
        int cash = sc.nextInt();

        for (int i = 1; cash > 0; i++) {

            int dice1 = rand.nextInt(6) + 1;
            int dice2 = rand.nextInt(6) + 1;
            int rollSum = dice1 + dice2;
            rollCount = i;

            System.out.println("Cash:" + cash);
            System.out.println("Roll Count:" + rollCount);
            System.out.println("Dice1:" + dice1);
            System.out.println("Dice2:" + dice2);
            System.out.println("Roll total is:" + rollSum);

            if (cash > maxCash) {
                maxCash = cash;
                maxCashRoll = rollCount;
            }

            if (rollSum == 7) {
                cash = cash + 4;

            } else {
                cash = cash - 1;
            }

            System.out.println("Max Cash to Date:" + maxCash);

        }

        System.out.println("Your cash funds are now:" + cash);
        System.out.println("Last roll before you ran out of cash:" + (rollCount));
        System.out.println("Your highest cash amount was:" + maxCash);

    }
}
