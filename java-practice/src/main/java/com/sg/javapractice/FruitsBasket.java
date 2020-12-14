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
public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", 
            "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", 
            "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", 
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        
        int orangeCount = 0;
        int appleCount = 0;
        
        for(int i = 0; i < fruit.length; i++){ 
            if("Orange".equals(fruit[i])) {
                orangeCount++;
            } else if ("Apple".equals(fruit[i])) {
                appleCount++;
                }
            }
        String [] oranges = new String[orangeCount];
        String [] apples = new String[appleCount];
        for(int i = 0, j = 0, k= 0; i < fruit.length; i++){
            if("Orange".equals(fruit[i])) {
                oranges[j] = fruit[i];
                j++;
                } else if ("Apple".equals(fruit[i])){
                apples[k] = fruit[i];
                k++;
                }
            }
        System.out.println("There are " + orangeCount + " oranges");
        System.out.println("There are " + appleCount + " apples");
        for(String element : oranges){
            System.out.println(element);
        }
        for(String element : apples){
            System.out.println(element);
        }
    }
}
