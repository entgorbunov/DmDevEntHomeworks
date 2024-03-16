package com.dmdev.multithreading.utility;

import com.dmdev.multithreading.AirMage;
import com.dmdev.multithreading.FireMage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Utility {
    public static void execute(FireMage fireMage, AirMage airMage) {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Создаем пул потоков для двух магов

        executor.execute(fireMage);
        executor.execute(airMage);

        executor.shutdown();

        try {
            while (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Все еще ожидаем завершения всех задач...");
            }
        } catch (InterruptedException e) {
            System.err.println("Ожидание завершения задач было прервано.");
            Thread.currentThread().interrupt();
        }
    }

    public static void printCompetitionIsOver() {
        System.out.println("Все задачи завершены. Соревнование окончено.");
    }
}
