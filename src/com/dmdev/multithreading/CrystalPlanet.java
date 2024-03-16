package com.dmdev.multithreading;

import java.util.Random;

public class CrystalPlanet {
    private final Random random = new Random();


    public int[] generateCrystals() {

        boolean crystalsNotGrowToday = random.nextInt(10) < 1;

        if (crystalsNotGrowToday) {

            System.out.println("Сегодня кристаллы не появились. Ракета улетает пустой.");
            return new int[]{0, 0};
        }

        int totalCrystals = 2 + random.nextInt(4);
        int redCrystals = random.nextInt(totalCrystals + 1);
        int whiteCrystals = totalCrystals - redCrystals;
        return new int[]{redCrystals, whiteCrystals};
    }
}

