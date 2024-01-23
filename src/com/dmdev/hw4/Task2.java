package com.dmdev.hw4;

/**
 * Написать программу, вычисляющую и отображающую все числа Фибоначчи меньше введённого пользователем целого числа.
 * Решить двумя способами: с помощью цикла и с помощью рекурсии.
 */

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input threshold: ");
        int threshold = scanner.nextInt();

        printFibonacciRecursion(threshold);

    }

    private static long fibNaive(int value) {
        if (value <= 1) {
            return value;
        }
        return fibNaive(value - 1) + fibNaive(value - 2);
    }

    private static long fibEffective(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    private static long fibWhile(int value) {
        if (value <= 1) {
            return value;
        }

        long a = 0, b = 1;
        for (int i = 2; i <= value; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

    public static void printFibonacci(int threshold) {
        int first = 0;
        int second = 1;
        while (second < threshold) {
            System.out.println(second);
            int next = first + second;
            first = second;
            second = next;
        }
    }

    public static void printFibonacciRecursion(int threshold) {
        int first = 0;
        int second = 1;
        fibonacci(first, second, threshold);
    }

    public static void fibonacci(int first, int second, int threshold) {
        if (second < threshold) {
            System.out.println(second);
            fibonacci(second, first + second, threshold);
        }
    }

}
