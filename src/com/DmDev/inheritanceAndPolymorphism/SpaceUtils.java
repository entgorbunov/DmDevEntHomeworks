package com.DmDev.inheritanceAndPolymorphism;

public class SpaceUtils {
    public static final double G = 6.674 * Math.pow(10, -11);
    public static final int MASS_OF_SUN = 10000;

    private SpaceUtils() {
    }

    public static double calculateGravityForce(CosmicObject object1, CosmicObject object2) {
        double distance = object1.calculateDistance(object2);
        return G * object1.getMass() * object2.getMass() / Math.pow(distance, 2);
    }

    public static boolean isStar(Star object) {

        return "Star".equals(object);
    }
}


