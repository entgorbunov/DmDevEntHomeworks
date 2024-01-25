package com.dmdev.hw5;

import java.util.Arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class Task5 {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        int[] intArray = transformCharToIntArray(charArray);
        System.out.println("Преобразованный массив: " + Arrays.toString(intArray));

        int average = averageArithmetic(intArray);
        System.out.println("Среднее арифметическое: " + average);
        System.out.print("Элементы больше среднего: ");
        printElementIfMoreThanAverageArithmetic(intArray, average);

    }

    private static int[] transformCharToIntArray(char[] chars) {
        var array = new int[chars.length];
        for (char i = 0; i < chars.length; i++) {
            array[i] = chars[i];
        }
        return array;
    }

    private static int averageArithmetic(int[] array) {
        int sumOfNumbers = 0;
        for (int i : array) {
            sumOfNumbers += i;
        }
        return sumOfNumbers / array.length;
    }

    private static void printElementIfMoreThanAverageArithmetic(int[] array, int average) {
        for (int i : array) {
            if (i > average) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
