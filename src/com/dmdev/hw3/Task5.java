package com.dmdev.hw3;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input value for first side of first triangular: ");
        var value1 = scanner.nextDouble();
        System.out.println("Input value for second side of first triangular: ");
        var value2 = scanner.nextDouble();
        System.out.println("Input value for first side of second triangular: ");
        var value3 = scanner.nextDouble();
        System.out.println("Input value for second side of second triangular: ");
        var value4 = scanner.nextDouble();

        double area1 = calculateArea(value1, value2);
        double area2 = calculateArea(value3, value4);

        compareAreas(area1, area2);
    }

    public static double calculateArea(double a, double b) {
        return (a * b) / 2.0;
    }

    public static void compareAreas(double area1, double area2) {
        if (area1 > area2) {
            System.out.println("Первый треугольник больше второго.");
        } else if (area1 < area2) {
            System.out.println("Первый треугольник меньше второго.");
        } else {
            System.out.println("Треугольники равны.");
        }
    }
}
