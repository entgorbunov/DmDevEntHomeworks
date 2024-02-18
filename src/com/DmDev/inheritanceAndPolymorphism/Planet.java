package com.DmDev.inheritanceAndPolymorphism;

import static com.DmDev.inheritanceAndPolymorphism.Moon.DISTANCE_TO_EARTH;

public abstract class Planet extends CosmicObject implements PlanetaryFeatures {
    private final boolean hasRing;
    private final boolean hasLife;

    public Planet(double mass, double volume, String name, boolean hasRing, boolean hasLife) {
        super(mass, volume, name, DISTANCE_TO_EARTH);
        this.hasRing = hasRing;
        this.hasLife = hasLife;
    }

    @Override
    public boolean isHasRing() {
        return hasRing;
    }

    @Override
    public boolean isHasLife() {
        return hasLife;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", It's Planet! { hasRing = " + hasRing +
               ", hasLife = " + hasLife + " }";
    }


}
