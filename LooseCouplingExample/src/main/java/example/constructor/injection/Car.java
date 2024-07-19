package example.constructor.injection;

public class Car {
    private Specification specification;

    public Car(Specification specification) {
        this.specification = specification;
    }

    public void displayDetails() {
        System.out.println("CAR details : " + specification.toString());
    }
}
