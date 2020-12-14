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
public class House3DModel {
    private double squareFootage;
    private int floors;
    private int numberOfRooms;
    private int fullBathrooms;
    private int halfBathrooms;
    private String layotDescription; //house description
    private boolean pool;
    private boolean fence;
    private int garageSize;
    private double [] roomSizes = new double[numberOfRooms];

    public House3DModel(double squareFootage, int floors, int numberOfRooms, int fullBathrooms, int halfBathrooms) {
        this.squareFootage = squareFootage;
        this.floors = floors;
        this.numberOfRooms = numberOfRooms;
        this.fullBathrooms = fullBathrooms;
        this.halfBathrooms = halfBathrooms;
    }
    
    
    
}
