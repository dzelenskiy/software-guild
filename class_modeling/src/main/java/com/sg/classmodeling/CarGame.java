/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classmodeling;

/**
 *
 * @author DZ
 */
public class CarGame {
    private String type;
    private double xPos;
    private double yPos;
    private double speed;
    private double turnRadius;
    private double acceleration;
    private double damageTracker;
    private String color;
    private Modifications mods;
    private String transmission;

    private static class Modifications {

        public Modifications() {
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getTurnRadius() {
        return turnRadius;
    }

    public void setTurnRadius(double turnRadius) {
        this.turnRadius = turnRadius;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getDamageTracker() {
        return damageTracker;
    }

    public void setDamageTracker(double damageTracker) {
        this.damageTracker = damageTracker;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Modifications getMods() {
        return mods;
    }

    public void setMods(Modifications mods) {
        this.mods = mods;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public CarGame(String type, double xPos, double yPos, double speed) {
        this.type = type;
        this.xPos = xPos;
        this.yPos = yPos;
        this.speed = speed;
    }
    
    
   
}
