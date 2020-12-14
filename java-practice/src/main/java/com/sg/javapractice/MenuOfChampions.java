/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.javapractice;

    import java.text.DecimalFormat;

/**
 *
 * @author DZ
 */
public class MenuOfChampions {
    
    private static DecimalFormat dsp0AftDec = new DecimalFormat(".00");
    
    public static void main(String[] args) {
        double pizza = 2.50;
        double burger = 5.75;
        double soup = 4.25;
        System.out.println("nununununununununununununununununununununununununununununununununun");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("                  WELCOME TO TASTY TATES GRILL!");
        System.out.println("                     On our menu today is...");
        System.out.println("");
        System.out.println("");
        System.out.println("nununununununununununununununununununununununununununununununununun");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Slice of Tasty's Pizza (up to 3 toppings ................... $" + dsp0AftDec.format(pizza));
        System.out.println("Tasty's Juicy Lucy (choice of cheese and up to 3 toppings .. $" + burger);
        System.out.println("Tasty's Soup of the Day .................................... $" + soup);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("nununununununununununununununununununununununununununununununununun");
    }
}
