package com.DmDev.inheritanceAndPolymorphism;

public class Earth extends Planet {

    private static final double MASS = 5.972e24;
    private static final double VOLUME = 1.08321e12;
    private static final String NAME = "Earth";

    // Единственный экземпляр класса
    private static Earth instance;

    // Конструктор делаем private, чтобы предотвратить создание экземпляра извне
    private Earth() {
        super(MASS, VOLUME, NAME, false, true);
    }

    // Метод для получения экземпляра
    public static Earth getInstance() {
        if (instance == null) {
            instance = new Earth();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Earth{" +
               "name=" + getName() +
               ", mass=" + getMass() +
               ", volume=" + getVolume() +
               ", hasRing=" + isHasRing() +
               ", hasLife=" + isHasLife() +
               '}';
    }

}
