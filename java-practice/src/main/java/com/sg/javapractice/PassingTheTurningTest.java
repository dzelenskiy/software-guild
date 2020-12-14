/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.javapractice;
import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class PassingTheTurningTest {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        String name, color, food;
        double number;
        double myNumber = 13;
        System.out.println("Hi! My name's Dmitriy. What's your name?");
        name = inputReader.next();
        System.out.println("Nice to meet you " + name + "! What's your favorite color?");
        color = inputReader.next();
        System.out.println(color + "'s a nice color, mine's green. :-) I also love cheeseburgers. "
                + "What's your favorite food?");
        food = inputReader.next();
        System.out.println("Yum! That sounds delicious! How many " + food + "'s could you eat? "
                + "Or maybe a better question is...What's you're favorite number?");
        number = inputReader.nextInt();
        double sum = number / myNumber ;
        System.out.println("Nice! What a number! " + number + "! Mine's 13. Did you know that your number divided by  my number is " + sum +"?");
        System.out.println("Oh man, look at the time! I gotta run! It's been great talking to you but I got some studying to do at the Software Guild.");      
    }
    
}
