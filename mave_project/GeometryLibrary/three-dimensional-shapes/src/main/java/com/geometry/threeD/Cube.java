package com.geometry.threeD;

public class Cube implements ThreeDShape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public double volume() {
        return side * side * side;
    }
}