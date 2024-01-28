package com.dmdev.cycles;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321.
 * <p>
 * Примечание: для решения может понадобиться функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task5 {
    public static void main(String[] args) {
        System.out.println(reversed(-4508));
        System.out.println(reversedWithMathPow(-4508));
    }

    private static int reversed(int value) {
        int reversed;
        for (reversed = 0; value != 0; value /= 10) {
            var lastDigit = value % 10;
            reversed = reversed * 10 + lastDigit;

        }
        return reversed;
    }

    private static int reversedWhile(int value) {
        int reversed = 0;
        while (value != 0) {
            var lastDigit = value % 10;
            reversed = reversed * 10 + lastDigit;
            value /= 10;
        }
        return reversed;
    }

    private static int reversedWithMathPow(int value) {
        int reversed = 0;
        int length = (int) Math.log10(Math.abs(value)) + 1; // Определяем количество цифр в числе
        int temp = Math.abs(value);

        while (temp != 0) {
            int lastDigit = temp % 10;
            reversed += (int) (lastDigit * Math.pow(10, length - 1)); //Умножаем последнюю цифру на 10 в степени, соответствующей позиции этой цифры.
            temp /= 10;
            length--;
        }
        return reversed;
    }

}
