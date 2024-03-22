package com.dmdev.supportServiceEmulator;

import java.util.function.Function;

public class FormatNumber {
    public static String formatPhoneNumber(String phoneNumber) {

        Function<String, String> removeNonDigits = s -> s.replaceAll("\\D+", "");

        Function<String, String> formatDigits = digits -> {

            if (digits.length() >= 9) {
                String number = (digits.length() == 9 ? "3" : "") + digits;
                return String.format("+375 (%s) %s-%s-%s",
                        number.substring(1, 3),
                        number.substring(3, 6),
                        number.substring(6, 8),
                        number.substring(8, 10));
//
            } else {
                return "Некорректный номер телефона";
            }
        };

        return formatDigits.apply(removeNonDigits.apply(phoneNumber));
    }
}
