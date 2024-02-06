package com.dmdev.cycles;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр (вторая функция — нечетных).
 * <p>
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1 {
    public static void main(String[] args) {
        int value = readIntFromConsole();
        System.out.println("Четные цифры: " + sumOfEvenNumbers(value));
        System.out.println("Нечетные цифры: " + sumOfOddNumbers(value));
    }

    private static int readIntFromConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите целое число: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: введено не число. Пожалуйста, введите целое число.");
                scanner.nextLine();
            }
        }
    }

    private static int sumOfEvenNumbers(int value) {
        int evenCount = 0;
        while (value != 0) {
            if (value % 10 % 2 == 0) evenCount++;
            value /= 10;
        }
        return evenCount;
    }

    private static int sumOfOddNumbers(int value) {
        int oddCount = 0;
        for (; value != 0; value /= 10) {
            if (value % 10 % 2 != 0) oddCount++;
        }
        return oddCount;
    }
}
