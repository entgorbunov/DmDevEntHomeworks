package com.dmdev.classesAndObjects.building;

import java.util.Arrays;
import java.util.Objects;

public class Apartment {
    private int number;
    private Room[] rooms;

    public Apartment(int number, Room... rooms) {
        this.number = number;
        this.rooms = rooms;
    }

    public void print() {
        System.out.println("Квартира " + number + ", количество комнат: " + rooms.length);
        for (Room room : rooms) {
            room.print();
        }
    }

    @Override
    public String toString() {
        return "Apartment{" +
               "number=" + number +
               ", rooms=" + Arrays.toString(rooms) +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return number == apartment.number && Arrays.equals(rooms, apartment.rooms);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(rooms);
        return result;
    }

}

