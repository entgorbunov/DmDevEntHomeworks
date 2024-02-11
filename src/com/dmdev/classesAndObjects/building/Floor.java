package com.dmdev.classesAndObjects.building;

import java.util.Arrays;
import java.util.Objects;

public class Floor {
    private int number;
    private Apartment[] apartments;

    public Floor(int number, Apartment... apartments) {
        this.number = number;
        this.apartments = apartments;
    }

    public void print() {
        System.out.println("Этаж " + number + ", количество квартир: " + apartments.length);
        for (Apartment apartment : apartments) {
            apartment.print();
        }
    }

    @Override
    public String toString() {
        return "Floor{" +
               "number=" + number +
               ", apartments=" + Arrays.toString(apartments) +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return number == floor.number && Arrays.equals(apartments, floor.apartments);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(apartments);
        return result;
    }
}

