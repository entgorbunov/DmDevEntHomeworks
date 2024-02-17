package com.DmDev.inheritanceAndPolymorphism;

public class Runner {
    public static void main(String[] args) {
        Moon moon = Moon.getInstance();
        System.out.println(moon + "\n" + "___________________" + "\n");
        Earth earth = Earth.getInstance();
        System.out.println(earth + "\n" + "___________________" + "\n");
        Apophis apophis = Apophis.getInstance();
        System.out.println(apophis + "\n" + "___________________" + "\n");
        System.out.println(Star.BLUE_GIANT + "\n" + "___________________" + "\n");
        System.out.println(Star.RED_DWARF + "\n" + "___________________" + "\n");
        System.out.println(Star.YELLOW_DWARF + "\n" + "___________________" + "\n");
        System.out.println(Star.WHITE_DWARF + "\n" + "___________________" + "\n");
        System.out.println(SpaceUtils.calculateGravityForce(earth, moon));
        System.out.println(SpaceUtils.calculateGravityForce(earth, apophis));

        System.out.println(SpaceUtils.isStar(earth));
        System.out.println(SpaceUtils.isStar(moon));
        System.out.println(SpaceUtils.isStar(apophis));
        SpaceUtils.isStar(Star.RED_DWARF);

    }
}
