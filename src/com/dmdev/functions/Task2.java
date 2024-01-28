package com.dmdev.functions;

import java.util.Scanner;

/**
Даны 3 переменные:

- operand1 (double)
- operand2 (double)
- operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)

Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
Протестировать функцию в main.

Например:
Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
Результат: 34.5 (24.4 + 10.1)
 */

public class Task2 {

    public static void main(String[] args) {
        arithmeticFunction();
    }

    public static void arithmeticFunction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first operand: ");
        double operand1 = scanner.nextDouble();
        System.out.println("Input operation: ");
        String operation = scanner.next();
        System.out.println("Input second operand: ");
        double operand2 = scanner.nextDouble();
        switch (operation) {
            case "+" -> System.out.println(operand1 + operand2);
            case "-" -> System.out.println(operand1 - operand2);
            case "*" -> System.out.println(operand1 * operand2);
            case "/" -> {
                if (operand2 != 0) {
                    System.out.println(operand1 / operand2);
                } else {
                    System.out.println("Ошибка: Деление на ноль.");
                }
            }
            case "%" -> System.out.println(operand1 % operand2);
            default -> System.out.println("Неверная операция: " + operation);
        }
    }
}
