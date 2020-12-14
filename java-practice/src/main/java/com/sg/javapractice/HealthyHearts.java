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
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to the Healthy Heart Calculator!");
        System.out.println("Please input your age:");
        double age = sc.nextInt();
        double maxHR = 220 - age;
        double zoneMin = maxHR * 0.50;
        double zoneMax = maxHR * 0.85;
        System.out.println("Your maximum heart rate should be " + Math.round(maxHR) + " beats per minute.");
        System.out.println("Your target heart rate zone is " + Math.round(zoneMin) + " to " + Math.round(zoneMax) + " beats per minute.");
    }   
}
