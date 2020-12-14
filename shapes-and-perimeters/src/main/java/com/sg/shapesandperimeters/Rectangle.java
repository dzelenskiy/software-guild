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
public class Rectangle extends Shape {

    protected double area;

    protected double perimeter;

    protected double length;

    protected double width;

    @Override
    double getPerimeter() {
        perimeter = (2 * length) + (2 * width);
        return perimeter;
    }

    @Override
    double getArea() {
        area = length * width;
        return area;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

}
