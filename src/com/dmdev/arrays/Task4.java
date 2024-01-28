package com.dmdev.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить — значит создать новый массив с только положительными элементами).
 * После удаления — умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * <p>
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции. Main - только для тестирования написанного функционала.
 */
public class Task4 {

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, -6, 3, 2, -9, 0, -123};
        int[] positiveValueArray = new int[]{3, 5, 3, 2, 0};
        System.out.println(Arrays.toString(createPositiveValuesArray(array)));
        System.out.println(Arrays.toString(multipleElementsArray(positiveValueArray)));

    }

    private static int[] createPositiveValuesArray(int[] array) {
        var positiveCount = 0;
        for (int value : array) {
            if (value >= 0) {
                positiveCount++;
            }
        }

        int[] resultArray = new int[positiveCount];
        int index = 0;
        for (int value : array) {
            if (value >= 0) {
                resultArray[index++] = value;
            }
        }
        return resultArray;
    }

    private static int[] multipleElementsArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= array.length;
        } return array;
    }
}
