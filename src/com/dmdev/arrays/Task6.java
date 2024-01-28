package com.dmdev.arrays;

/**
 * Дан одномерный массив целых чисел.
 *
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 *
 * Пример:
 *
 *                                          [-4, -18]
 *
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 *
 *                                          [1, 9, 3]
 */
public class Task6 {
    public static void main(String[] args) {
        int[] inputArray = {-4, 0, 1, 9, 0, -18, 3};
        int[][] result = splitArray(inputArray);


        for (int[] array : result) {
            for (int element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] splitArray(int[] array) {
        int negativeCount = 0, zeroCount = 0, positiveCount = 0;

        for (int value : array) {
            if (value < 0) negativeCount++;
            else if(value == 0) zeroCount++;
            else positiveCount++;
        }

        int[] negatives = new int[negativeCount];
        int[] zeros = new int[zeroCount];
        int[] positives = new int[positiveCount];

        int negIndex = 0, zeroIndex = 0, positiveIndex = 0;
        for (int value : array) {
            if (value < 0) negatives[negIndex++] = value;
            else if(value == 0) zeros[zeroIndex++] = value;
            else positives[positiveIndex++] = value;
        }

        return new int[][]{negatives, zeros, positives};
    }


}
