package com.DmDev.inheritanceAndPolymorphism;

public class Runner {
    public static void main(String[] args) {
        Moon moon = Moon.getInstance();
        System.out.println(moon);
        Earth earth = Earth.getInstance();
        System.out.println(earth);

    }
}
