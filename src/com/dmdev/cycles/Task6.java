package com.dmdev.cycles;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 */
public class Task6 {

    public static void main(String[] args) {
        int months = 38; // 3 года и 2 месяца
        double monthlySalary = 600.0; // Зарплата Вани в начале
        double expenses = 300.0; // Расходы на еду и развлечения
        double brokerPercentage = 0.10; // Доля для инвестиций на счет брокера
        double brokerInterestRate = 0.02; // Доходность инвестиций на счету брокера

        double[] balances = calculateBalances(months, monthlySalary, expenses, brokerPercentage, brokerInterestRate);

        System.out.println("Сумма на счету Вани: $" + balances[0]);
        System.out.println("Сумма на счету брокера: $" + balances[1]);
    }

    private static double[] calculateBalances(int months, double initialSalary, double expenses, double brokerPercentage, double brokerInterestRate) {
        double monthlySalary = initialSalary;
        double vanyaBalance = 0.0; // Счет Вани
        double brokerAccount = 0.0; // Счет банка

        for (int month = 1; month <= months; month++) {
            if (month % 6 == 0) {   // Проверяем, нужно ли увеличить зарплату
                monthlySalary += 400.0; // Увеличиваем зарплату каждые 6 месяцев
            }
            double monthlyInvestment = monthlySalary * brokerPercentage; // Получаем сумму из зарплаты на инвестиции
            brokerAccount += monthlyInvestment * (1 + brokerInterestRate); // Рассчитываем доход от инвестиций
            monthlySalary -= monthlyInvestment; // Вычитаем долю на инвестиции
            vanyaBalance += monthlySalary; // Добавляем зарплату
            vanyaBalance -= expenses; // Вычитаем расходы
        }

        return new double[]{vanyaBalance, brokerAccount};
    }
}
