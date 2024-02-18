package com.DmDev.inheritanceAndPolymorphism;

public class Sun extends Star {

    private static final double MASS = 1.989e30; // масса Солнца в килограммах
    private static final double VOLUME = 1.41e18; // объем Солнца в кубических километрах
    private static final String NAME = "Солнце";
    private static final double SPEED = 220.0; // скорость относительно центра галактики в км/с
    private static final double DISTANCE_TO_EARTH = 1.496e8; // среднее расстояние от Солнца до Земли в км
    private static Sun instance;

    private Sun() {
        super(MASS, VOLUME, NAME, SPEED, DISTANCE_TO_EARTH);
    }

    public static Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }

    @Override
    public double calculateDistance() {
        return DISTANCE_TO_EARTH;
    }

    @Override
    public String toString() {
        return "Star Name: " + getName() + "\n" +
               "Mass: " + getMass() + " kg\n" +
               "Volume: " + getVolume() + " cubic km\n" +
               "Speed: " + getSpeed() + " km/s\n" +
               "Distance to Earth: " + DISTANCE_TO_EARTH + " km";
    }
}
