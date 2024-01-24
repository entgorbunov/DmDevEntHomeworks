package com.dmdev.hw5;

public class Task1 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5}; // Исходный массив
        System.out.println("Исходный массив: ");
        printArray(array);


        shiftLeft(array);

        System.out.println("Массив после сдвига: ");
        printArray(array);

    }


    public static void shiftRight(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int lastElement = array[array.length - 1]; // Сохраняем последний элемент

        // Сдвигаем элементы массива
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        // Вставляем последний элемент на первое место
        array[0] = lastElement;
    }

    public static void shiftLeft(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int firstElement = array[0]; // Сохраняем первый элемент
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1]; // Сдвигаем каждый элемент на одну позицию влево
        }

        array[array.length - 1] = firstElement; // Помещаем первый элемент в конец массива
    }


    // Метод для печати массива
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}
