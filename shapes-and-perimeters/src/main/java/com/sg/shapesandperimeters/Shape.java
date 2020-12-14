/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapesandperimeters;

/**
 *
 * @author DZ
 */
public abstract class Shape {

    String color;
    
    protected double area;
    
    protected double perimeter;

    double getArea() {
        return area;
    }

    double getPerimeter() {
        return perimeter;
    }
    
}
