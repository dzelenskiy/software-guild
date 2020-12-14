/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.javapractice;

/**
 *
 * @author DZ
 */
public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", 
            "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", 
            "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", 
            "Satsuma Orange", "Watermelon", "Snozzberry"};
        
        String[] fruitSalad;
        
        for(int i = 0; i > fruit.length; i++) {
            if((fruit[i]).contains(fruit[i])) {
                System.out.println(fruit[i]);
            }
        }
        
    }
}
