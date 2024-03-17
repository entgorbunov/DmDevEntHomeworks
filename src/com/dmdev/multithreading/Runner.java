package com.dmdev.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.dmdev.multithreading.utility.Utility.execute;
import static com.dmdev.multithreading.utility.Utility.printCompetitionIsOver;

public class Runner {
    public static void main(String[] args) {
        CrystalPlanet planet = new CrystalPlanet();
        Competition competition = new Competition();

        FireMage fireMage = new FireMage(planet, competition);
        AirMage airMage = new AirMage(planet, competition);

        execute(fireMage, airMage);

        printCompetitionIsOver();
    }


}

