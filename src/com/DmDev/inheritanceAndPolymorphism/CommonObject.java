package com.DmDev.inheritanceAndPolymorphism;

public abstract class CommonObject implements Measurable {
    private String creator;
    private int yearOfCreate;

    private int mass;
    private int volume;
    private String name;

    public CommonObject(int mass, int volume, String name, String creator, int yearOfCreate) {
        this.mass = mass;
        this.volume = volume;
        this.name = name;
        this.creator = creator;
        this.yearOfCreate = yearOfCreate;

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

    @Override
    public String toString() {
        return "Cosmic object " + name +
               " mass = " + mass +
               ", volume = " + volume +
               " created in " + yearOfCreate +
               " by " + creator;
    }

    @Override
    public double calculateDistance(Measurable measurable) {
        return 0;
    }
}
