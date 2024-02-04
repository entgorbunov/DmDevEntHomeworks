package com.DmDev.inheritanceAndPolymorphism;

public abstract class CosmicObject implements Measurable {

    private double mass;
    private double volume;
    private String name;
    private String objectType;


    public CosmicObject(double mass, double volume, String name) {
        this.mass = mass;
        this.volume = volume;
        this.name = name;
        this.objectType = objectType;
    }

    @Override
    public double calculateDistance(Measurable measurable) {
        return 10;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public String getName() {
        return name;
    }
    public String getObjectType() {
        return objectType;
    }


    @Override
    public String toString() {
        return "Natural object " + name +
               " mass = " + mass +
               ", volume = " + volume;
    }

    public double calculateDiameter() {
        double radius = Math.cbrt(3 * volume / (4 * Math.PI));
        return 2 * radius;
    }

    public int compareMass(CosmicObject other) {
        if (mass < other.mass) {
            return -1;
        } else if (mass > other.mass) {
            return 1;
        } else {
            return 0;
        }
    }
}
