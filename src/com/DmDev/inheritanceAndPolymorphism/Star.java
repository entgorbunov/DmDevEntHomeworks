package com.DmDev.inheritanceAndPolymorphism;

public enum Star implements Massive, Named, Volumetric, CalculateDistance {

    RED_DWARF("Проксима Центавра", 0.145, 0.23e12, 217.5),
    YELLOW_DWARF("Солнце", 1.0, 1.40927e12, 220.0),
    BLUE_GIANT("Ригель", 17.0, 5.79e12, 250.0),
    WHITE_DWARF("Сириус B", 1.02, 0.003e12, 210.0);

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
    public double calculateDistance(CalculateDistance calculateDistance) {
        return 0;
    }


    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Star Name: " + getName() + "\n" +
               "Mass: " + getMass() + " solar masses\n" +
               "Volume: " + getVolume() + " cubic km\n" +
               "Speed: " + getSpeed() + " km/s";
    }
}
