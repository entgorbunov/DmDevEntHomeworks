package com.dmdev.classesAndObjects;

public class Room {
    private final boolean isPassage;

    public Room(boolean isPassage) {
        this.isPassage = isPassage;
    }

    public void print() {
        System.out.println("Комната " + (isPassage ? "проходная" : "не проходная"));
    }
}

