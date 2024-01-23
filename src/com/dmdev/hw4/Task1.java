package com.dmdev.hw4;

/**
 * Написать программу, вычисляющую сумму цифр введённого пользователем целого числа.
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println(sum(9999));
        System.out.println(getSumDigits(9999));

    }

    public static int sum(int value) {
        int result = 0;
        for (int currentValue = value; currentValue != 0; currentValue/=10) {
            result += currentValue % 10;
        } return  result;
    }




    public static int getSumDigits(int value) {
        int result = 0;
        int currentValue = value;
        while (currentValue != 0) {
            result += currentValue % 10;
            currentValue /= 10;
        }

        return result;
    }


}
