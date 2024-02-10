package com.dmdev.classesAndObjects.building;

import java.util.Objects;

public class Room {
    private final boolean isPassage;

    public Room(boolean isPassage) {
        this.isPassage = isPassage;
    }

    public void print() {
        System.out.println("Комната " + (isPassage ? "проходная" : "не проходная"));
    }

    @Override
    public String toString() {
        return "Room{" +
               "isPassage=" + isPassage +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return isPassage == room.isPassage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPassage);
    }
}

