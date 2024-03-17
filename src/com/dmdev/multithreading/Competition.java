package com.dmdev.multithreading;

import java.util.Objects;

public class Competition {
    private static final int WINNING_RED_CRYSTALS_COUNT = 20;
    private static final int WINNING_WHITE_CRYSTALS_COUNT = 20;
    private boolean competitionOver = false;

    public synchronized void checkWinCondition(String mageType, int redCrystals, int whiteCrystals) {
        if (redCrystals >= WINNING_RED_CRYSTALS_COUNT && whiteCrystals >= WINNING_WHITE_CRYSTALS_COUNT) {
            System.out.println(mageType + " выиграли соревнование!");
            competitionOver = true;
            notifyAll();
        }
    }

    public synchronized boolean isCompetitionOver() {
        return competitionOver;
    }

    public void setCompetitionOver(boolean competitionOver) {
        this.competitionOver = competitionOver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return competitionOver == that.competitionOver;
    }

    @Override
    public int hashCode() {
        return Objects.hash(competitionOver);
    }

    @Override
    public String toString() {
        return "Competition{" +
               "competitionOver=" + competitionOver +
               '}';
    }
}
