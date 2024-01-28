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
        System.out.println("Input minutes: ");
        int minutes = scanner.nextInt();

        if (isValid(minutes)) {
            if (minutes <= 15) System.out.println("First quarter");
            else if (minutes <= 30) System.out.println("Second quarter");
            else if (minutes <= 45) System.out.println("Third quarter");
            else System.out.println("Fourth quarter");
        } else System.out.println("Invalid minutes value");
    }

    private static boolean isValid(int value) {
        return value >= 0 && value <= 59;
    }


}
