package com.dmdev.classesAndObjects;

import com.dmdev.classesAndObjects.building.Apartment;
import com.dmdev.classesAndObjects.building.Floor;
import com.dmdev.classesAndObjects.building.House;
import com.dmdev.classesAndObjects.building.Room;

import static com.dmdev.classesAndObjects.printer.Printer.printAllInformation;

public class Runner {

    public static void main(String[] args) {

        Room room1 = new Room(false); // Не проходная комната
        Room room2 = new Room(true); // Проходная комната
        Room room3 = new Room(false); // Не проходная комната


        Apartment apartment1 = new Apartment(1, room1, room2);
        Apartment apartment2 = new Apartment(2, room3);


        Floor floor1 = new Floor(1, apartment1);
        Floor floor2 = new Floor(2, apartment2);


        House house = new House(123, floor1, floor2);


        printAllInformation(house);
    }


}
