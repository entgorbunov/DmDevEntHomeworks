package com.dmdev.functions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char MODULUS = '%';

    public static void main(String[] args) {
        arithmeticFunction();
    }

    public static void arithmeticFunction() {
        Scanner scanner = new Scanner(System.in);
        double operand1 = getDoubleInput(scanner, "Введите первый операнд (используйте запятую для отделения остатка): ");
        char operation = getStringInput(scanner, "Введите оператор (+ - * / %): ").charAt(0);
        double operand2 = getDoubleInput(scanner, "Введите второй операнд (используйте запятую для отделения остатка): ");

        try {
            double result = calculate(operand1, operand2, operation);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double calculate(double operand1, double operand2, char operation) {
        return switch (operation) {
            case ADDITION -> addition(operand1, operand2);
            case SUBTRACTION -> subtraction(operand1, operand2);
            case MULTIPLICATION -> multiplication(operand1, operand2);
            case DIVISION -> division(operand1, operand2);
            case MODULUS -> modulus(operand1, operand2);
            default -> throw new IllegalArgumentException("Неверная математическая операция: " + operation);
        };
    }

    private static double addition(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private static double subtraction(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private static double multiplication(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private static double division(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new IllegalArgumentException("Ошибка, деление на ноль");
        }
        return operand1 / operand2;
    }

    private static double modulus(double operand1, double operand2) {
        return operand1 % operand2;
    }

    private static double getDoubleInput(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод, пожалуйста введите число");
                scanner.next();
            }
        }
    }

    private static String getStringInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.next();
    }
}
