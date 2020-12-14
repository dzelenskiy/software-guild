/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissorsjavaconsolegame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int rounds = 1;
        int roundCount = 0;
        int win = 0;
        int tie = 0;
        int loss = 0;

        for (int i = 1; i <= rounds; i++) {
            System.out.println("How many rounds would you like to play? ");
            rounds = sc.nextInt();
            if (rounds >= 1 && rounds <= 10) {
                for (int j = 1; j <= rounds; j++) {
                    System.out.println("Please choose Rock Paper or Scissors. Enter '1' for rock, '2' for paper or '3' scissors:");
                    roundCount++;
                    int userChoice = sc.nextInt();

                    if (userChoice > 3 || userChoice < 1) {
                        System.out.println("Please try again! Enter 1, 2 or 3.");
                        roundCount--;
                        j--;
                        continue;
                    }

                    int compChoice = rand.nextInt(3) + 1;

                    String userChoiceWord = numToWord(userChoice);
                    String compChoiceWord = numToWord(compChoice);

                    System.out.println("Round: " + roundCount);
                    System.out.println("You picked: " + userChoiceWord);
                    System.out.println("I chose: " + compChoiceWord);

                    switch (userChoice) {
                        case 1:
                            switch (compChoice) {
                                case 1:
                                    System.out.println("It's a Tie!");
                                    tie++;
                                    break;
                                case 2:
                                    System.out.println("I won!");
                                    loss++;
                                    break;
                                case 3:
                                    System.out.println("You Won!");
                                    win++;
                                    break;
                            }
                            break;
                        case 2:
                            switch (compChoice) {
                                case 1:
                                    System.out.println("You Won!");
                                    win++;
                                    break;
                                case 2:
                                    System.out.println("It's a tie!");
                                    tie++;
                                    break;
                                case 3:
                                    System.out.println("I won!");
                                    loss++;
                                    break;
                            }
                            break;
                        case 3:
                            switch (compChoice) {
                                case 1:
                                    System.out.println("I won!");
                                    loss++;
                                    break;
                                case 2:
                                    System.out.println("You won!");
                                    win++;
                                    break;
                                case 3:
                                    System.out.println("It's a tie!");
                                    tie++;
                                    break;
                            }
                            break;
                    }
                }
                System.out.println("We played " + roundCount + " round(s).");
                System.out.println("You won " + win + " time(s)!");
                System.out.println("We tied " + tie + " time(s)!");
                System.out.println("I won " + loss + " time(s)!");
                System.out.println("...and the final winner is...");

                if (win > loss) {
                    System.out.println("You!!!");
                } else if (win < loss) {
                    System.out.println("Me!!!");
                } else {
                    System.out.println("We tied!!!");
                }

                System.out.println("It was fun playing Rock Paper Scissors with you!");
                System.out.println("Would you like to play again? Please enter 'y' for yes and 'n' for no.");
                sc.nextLine();
                String nextGame = sc.nextLine();
                if (("y").equals(nextGame)) {
                    i = 0;
                    rounds = 1;
                    roundCount = 0;
                    win = 0;
                    tie = 0;
                    loss = 0;
                } else {
                    System.out.println("Thanks for playing!");
                    i = 11;
                }
            } else {
                System.out.println("Please choose a number 1-10!");
                i = 0;
                rounds = 1;
            }

        }

    }

    public static String numToWord(int num) {

        String word = "";

        switch (num) {
            case 1:
                word = "rock";
                break;
            case 2:
                word = "paper";
                break;
            case 3:
                word = "scissors";
                break;
        }
        return word;
    }
}
