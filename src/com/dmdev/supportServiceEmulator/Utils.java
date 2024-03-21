package com.dmdev.supportServiceEmulator;

public class Utils {
    public static String formatPhoneNumber(String phoneNumber) {
        // Удаляем все нецифровые символы
        String digits = phoneNumber.replaceAll("\\D+", "");
        // Приводим номер к формату +375 (XX) XXX-XX-XX
        return String.format("+375 (%s) %s-%s-%s", digits.substring(1, 3), digits.substring(3, 6), digits.substring(6, 8), digits.substring(8, 10));
    }
}

