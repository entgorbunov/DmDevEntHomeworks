package com.DmDev.inheritanceAndPolymorphism;

public class Earth extends Planet {

    private static final double MASS = 5.972e24;
    private static final double VOLUME = 1.08321e12;
    private static final String NAME = "Earth";


    private static Earth instance;


    private Earth() {
        super(MASS, VOLUME, NAME, false, true);
    }


    public static Earth getInstance() {
        if (instance == null) {
            instance = new Earth();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Planet Name: " + getName() + "\n" +
               "Mass: " + getMass() + " kg\n" +
               "Volume: " + getVolume() + " cubic km\n" +
               "Has Ring: " + (isHasRing() ? "Yes" : "No") + "\n" +
               "Has Life: " + (isHasLife() ? "Yes" : "No");
    }


}
