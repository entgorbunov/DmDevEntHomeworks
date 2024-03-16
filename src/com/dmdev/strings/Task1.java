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


        String upperCaseValue = value.toUpperCase().replace(" ", "");


        String result = "";
        char lastChar = 0;
        for (int i = 0; i < upperCaseValue.length(); i++) {
            char currentChar = upperCaseValue.charAt(i);
            if (currentChar != lastChar) {
                result += currentChar;
                lastChar = currentChar;
            }
        }

        return result;
    }
}

