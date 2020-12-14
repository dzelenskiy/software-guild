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
public class FlightSimulator {
    private String planeType;
    private double turnRate;
    private double climbRate;
    private double thrust;
    private double latitude;
    private double longitude;
    private double elevation;
    private double direction;
    private double speed;
    private Obstructions dangers[];
    private double windSpeed;
    private double windDirection;
    private double temp;
    private double precipitaion;

    private static class Obstructions {

        public Obstructions() {
        }
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public double getTurnRate() {
        return turnRate;
    }

    public void setTurnRate(double turnRate) {
        this.turnRate = turnRate;
    }

    public double getClimbRate() {
        return climbRate;
    }

    public void setClimbRate(double climbRate) {
        this.climbRate = climbRate;
    }

    public double getThrust() {
        return thrust;
    }

    public void setThrust(double thrust) {
        this.thrust = thrust;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Obstructions[] getDangers() {
        return dangers;
    }

    public void setDangers(Obstructions[] dangers) {
        this.dangers = dangers;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPrecipitaion() {
        return precipitaion;
    }

    public void setPrecipitaion(double precipitaion) {
        this.precipitaion = precipitaion;
    }

    public FlightSimulator(String planeType, double latitude, double longitude, double elevation, double direction, double speed) {
        this.planeType = planeType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.direction = direction;
        this.speed = speed;
    }
    
    
    
}
