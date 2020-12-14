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
public class AllAboutMe {
    public static void main(String[] args) {
        String name, favFood;
        int pets, whistleAge;
        boolean gnocchi;
        name = "Dmitriy";
        favFood = "Cheeseburgers";
        pets = 2;
        whistleAge = 9;
        gnocchi = true;
        
        System.out.println("I am " + name + ".");
        System.out.println("I have " + pets + " pets.");
        System.out.println("My favorite food is " + favFood + ".");
        System.out.println("It is " + gnocchi + " that I have eaten gnocchi." );       
        System.out.println("And when I was " + whistleAge + 
            " years old,  I learned to whistle.");  
    }
   
}

