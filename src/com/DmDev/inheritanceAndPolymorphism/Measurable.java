package com.DmDev.inheritanceAndPolymorphism;

public interface Measurable {

    double getMass();

    double getVolume();

    String getName();

    double calculateDistance(Measurable measurable);
}
