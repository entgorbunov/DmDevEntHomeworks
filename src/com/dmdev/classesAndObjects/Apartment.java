package com.dmdev.classesAndObjects;

public class Apartment {
    private int number;
    private Room[] rooms;

    public Apartment(int number, Room[] rooms) {
        this.number = number;
        this.rooms = rooms;
    }

    public void print() {
        System.out.println("Квартира " + number + ", количество комнат: " + rooms.length);
        for (Room room : rooms) {
            room.print();
        }
    }
}

