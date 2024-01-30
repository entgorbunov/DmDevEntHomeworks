package com.dmdev.functions;

import java.util.Scanner;

/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * <p>
 * Протестировать функцию в main.
 */

public class Task1 {

    public static void main(String[] args) {
        whatQuarter();
    }

    public static void whatQuarter() {
        System.out.println("Введите минуты");
        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();
        if (isRange(minutes, 0, 15))
            System.out.println("Первая четверть");
        else if (isRange(minutes, 16, 30)) {
            System.out.println("Вторая четверть");
        } else if (isRange(minutes, 31, 45)) {
            System.out.println("Третья четверть");
        } else if (isRange(minutes, 46, 60)) {
            System.out.println("Четвертая четверть");
        } else System.out.println("Некорректное значение");
    }

    private static boolean isRange(int value, int begin, int endExcluded) {
        return begin <= value && value < endExcluded;
    }




}
