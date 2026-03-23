package com.geometry.threeD;

public class Sphere implements ThreeDShape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double volume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}