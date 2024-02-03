package com.dmdev.strings;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * <p>
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */
public class Task1 {
    public static void main(String[] args) {
        String value = "abc Cpddd Dio OsfWw";
        System.out.println(removeTheSameCharactersAndSpaces(value));
    }

    private static String removeTheSameCharactersAndSpaces(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        var newString = new StringBuilder();
        var previousChar = Character.MIN_VALUE;

        for (int i = 0; i < value.length(); i++) {
            var currentChar = value.charAt(i);
            if (currentChar != ' ' &&
                (previousChar == Character.MIN_VALUE ||
                 Character.toLowerCase(currentChar) != Character.toLowerCase(previousChar))) {
                newString.append(currentChar);
                previousChar = currentChar;
            }
        }
        return newString.toString().toUpperCase();
    }
}

