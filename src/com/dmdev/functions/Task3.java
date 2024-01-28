package com.dmdev.functions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double side1Triangle1 = getDoubleInput(scanner, "Введите значение для первой стороны первого треугольника: ");
        double side2Triangle1 = getDoubleInput(scanner, "Введите значение для второй стороны первого треугольника: ");
        double side1Triangle2 = getDoubleInput(scanner, "Введите значение для первой стороны второго треугольника: ");
        double side2Triangle2 = getDoubleInput(scanner, "Введите значение для второй стороны второго треугольника: ");

        double area1 = calculateArea(side1Triangle1, side2Triangle1);
        double area2 = calculateArea(side1Triangle2, side2Triangle2);

        compareAreas(area1, area2);
    }

    public static double calculateArea(double a, double b) {
        return (a * b) / 2.0;
    }

    public static void compareAreas(double area1, double area2) {
        if (area1 > area2) {
            System.out.println("Площадь первого треугольника больше.");
        } else if (area1 < area2) {
            System.out.println("Площадь второго треугольника больше.");
        } else {
            System.out.println("Площади треугольников равны.");
        }
    }

    private static double getDoubleInput(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод, пожалуйста, введите числовое значение.");
                scanner.next();
            }
        }
    }
}
