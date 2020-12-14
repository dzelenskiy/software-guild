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
public class Triangle extends Shape {

    protected double area;

    protected double perimeter;

    protected double side1;

    protected double side2;

    protected double side3;


    @Override
    double getPerimeter() {
        perimeter = side1 + side2 + side3;
        return perimeter;
    }

    @Override
    double getArea() {
        double semiPer = (side1 + side2 + side3) / 2;
        area = Math.sqrt(semiPer * (semiPer - side1) * (semiPer - side2) * (semiPer - side3));
        return area;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
}
