package com.DmDev.inheritanceAndPolymorphism;

public abstract class CosmicObject implements Massive, Named, Volumetric, SpatialProperties {

    private final double mass;
    private final double volume;
    private final String name;
    private final double distancetoEarth;


    public CosmicObject(double mass, double volume, String name, double distanceToEarth) {
        this.mass = mass;
        this.volume = volume;
        this.name = name;
        this.distancetoEarth = distanceToEarth;
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





}
