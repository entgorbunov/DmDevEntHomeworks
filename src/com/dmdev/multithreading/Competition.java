package com.dmdev.multithreading;

public class Competition {
    private boolean competitionOver = false;


    public synchronized void checkWinCondition(String mageType, int redCrystals, int whiteCrystals) {
        if (redCrystals >= 20 && whiteCrystals >= 20) {
            System.out.println(mageType + " выиграли соревнование!");
            competitionOver = true;

            notifyAll();
        }
    }

    public synchronized boolean isCompetitionOver() {
        return competitionOver;
    }
}

