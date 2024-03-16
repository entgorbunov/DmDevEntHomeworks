package com.dmdev.incapsulation;


import java.util.Scanner;

public class ATM {
    private int quantity10;
    private int quantity20;
    private int quantity50;

    Scanner scanner = new Scanner(System.in);

    public ATM(int quantity50, int quantity20, int quantity10) {
        this.quantity50 = quantity50;
        this.quantity20 = quantity20;
        this.quantity10 = quantity10;
    }

    public void addMoney(int addQuantity50, int addQuantity20, int addQuantity10) {
        this.quantity50 += addQuantity50;
        this.quantity20 += addQuantity20;
        this.quantity10 += addQuantity10;
        System.out.println("Добавлено в банкомат: 50x" + addQuantity50 + ", 20x" + addQuantity20 + ", 10x" + addQuantity10);
    }

    public boolean withdrawMoney(int amount) {
        if (isInvalidAmount(amount)) {
            return false;
        }

        int required50 = calculateRequiredBillsAtStart(amount, 50, quantity50);
        int remainingAmount = amount - required50 * 50;
        int required20 = calculateRequiredBills(remainingAmount, 20, quantity20);
        remainingAmount -= required20 * 20;
        int required10 = calculateRequiredBills(remainingAmount, 10, quantity10);
        remainingAmount -= required10 * 10;

        if (isRemainingAmountZero(remainingAmount)) {
            updateQuantities(required50, required20, required10);
            printWithdrawalDetails(required50, required20, required10);
            return true;
        } else {
            System.out.println("Невозможно выдать сумму в представленном виде банкнот.");
            return false;
        }
    }

    private boolean isInvalidAmount(int amount) {
        return amount <= 0 || amount > sumOfMoney();
    }

    private int calculateRequiredBillsAtStart(int amount, int billValue, int quantity) {
        return Math.min(amount / billValue, quantity);
    }

    private int calculateRequiredBills(int remainingAmount, int billValue, int quantity) {
        return Math.min(remainingAmount / billValue, quantity);
    }

    private boolean isRemainingAmountZero(int remainingAmount) {
        return remainingAmount == 0;
    }

    private void updateQuantities(int required50, int required20, int required10) {
        this.quantity50 -= required50;
        this.quantity20 -= required20;
        this.quantity10 -= required10;
    }

    private void printWithdrawalDetails(int required50, int required20, int required10) {
        System.out.println("Снято денег: 50x" + required50 + ", 20x" + required20 + ", 10x" + required10);
        System.out.println("Осталось средств: " + sumOfMoney());
    }

    public void printSumOfMoney() {
        System.out.println("Средств на счету: " + sumOfMoney());
    }

    private int sumOfMoney() {
        return quantity50 * 50 + quantity20 * 20 + quantity10 * 10;
    }
    public void isWithdrawMoney(ATM atm) {
        System.out.println("Введите сумму для снятия: ");
        int amount = scanner.nextInt();
        if(atm.withdrawMoney(amount)) System.out.println("Деньги успешно сняты.");
        else System.out.println("Некорректная сумма или недостаточно средств.");
    }



}

