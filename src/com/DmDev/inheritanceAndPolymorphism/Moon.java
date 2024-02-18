package com.DmDev.inheritanceAndPolymorphism;

public class Moon extends Satellite {

    private static final double MASS = 7.3477e22; // * 10^22 кг
    private static final double VOLUME = 2.1958e10; // * 10^10 кубических метров
    private static final String NAME = "Луна";
    public static final double DISTANCE_TO_EARTH = 384_400;


    private static Moon instance;


    private Moon() {
        super(MASS, VOLUME, NAME, Earth.getInstance(), DISTANCE_TO_EARTH);
    }


    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Moon Name: " + getName() + "\n" +
               "Mass: " + getMass() + " kg\n" +
               "Volume: " + getVolume() + " cubic km\n" +
               "Orbiting Planet: " + getOrbitingPlanetName();
    }


    @Override
    public double calculateDistance() {
        return DISTANCE_TO_EARTH;
    }
}
