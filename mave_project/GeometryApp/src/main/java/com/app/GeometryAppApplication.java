package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geometry.core.Shape;
import com.geometry.threeD.Cube;
import com.geometry.threeD.Sphere;
import com.geometry.utils.GeometryUtils;
import com.geometry.core.Circle;

import com.geometry.core.Rectangle;

@SpringBootApplication
public class GeometryAppApplication {

	public static void main(String[] args) {
//		SpringApplication.run(GeometryAppApplication.class, args);
		
		Shape circle = new Circle(5);
        Shape rect = new Rectangle(4, 6);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rect.area());

        System.out.println(GeometryUtils.compare(circle.area(), rect.area()));

        Cube cube = new Cube(3);
        Sphere sphere = new Sphere(3);

        System.out.println("Cube Volume: " + cube.volume());
        System.out.println("Sphere Volume: " + sphere.volume());
	}

}
