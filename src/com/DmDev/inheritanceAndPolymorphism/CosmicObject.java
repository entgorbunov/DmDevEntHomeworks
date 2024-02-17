package com.DmDev.inheritanceAndPolymorphism;

public abstract class CosmicObject implements Massive, Named, Volumetric, CalculateDistance {

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
    public double calculateDistance(CalculateDistance measurable) {
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



    public double calculateDiameter() {
        double radius = Math.cbrt(3 * volume / (4 * Math.PI));
        return 2 * radius;
    }

    public int compareMass(CosmicObject other) {
        return Double.compare(mass, other.mass);
    }
}
