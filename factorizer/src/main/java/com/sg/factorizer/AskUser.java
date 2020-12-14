/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizer;

import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class AskUser {

    public int ask(String Ask) {
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println(Ask);
        int num = Integer.parseInt(inputReader.nextLine());
        return num;
    }
}
