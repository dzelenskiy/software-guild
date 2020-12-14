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
public class Circle extends Shape {

    protected double area;

    protected double perimeter;

    protected double radius;

    @Override
    double getPerimeter() {
        perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    @Override
    double getArea() {
        area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

}
