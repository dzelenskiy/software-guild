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
public class MiniZork {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();
            } else if (action.equals("stick your hand in")) {
                System.out.println("Oh no! You just got bit by the  neighbors long lost rabbid chihuahua!");
                System.out.println("It's been hiding in your mailbox for the last few days.");
                System.out.println("Better go get a Rabbies shot ASAP!");

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you're alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) { 
                System.out.println("");}
        } else if (action.equals("go to the house")) { 
            System.out.println("You get sleepy but have some studying to do. Take a nap, or study?");
            action = userInput.nextLine();
            if (action.equals ("take a nap")) {
                System.out.println("You caught up on your sleep, but now you're behind in class! Better study!");
            } else if (action.equals ("study")) {
                System.out.println("You stayed up late studying, but now you're sleep deprived! You might fall asleep in class.");
                System.out.println("Make sure you get a good night sleep tomorrow!");
            }
        }
    }
}
