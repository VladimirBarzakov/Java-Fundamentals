package p07_car_salesman;

public class Engine {
    private String model;
    private long power;
    private Long displacement;
    private String efficiency;

    public Engine(String model, long power) {
        this(model,power,null,null);
    }

    public Engine(String model, long power, Long displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public long getPower() {
        return power;
    }

    public Long getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.model).append(":").append(System.lineSeparator());
        builder.append("Power: ").append(this.power).append(System.lineSeparator());
        builder.append("Displacement: ");
        if (this.displacement!=null){
            builder.append(this.displacement);
        } else{
            builder.append("n/a");
        }
        builder.append(System.lineSeparator());
        builder.append("Efficiency: ");
        if (this.efficiency!=null){
            builder.append(this.efficiency);
        } else{
            builder.append("n/a");
        }
        builder.append(System.lineSeparator());
        return builder.toString();
    }
}
