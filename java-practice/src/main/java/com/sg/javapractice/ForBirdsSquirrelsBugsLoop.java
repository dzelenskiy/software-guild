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
public class ForBirdsSquirrelsBugsLoop {
  public static void main(String[] args) {
        int birdsInPie = 0;
        int squirrelsInPie = 0;
        int bugsInPie = 3;
        for (int i = 0, j = 0, k = 0; i < 24; i++, j = j + 5, k++) {
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
            System.out.println("Squirrel #" + j + " goes into the pie!");
            squirrelsInPie++;
            System.out.println("Bug #" + k + " goes into the pie!");
            bugsInPie = bugsInPie + 4;
        }

        System.out.println("There are " + birdsInPie + " birds, " + squirrelsInPie + " squirrels, and " + bugsInPie + " bugs in there!");
        System.out.println("Quite the pie full!");
    }  
}
