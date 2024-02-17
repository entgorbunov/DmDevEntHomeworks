package com.DmDev.inheritanceAndPolymorphism;

public class Apophis extends Asteroid{

    private static final double MASS = 6.1e7;
    private static final double VOLUME = 0.0093e12;
    private static final String NAME = "Apophis";
    private static final double SPEED = 30.728;
    private static final boolean IS_DANGEROUS = true;
    private static Apophis instance;

    private Apophis(double mass, double volume, String name, double speed, boolean isDangerous) {
        super(mass, volume, name, speed, isDangerous);
    }

    public static Apophis getInstance() {
        if (instance == null) {
            instance = new Apophis(MASS, VOLUME, NAME, SPEED, IS_DANGEROUS);
        }
        return instance;
    }

    @Override
    public boolean isDangerous() {
        return true;
    }

    @Override
    public String toString() {
        return "Asteroid Name: " + NAME + "\n" +
               "Mass: " + MASS + " kg\n" +
               "Volume: " + VOLUME + " cubic km\n" +
               "Speed: " + SPEED + " km/s\n" +
               "Is Dangerous: " + (isDangerous() ? "Yes" : "No");
    }




}
