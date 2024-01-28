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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите минуты ");
        int minutes = scanner.nextInt();

        if (isValid(minutes)) {
            if (minutes <= 15) System.out.println("Первая четверть");
            else if (minutes <= 30) System.out.println("Вторая четверть");
            else if (minutes <= 45) System.out.println("Третья четверть");
            else System.out.println("Четвертая четверть");
        } else System.out.println("Некорректное значение");
    }

    private static boolean isValid(int value) {
        return value >= 0 && value <= 59;
    }


}
