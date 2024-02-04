package com.DmDev.inheritanceAndPolymorphism;

public abstract class Satellite extends CosmicObject{
    private CosmicObject orbitingPlanet;
    public Satellite(double mass, double volume, String name, CosmicObject orbitingPlanet) {
        super(mass, volume, name);
        this.orbitingPlanet = orbitingPlanet;
    }
    public String getOrbitingPlanetName() {
        return orbitingPlanet.getName();
    }
    public CosmicObject getOrbitingPlanet() {
        return orbitingPlanet;
    }
    @Override
    public String toString() {
        return "Satellite{" +
               "name=" + getName() +
               ", mass=" + getMass() +
               ", volume=" + getVolume() +
               ", orbitingPlanet=" + getOrbitingPlanetName() +
               '}';
    }
}
