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
public class AllTheTrivia {
    
    public static void main(String[] args) {
        
    Scanner snapshot = new Scanner(System.in);
    System.out.println("What the largest freshwater lake in the world? ");
    String answer1 = snapshot.nextLine();
    System.out.println("What is another word for lexicon? ");
    String answer2 = snapshot.nextLine();
    System.out.println("What is the world's longest river? ");
    String answer3 = snapshot.nextLine();
    System.out.println("What is the diameter of Earth? ");
    String answer4 = snapshot.nextLine();
    
    System.out.println("Did you know that the largest freshwater lake in the world is " + answer3 + ".");
    System.out.println("Did you know that another word for lexicon is " + answer4 + ".");
    System.out.println("Did you know that the worlds longest river is " + answer2 + ".");
    System.out.println("Did you kno that the diameter of the earth is " + answer1 + ".");
    
    }
    
}
