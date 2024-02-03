public class Satellite extends CosmicObject implements Rotatable, Revolvable{
    private CosmicObject orbitingObject;
    public Satellite(String name, double mass, CosmicObject orbitingObject) {
        super(name, mass);
        this.orbitingObject = orbitingObject;
    }

    @Override
    public double calculateDiameter() {
        // Логика для расчета диаметра спутника
        return 0; // Заглушка
    }

    @Override
    public void revolve() {

    }

    @Override
    public void rotate() {
        System.out.println(getName() + " is rotating around " + orbitingObject.getName());
    }
}
