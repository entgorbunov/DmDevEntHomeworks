package com.dmdev.functions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        arithmeticFunction();
    }

    public static void arithmeticFunction() {
        Scanner scanner = new Scanner(System.in);
        double operand1 = getDoubleInput(scanner, "Введите первый операнд (используйте запятую для отделения остатка): ");
        String operation = getStringInput(scanner, "Введите оператор (+ - * / %): ");
        double operand2 = getDoubleInput(scanner, "Введите второй операнд (используйте запятую для отделения остатка): ");

        switch (operation) {
            case "+" -> System.out.println(operand1 + operand2);
            case "-" -> System.out.println(operand1 - operand2);
            case "*" -> System.out.println(operand1 * operand2);
            case "/" -> {
                if (operand2 != 0) {
                    System.out.println(operand1 / operand2);
                } else {
                    System.out.println("Ошибка, деление на ноль");
                }
            }
            case "%" -> System.out.println(operand1 % operand2);
            default -> System.out.println("Оператора " + operation + " не существует");
        }
    }

    private static double getDoubleInput(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод, пожалуйста введите число");
                scanner.next(); // to clear the buffer
            }
        }
    }

    private static String getStringInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.next();
    }
}
