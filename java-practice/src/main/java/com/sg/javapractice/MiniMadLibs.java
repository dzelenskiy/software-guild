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
public class MiniMadLibs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Let's play MAD LIBS!");
        System.out.println("");
        System.out.println("");
        System.out.println("I need a noun: ");
        String madLib1 = sc.next();
        System.out.println("Now an adjective: ");
        String madLib2 = sc.next();
        System.out.println("Another noun: ");
        String madLib3 = sc.next();
        System.out.println("And a number: ");
        int madLib4 = sc.nextInt();
        System.out.println("Another adjective: ");
        String madLib5 = sc.next();
        System.out.println("A plural noun: ");
        String madLib6 = sc.next();
        System.out.println("Another one: ");
        String madLib7 = sc.next();
        System.out.println("One more: ");
        String madLib8 = sc.next();
        System.out.println("A verb (present tence): ");
        String madLib9 = sc.next();
        System.out.println("Same verb (past tense): ");
        String madLib10 = sc.next();
        System.out.println(".................................................");
        System.out.println("-------------------------------------------------");
        System.out.println(madLib1 + ": the " + madLib2 + " frontier. These are the voyages of the starship " + madLib3
                + ". Its " + madLib4 + "-year mission: to explore strange " + madLib5 + " " + madLib6 + ", to seek out " + madLib5
                + " " + madLib7 + " and " + madLib5 + " " + madLib8 + ", to boldly " + madLib9 + " where no one has " + madLib10 + " before.");
    }
}
