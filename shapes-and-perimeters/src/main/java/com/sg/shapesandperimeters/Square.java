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
public class Square extends Shape{
    
    protected double area;
    
    protected double perimeter;
    
    protected double side;

    @Override
    double getPerimeter() {
        perimeter = 4 * side;
        return perimeter;
    }

    @Override
    double getArea() {
        area = Math.pow(side, 2);
        return area;
    }

    public Square(double height) {
        this.side = height;
    }
    
    


    
    
    
}
