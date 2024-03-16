package com.dmdev.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
        CrystalPlanet planet = new CrystalPlanet();
        Competition competition = new Competition();

        FireMage fireMage = new FireMage(planet, competition);
        AirMage airMage = new AirMage(planet, competition);

        execute(fireMage, airMage);

        printCompetitionIsOver();
    }

    public static void execute(FireMage fireMage, AirMage airMage) {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Создаем пул потоков для двух магов

        executor.execute(fireMage);
        executor.execute(airMage);

        executor.shutdown();

        while (!executor.isTerminated()) {

        }
    }

    public static void printCompetitionIsOver() {
        System.out.println("Соревнование завершено.");
    }
}

