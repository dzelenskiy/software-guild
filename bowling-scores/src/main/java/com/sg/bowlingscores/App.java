/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bowlingscores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DZ
 */
public class App {

    public static void main(String[] args) {

        List<Integer[]> frames = new ArrayList<>();
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 10, 10});  //300
        
        
    /*    List<Integer[]> frames = new ArrayList<>();
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{9, 1}); //36
        
        
        List<Integer[]> frames = new ArrayList<>();
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0, 0}); //80
        List<Integer[]> frames = new ArrayList<>();
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2}); //82
        
        
        List<Integer[]> frames = new ArrayList<>();
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{8, 1});
        frames.add(new Integer[]{9, 0});
        frames.add(new Integer[]{7, 3});
        frames.add(new Integer[]{6, 3});
        frames.add(new Integer[]{8, 2, 5}); //173 */
        

        int totalScore = 0;
        int frameScore;
        int frameCount = 0;
        int ball1;
        int ball2;
        int ball3;

        for (int i = 0; i < frames.size(); i++) {
            frameCount += 1;
            System.out.println("Frame: " + frameCount);

            Integer[] frame = frames.get(i);

            if (i < 9) {
                ball1 = frame[0];
                ball2 = frame[1];
                frameScore = ball1 + ball2;
                Integer[] nextFrame = frames.get(i + 1);
                int nextBall1 = nextFrame[0];
                int nextBall2 = nextFrame[1];
                int nextScore = nextBall1 + nextBall2;
                if (ball1 == 10) {
                    System.out.println("You bowled a strike!");
                    totalScore += frameScore + nextScore;
                    System.out.println("Frame total is " + frameScore);
                } else if (ball1 + ball2 == 10 && ball1 != 10) {
                    System.out.println("You bowled a spare!");
                    totalScore += frameScore + nextBall1;
                    System.out.println("Frame total is " + frameScore);
                } else {
                    System.out.println("First ball was a " + ball1);
                    System.out.println("Second ball was a " + ball2);
                    System.out.println("Frame total is " + frameScore);
                }
            } else if (i == 9) {
                ball1 = frame[0];
                ball2 = frame[1];
                
                if(ball1 + ball2 >= 10) {
                ball3 = frame[2];
                frameScore = ball1 + ball2 + ball3;
                totalScore += frameScore;
                
                System.out.println("First ball was a " + ball1);
                System.out.println("Second ball was a " + ball2);
                System.out.println("Third ball was a " + ball3);
                } else {
                frameScore = ball1 + ball2;
                totalScore += frameScore;
                
                System.out.println("First ball was a " + ball1);
                System.out.println("Second ball was a " + ball2);
                }  
            }
        }
        
        System.out.println("Your total score is " + totalScore);

    }

}
