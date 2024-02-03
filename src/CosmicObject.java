public abstract class CosmicObject {
    private String name;
    private double mass; // в килограммах

    public CosmicObject(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public abstract double calculateDiameter();

    @Override
    public String toString() {
        return String.format("Cosmic Object: %s, Mass: %f", name, mass);
    }

    public int compareMass(CosmicObject other) {
        return Double.compare(this.mass, other.mass);
    }
}
