package com.DmDev.inheritanceAndPolymorphism;

public abstract class Star extends CosmicObject implements Massive, Named, Volumetric, SpatialProperties {

    private final double speed; // Скорость относительно центра галактики в км/с

    public Star(double mass, double volume, String name, double speed, double distanceToEarth) {
        super(mass, volume, name, distanceToEarth);
        this.speed = speed;
    }

    @Override
    public abstract double calculateDistance();


    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Star Name: " + getName() + "\n" +
               "Mass: " + getMass() + " solar masses\n" +
               "Volume: " + getVolume() + " cubic km\n" +
               "Speed: " + getSpeed() + " km/s";
    }
}
