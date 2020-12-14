/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sgprojectweek1;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author DZ
 */
public class DogGenetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("Hello again! Welcome back to Pet Ancestry.");
        System.out.println("I have your dog's DNA analysis in my file here.");
        System.out.println("What was your dog's name again?");
        String dogName = sc.nextLine();
        System.out.println("Ah! " + dogName + "." + " That was it.");
        System.out.println(dogName + "'s DNA background is: ");
        
        int dach = rand.nextInt(95) + 1;
        int beag = rand.nextInt(96 - dach) + 1;
        int chi = rand.nextInt(97 - (dach + beag)) + 1;
        int corg = rand.nextInt(98 - (dach + beag + chi)) + 1;
        int pug = (99 - (dach + beag + chi + corg)) + 1;
        
        System.out.println(dach + "% Dachshund");
        System.out.println(beag + "% Beagle");
        System.out.println(chi + "% Chihuahua");
        System.out.println(corg + "% Corgi");
        System.out.println(pug + "% Pug");
        System.out.println("What a dog!");
    }
}
