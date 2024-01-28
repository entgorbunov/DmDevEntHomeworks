package com.dmdev.strings;

import java.util.Arrays;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * <p>
 * Написать 2 метода:
 * <p>
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * <p>
 * Посчитать сумму всех чисел из строки
 * <p>
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class Task2 {
    public static void main(String[] args) {
        String value = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        System.out.println(Arrays.toString(convertStringToIntArray(value)));
        var intArray = convertStringToIntArray(value);
        System.out.println(convertIntArrayToIntSum(intArray));

    }

    private static int[] convertStringToIntArray(String value) {

        int count = 0;
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i))) {
                count++;
            }
        }

        var intArray = new int[count];
        var index = 0;
        for (int i = 0; i < value.length(); i++) {
            var currentChar = value.charAt(i);
            if (Character.isDigit(currentChar)) {
                intArray[index++] = Character.getNumericValue(currentChar);
//                intArray[index++] = currentChar - '0';
            }
        }
        return intArray;
    }

    private static int convertIntArrayToIntSum(int[] array) {
        int value = 0;
        for (int j : array) value += j;
        return value;
    }
}
