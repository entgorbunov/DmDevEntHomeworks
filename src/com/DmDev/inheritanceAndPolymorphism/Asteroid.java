package com.DmDev.inheritanceAndPolymorphism;

public abstract class Asteroid extends CosmicObject implements isDangerous {
    private final double speed;

    public Asteroid(double mass, double volume, String name, double speed, boolean isDangerous) {
        super(mass, volume, name);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }


    @Override
    public abstract boolean isDangerous();
}
