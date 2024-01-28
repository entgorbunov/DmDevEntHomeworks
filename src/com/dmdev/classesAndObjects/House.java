package com.dmdev.classesAndObjects;

public class House {
    private int number;
    private Floor[] floors;

    public House(int number, Floor[] floors) {
        this.number = number;
        this.floors = floors;
    }

    public void print() {
        System.out.println("Дом " + number + ", количество этажей: " + floors.length);
        for (Floor floor : floors) {
            floor.print();
        }
    }
}

