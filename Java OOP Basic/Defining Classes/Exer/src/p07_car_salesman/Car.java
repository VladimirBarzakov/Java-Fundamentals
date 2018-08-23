package p07_car_salesman;

public class Car {
    private String model;
    private Engine engine;
    private Long weight;
    private String color;

    public Car() {
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, Long weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Long getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.model).append(":").append(System.lineSeparator());
        builder.append(this.engine.toString());
        builder.append("Weight: ");
        if (this.weight!=null){
            builder.append(this.weight);
        } else{
            builder.append("n/a");
        }
        builder.append(System.lineSeparator());
        builder.append("Color: ");
        if (this.color!=null){
            builder.append(this.color);
        } else{
            builder.append("n/a");
        }
        return builder.toString();
    }
}
