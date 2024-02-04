package com.dmdev.incapsulation;

public class ATMRunner {
    public static void main(String[] args) {
        ATM atm = new ATM(0, 0, 0);
        atm.addMoney(2, 3, 5);
        atm.printSumOfMoney();
        boolean result = atm.withdrawMoney(200);
        System.out.println("Выдача прошла успешно: " + result);
    }
}
