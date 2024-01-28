package com.dmdev.classesAndObjects;

public class Main {
    public static void main(String[] args) {

        Room room1 = new Room(true);
        Room room2 = new Room(false);
        Room[] rooms = {room1, room2};


        Apartment apartment = new Apartment(1, rooms);
        Apartment[] apartments = {apartment};


        Floor floor = new Floor(1, apartments);
        Floor[] floors = {floor};


        House house = new House(1, floors);

        printAllInformation(house);
    }

    public static void printAllInformation(House house) {
        house.print();
    }
}

