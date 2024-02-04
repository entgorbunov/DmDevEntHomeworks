package com.dmdev.incapsulation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AtmWithdrawalCollections {

    public static void main(String[] args) {
        // TreeMap содержит информацию о текущих остатках в банкомате
        // ключ - номинал банкноты, значение - количество банкнот
        TreeMap<Integer, Integer> atm = new TreeMap<>((a, b) -> b.compareTo(a)); // Сортировка по убыванию
        atm.put(50, 2);
        atm.put(20, 5);
        atm.put(10, 1);

        // Желаемое значение для снятия
        int requiredAmount = 220;

        Map<Integer, Integer> result = calc(atm, requiredAmount);

        if (result.isEmpty()) {
            System.out.println("Нет необходимых банкнот для выдачи");
        } else {
            result.forEach((bill, count) -> System.out.println(bill + " - " + count));
        }
    }


    public static Map<Integer, Integer> calc(TreeMap<Integer, Integer> atm, int requiredAmount) {
        if (requiredAmount <= 0) {
            return new HashMap<>();
        }

        int remainingAmount = requiredAmount;
        Map<Integer, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : atm.entrySet()) {
            int bill = entry.getKey();
            int count = entry.getValue();

            if (remainingAmount <= 0) {
                break;
            }

            int availableQuantityOfBills = Math.min(remainingAmount / bill, count);

            if (availableQuantityOfBills > 0) {
                remainingAmount -= availableQuantityOfBills * bill;
                result.put(bill, availableQuantityOfBills);
            }
        }

        if (remainingAmount == 0) {
            return result;
        }

        return new HashMap<>();
    }
}
