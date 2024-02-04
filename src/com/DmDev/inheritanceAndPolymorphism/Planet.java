package com.DmDev.inheritanceAndPolymorphism;

public class Planet extends CosmicObject{
    private boolean hasRing;
    private boolean hasLife;

    public Planet(double mass, double volume, String name, boolean hasRing, boolean hasLife) {
        super(mass, volume, name);
        this.hasRing = hasRing;
        this.hasLife = hasLife;
    }

    public boolean isHasRing() {
        return hasRing;
    }

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
