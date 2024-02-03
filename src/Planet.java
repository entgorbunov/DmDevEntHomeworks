public class Planet extends CosmicObject implements Rotatable, Revolvable {
    private double diameter;

    public Planet(String name, double mass, double diameter) {
        super(name, mass);
        this.diameter = diameter;
    }

    @Override
    public double calculateDiameter() {
        return diameter;
    }

    @Override
    public void revolve() {
        System.out.println(getName() + " is revolving.");
    }

    @Override
    public void rotate() {
        System.out.println(getName() + " is rotating.");
    }

    @Override
    public String toString() {
        return String.format("Planet: %s, Mass: %f, Diameter: %f", getName(), getMass(), calculateDiameter());
    }


}
