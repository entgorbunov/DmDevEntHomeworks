package com.dmdev.hw4;

import java.util.Scanner;

/**
Написать программу, отображающую статистику по осадкам за N дней. N вводится пользователем.
Пользователь также должен ввести N целых чисел, обозначающих величину осадков в день.

Программа должна выводить:

a. Количество дней
b. Сумму осадков за этот период
c. Среднее количество осадков за этот период
d. Максимальное количество дневных осадков за этот период

Не использовать массивы!
 */
public class Task3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество дней: ");
        int numberOfDays = scanner.nextInt();

        if (numberOfDays <= 0) {
            System.out.println("Количество дней должно быть положительным числом.");
            return;
        }



        int totalRainfall = 0;
        int maxRainfall = 0;

        for (int i = 1; i <= numberOfDays; i++) {
            System.out.println("Введите количество осадков за день " + i + ":");
            int dailyRainfall = scanner.nextInt();

            totalRainfall += dailyRainfall;
            if (dailyRainfall > maxRainfall) {
                maxRainfall = dailyRainfall;
            }
        }

        double averageRainfall = (double) totalRainfall / numberOfDays;

        System.out.println("Статистика по осадкам:");
        System.out.println("a. Количество дней: " + numberOfDays);
        System.out.println("b. Сумма осадков за этот период: " + totalRainfall);
        System.out.println("c. Среднее количество осадков за этот период: " + averageRainfall);
        System.out.println("d. Максимальное количество дневных осадков: " + maxRainfall);
    }


}

