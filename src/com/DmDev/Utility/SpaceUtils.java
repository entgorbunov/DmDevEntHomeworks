package com.DmDev.Utility;

import com.DmDev.inheritanceAndPolymorphism.CosmicObject;
import com.DmDev.inheritanceAndPolymorphism.Earth;
import com.DmDev.inheritanceAndPolymorphism.Star;

import java.util.Objects;

public class SpaceUtils {
    public static final double G = 6.674 * Math.pow(10, -11);

    private SpaceUtils() {
    }

    public static double calculateGravityForce(Earth earth, CosmicObject object2) {
        double distance = object2.calculateDistance();
        return G * earth.getMass() * object2.getMass() / Math.pow(distance, 2);
    }

    public static void isStar(CosmicObject object) {
        if (object instanceof Star) System.out.println(object.getName() + " является звездой");
        else System.out.println(object.getName() + " не является звездой");
    }

    public static void calculateDiameter(CosmicObject cosmicObject) {
        double radius = Math.cbrt(3 * cosmicObject.getVolume() / (4 * Math.PI));
        System.out.println(cosmicObject.getName() + " имеет диаметр = " + Math.round(2 * radius) + " км.");
    }

    public static void compareMass(CosmicObject first, CosmicObject second) {
        if (Double.compare(first.getMass(), second.getMass()) > 0) {
            System.out.println(first.getName() + " весит больше, чем " + second.getName());
        } else if (Double.compare(first.getMass(), second.getMass()) == 0) {
            if (Objects.equals(first.getName(), second.getName())) {
                System.out.println("Вы сравниваете два одинаковых космических объекта");
            } else {
                System.out.println(first.getName() + second.getName() + " весят одинаково");
            }
        } else
            System.out.println(first.getName() + " весит меньше, чем " + second.getName());
    }
}


