package com.dmdev.arrays;
/**
 * Написать программу, удаляющую все повторяющиеся целые числа из массива и печатающую результат. Массив должен использоваться тот же самый. На место удаленных элементов ставить цифру 0.
 */
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 4, 5}; // Исходный массив
        removeTheSameNumber(array);
    }

    private static void removeTheSameNumber(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    array[j] = 0;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }


}
