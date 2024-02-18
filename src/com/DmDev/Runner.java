package com.DmDev;

import com.DmDev.Utility.SpaceUtils;
import com.DmDev.inheritanceAndPolymorphism.Apophis;
import com.DmDev.inheritanceAndPolymorphism.Earth;
import com.DmDev.inheritanceAndPolymorphism.Moon;
import com.DmDev.inheritanceAndPolymorphism.Sun;

public class Runner {
    public static void main(String[] args) {
        Moon moon = Moon.getInstance();
        System.out.println(moon + "\n" + "___________________" + "\n");
        Earth earth = Earth.getInstance();
        System.out.println(earth + "\n" + "___________________" + "\n");
        Apophis apophis = Apophis.getInstance();
        System.out.println(apophis + "\n" + "___________________" + "\n");
        Sun sun = Sun.getInstance();
        System.out.println(sun + "\n" + "___________________" + "\n");

        System.out.println("Гравитация между планетой Земля и Луной = " + SpaceUtils.calculateGravityForce(earth, moon) + " Ньютон");

        System.out.println("Гравитация между планетой Земля и опасным астероидом при ближайшем его приближении = " + SpaceUtils.calculateGravityForce(earth, apophis) + " Ньютон");

        System.out.println("Гравитация между планетой Земля и Солнцем = " + SpaceUtils.calculateGravityForce(earth, sun) + " Ньютон");
        System.out.println("___________________" + "\n");
        SpaceUtils.isStar(moon);
        SpaceUtils.isStar(earth);
        SpaceUtils.isStar(apophis);
        SpaceUtils.isStar(sun);
        System.out.println("___________________" + "\n");

        SpaceUtils.compareMass(earth, moon);
        SpaceUtils.compareMass(earth, sun);
        SpaceUtils.compareMass(earth, earth);
        System.out.println("___________________" + "\n");

        SpaceUtils.calculateDiameter(moon);
        SpaceUtils.calculateDiameter(earth);
        SpaceUtils.calculateDiameter(apophis);
        SpaceUtils.calculateDiameter(sun);




    }


}
