package com.dmdev.incapsulation;

/**
 * Создать класс, описывающий банкомат.
 * <p>
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 10, 20 и 50.
 * <p>
 * Создать конструктор с тремя параметрами — количеством купюр каждого номинала.
 * <p>
 * Сделать методы для добавления денег в банкомат.
 * <p>
 * Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение - успешность выполнения операции.
 * <p>
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма. Сначала банкомат будет пытаться рассчитаться 50, далее добавит недостающие 20, и только затем 10 (не нужно рассматривать более сложные варианты выдачи наличных, чтобы не усложнять алгоритм).
 */

public class ATM {
    private int quantity10;
    private int quantity20;
    private int quantity50;

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
        if (amount <= 0 || amount > sumOfMoney()) {
            System.out.println("Некорректная сумма или недостаточно средств.");
            return false;
        }

        int required50 = Math.min(amount / 50, quantity50);
        int remainingAmount = amount - required50 * 50;

        int required20 = Math.min(remainingAmount / 20, quantity20);
        remainingAmount -= required20 * 20;

        int required10 = Math.min(remainingAmount / 10, quantity10);
        remainingAmount -= required10 * 10;

        if (remainingAmount == 0) {
            this.quantity50 -= required50;
            this.quantity20 -= required20;
            this.quantity10 -= required10;
            System.out.println("Снято денег: 50x" + required50 + ", 20x" + required20 + ", 10x" + required10);
            System.out.println("Осталось средств: " + sumOfMoney());
            return true;
        } else {
            System.out.println("Невозможно выдать сумму в представленном виде банкнот.");
            return false;
        }
    }

    int sumOfMoney() {
        return quantity50 * 50 + quantity20 * 20 + quantity10 * 10;
    }

    // Getters and setters for quantity10, quantity20, quantity50 are omitted for brevity

    public static void main(String[] args) {
        ATM atm = new ATM(0, 0, 0);
        atm.addMoney(2, 3, 5); // Add some money to ensure there's enough for withdrawal
        boolean result = atm.withdrawMoney(200); // This should now work as we have added money
        System.out.println("Выдача прошла успешно: " + result);
    }
}

