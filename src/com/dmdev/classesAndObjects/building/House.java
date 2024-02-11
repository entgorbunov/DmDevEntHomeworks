package com.dmdev.classesAndObjects.building;

import java.util.Arrays;
import java.util.Objects;

public class House {
    private int number;
    private Floor[] floors;

    public House(int number, Floor... floors) {
        this.number = number;
        this.floors = floors;
    }

    public void print() {
        System.out.println("Дом " + number + ", количество этажей: " + floors.length);
        for (Floor floor : floors) {
            floor.print();
        }
    }

    @Override
    public String toString() {
        return "House{" +
               "number=" + number +
               ", floors=" + Arrays.toString(floors) +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return number == house.number && Arrays.equals(floors, house.floors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(floors);
        return result;
    }
}

