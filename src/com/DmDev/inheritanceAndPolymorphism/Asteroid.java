package com.DmDev.inheritanceAndPolymorphism;

public class Asteroid extends CosmicObject{
    private int speed;
    private boolean isDangerous;

    public Asteroid(int mass, int volume, String name, int speed, boolean isDangerous) {
        super(mass, volume, name);
        this.speed = speed;
        this.isDangerous = isDangerous;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isDangerous() {
        return isDangerous;
    }
}
