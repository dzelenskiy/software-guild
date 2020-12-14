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
public class App {

    public static void main(String[] args) {

        Circle circle = new Circle(5);

        double cirArea = circle.getArea();
        double cirPerimeter = circle.getPerimeter();

        System.out.println("The area of circle with 5 radius is " + cirArea);
        System.out.println("The perimeter of circle with 5 radius is " + cirPerimeter);

        Triangle triangle = new Triangle(3, 4, 5);

        double triArea = triangle.getArea();
        double triPerimeter = triangle.getPerimeter();

        System.out.println("The area of triangle with sides 3, 4, 5 is " + triArea);
        System.out.println("The perimeter of triangle with sides 3, 4, 5 is " + triPerimeter);

        Square square = new Square(4);

        double squareArea = square.getArea();
        double squarePerimeter = square.getPerimeter();
        
        System.out.println("The area of square with sides 4 is " + squareArea);
        System.out.println("The perimeter of square with sides 4 is " + squarePerimeter);

        Rectangle rectangle = new Rectangle(7, 9);

        double rectangleArea = rectangle.getArea();
        double rectanglePerimeter = rectangle.getPerimeter();
        
        System.out.println("The area of rectange with sides 7, 9 is " + rectangleArea);
        System.out.println("The perimeter of rectangle with sides 7, 9 is " + rectanglePerimeter);

    }
}
