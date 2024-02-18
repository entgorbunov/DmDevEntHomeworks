package com.DmDev.inheritanceAndPolymorphism;

public abstract class Asteroid extends CosmicObject implements Dangerous {
    private final double speed;

    public Asteroid(double mass, double volume, String name, double speed, boolean isDangerous, double distanceToEarth) {
        super(mass, volume, name, distanceToEarth);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }


    @Override
    public abstract boolean isDangerous();
}
