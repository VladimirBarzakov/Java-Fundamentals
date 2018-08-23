package p09_google;

public class Car {
    private String model;
    private long speed;

    public Car() {
    }

    public Car(String model, long speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %d",this.model,this.speed);
    }
}
