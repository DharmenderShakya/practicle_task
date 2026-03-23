package com.geometry.utils;

public class GeometryUtils {

    // Unit conversion
    public static double cmToMeter(double cm) {
        return cm / 100;
    }

    // Compare areas
    public static String compare(double a1, double a2) {
        if (a1 > a2) return "First is bigger";
        if (a1 < a2) return "Second is bigger";
        return "Equal";
    }
}