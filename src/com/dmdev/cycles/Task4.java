package com.dmdev.cycles;

import java.util.Scanner;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр (вторая функция — нечетных).

 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task4 {
    public static void main(String[] args) {
        int value;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите целое число: ");
            value = scanner.nextInt();
        }

        System.out.println("Четные цифры: " + sumOfEvenNumbers(value));
        System.out.println("Нечетные цифры: " + sumOfOddNumbers(value));
    }

    private static int sumOfEvenNumbers(int value) {
        int evenCount = 0;
        if (isNegative(value)) {
            for (evenCount = 0; value != 0; value /= 10) {
                var remain = value % 10;
                if (remain % 2 == 0) evenCount ++;
            }
        } else {
            evenCount = getPositiveEvenCount(value);
        }
        return evenCount;
    }

    private static int getPositiveEvenCount(int value) {
        int evenCount;
        value *= -1;
        for (evenCount = 0; value != 0; value /= 10) {
            var remain = value % 10;
            if (remain % 2 == 0) evenCount ++;
        }
        return evenCount;
    }

    private static boolean isNegative(int value) {
        return value > 0;
    }

    private static int sumOfOddNumbers(int value) {
        int oddCount = 0;
        if (isNegative(value)) {
            for (oddCount = 0; value != 0; value /= 10) {
                var remain = value % 10;
                if (remain % 2 != 0) oddCount ++;
            }
        } else {
            oddCount = getPositiveOddCount(value);
        }
        return oddCount;
    }

    private static int getPositiveOddCount(int value) {
        int oddCount;
        value *= -1;
        for (oddCount = 0; value != 0; value /= 10) {
            var remain = value % 10;
            if (remain % 2 != 0) oddCount ++;
        }
        return oddCount;
    }


}
