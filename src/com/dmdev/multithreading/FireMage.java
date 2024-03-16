package com.dmdev.multithreading;

import java.util.Objects;

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

    public void setRedCrystals(int redCrystals) {
        this.redCrystals = redCrystals;
    }

    public void setWhiteCrystals(int whiteCrystals) {
        this.whiteCrystals = whiteCrystals;
    }

    public CrystalPlanet getPlanet() {
        return planet;
    }

    public Competition getCompetition() {
        return competition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FireMage fireMage = (FireMage) o;
        return redCrystals == fireMage.redCrystals && whiteCrystals == fireMage.whiteCrystals && Objects.equals(planet, fireMage.planet) && Objects.equals(competition, fireMage.competition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(redCrystals, whiteCrystals, planet, competition);
    }

    @Override
    public String toString() {
        return "FireMage{" +
               "redCrystals=" + redCrystals +
               ", whiteCrystals=" + whiteCrystals +
               ", planet=" + planet +
               ", competition=" + competition +
               '}';
    }
}

