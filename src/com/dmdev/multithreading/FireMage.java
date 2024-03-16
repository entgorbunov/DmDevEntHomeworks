package com.dmdev.multithreading;

public class FireMage implements Runnable {
    private int redCrystals = 0;
    private int whiteCrystals = 0;
    private final CrystalPlanet planet;
    private final Competition competition;

    public FireMage(CrystalPlanet planet, Competition competition) {
        this.planet = planet;
        this.competition = competition;
    }

    @Override
    public void run() {
        while (!competition.isCompetitionOver()) {
            collectCrystals();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new MageInterruptedException("Маг огня был прерван во время сна.");
            }
        }
    }

    private void collectCrystals() {
        synchronized (planet) {
            int[] crystals = planet.generateCrystals();
            redCrystals += crystals[0];
            whiteCrystals += crystals[1];
            System.out.println("Маг огня собрал " + crystals[0] + " красных и " + crystals[1] + " белых кристаллов. " +
                               "Всего: красных - " + redCrystals + ", белых - " + whiteCrystals);
            competition.checkWinCondition("Маг огня", redCrystals, whiteCrystals);
        }
    }

    public int getRedCrystals() {
        return redCrystals;
    }

    public int getWhiteCrystals() {
        return whiteCrystals;
    }
}

