package com.DmDev.inheritanceAndPolymorphism;

public class Moon extends Satellite {

    private static final double MASS = 7.3477e22; // * 10^22 кг
    private static final double VOLUME = 2.1958e10; // * 10^10 кубических метров
    private static final String NAME = "Moon";

    // Единственный экземпляр класса
    private static Moon instance;

    // Конструктор делаем private, чтобы предотвратить создание экземпляра извне
    private Moon() {
        super(MASS, VOLUME, NAME, Earth.getInstance());
    }

    // Метод для получения экземпляра
    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Moon{" +
               "name=" + getName() +
               ", mass=" + getMass() +
               ", volume=" + getVolume() +
               ", orbitingPlanet=" + getOrbitingPlanetName() +
               '}';
    }

}
