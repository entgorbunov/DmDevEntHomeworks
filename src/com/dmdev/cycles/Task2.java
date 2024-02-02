package com.dmdev.cycles;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на 7консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321.
 * <p>
 * Примечание: для решения может понадобиться функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task2 {
    public static void main(String[] args) {
        System.out.println(reversed(-4508));
        System.out.println(reversedWithMathPow(-4508));
    }

    private static int reversed(int value) {
        var reversed = 0;
        for (reversed = 0; value != 0; value /= 10) {
            var lastDigit = value % 10;
            reversed = reversed * 10 + lastDigit;

        }
        return reversed;
    }

    private static int reversedWhile(int value) {
        var reversed = 0;
        while (value != 0) {
            var lastDigit = value % 10;
            reversed = reversed * 10 + lastDigit;
            value /= 10;
        }
        return reversed;
    }

    private static int reversedWithMathPow(int value) {
        var reversed = 0;
        var length = countDigitsWithString(value);
        var temp = Math.abs(value);

        while (temp != 0) {
            int lastDigit = temp % 10;
            reversed += (int) (lastDigit * Math.pow(10, length - 1)); //Умножаем последнюю цифру на 10 в степени, соответствующей позиции этой цифры.
            temp /= 10;
            length--;
        }
        return reversed;
    }

    public static int countDigitsWithString(int value) {
        return String.valueOf(Math.abs(value)).length();
    }

}
