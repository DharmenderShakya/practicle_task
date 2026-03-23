package com.geometry.core;

public class Rectangle implements Shape {
    private double length, width;

    public Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }
}