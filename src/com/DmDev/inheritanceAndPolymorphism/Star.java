package com.DmDev.inheritanceAndPolymorphism;

public enum Star implements Measurable {
    RED_DWARF("Проксима Центавра", 0.145, 0.23e12, 217.5),
    YELLOW_DWARF("Солнце", 1.0, 1.40927e12, 220.0);

    private final String name;
    private final double mass; // Масса в массах Солнца
    private final double volume; // Объем в кубических километрах
    private final double speed; // Скорость относительно центра галактики в км/с

    Star(String name, double mass, double volume, double speed) {
        this.name = name;
        this.mass = mass;
        this.volume = volume;
        this.speed = speed;
    }

    @Override
    public String getName() {
        return name;
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
    public double calculateDistance(Measurable measurable) {
        return 0;
    }


    public double getSpeed() {
        return speed;
    }
}
