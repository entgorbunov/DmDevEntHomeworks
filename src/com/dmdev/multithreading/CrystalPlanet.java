package com.dmdev.multithreading;

import java.util.Objects;
import java.util.Random;

public class CrystalPlanet {
    public static final int LOWER_BOUND = 2;
    public static final int CRYSTAL_RANGE = 4;
    public static final int GROWTH_PROBABILITY_DENOMINATOR = 10;
    public static final int NO_GROWTH_THRESHOLD = 1;
    private final Random random = new Random();
    boolean crystalsNotGrowToday = random.nextInt(GROWTH_PROBABILITY_DENOMINATOR) < NO_GROWTH_THRESHOLD;

    public int[] generateCrystals() {

        if (crystalsNotGrowToday) System.out.println("Сегодня кристаллы не появились. Ракета улетает пустой.");
        int totalCrystals = LOWER_BOUND + random.nextInt(CRYSTAL_RANGE);
        int redCrystals = random.nextInt(totalCrystals + 1);
        int whiteCrystals = totalCrystals - redCrystals;
        return new int[]{redCrystals, whiteCrystals};

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrystalPlanet that = (CrystalPlanet) o;
        return Objects.equals(random, that.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(random);
    }


}
