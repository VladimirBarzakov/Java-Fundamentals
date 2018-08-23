package p06_raw_data;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car() {
        this.tires=new Tire[4];
    }


    public Car(String model, long engineSpeed, long enginePower, long cargoWeight, String cargoType,
            long tire1Age, double tire1Pressire,
               long tire2Age, double tire2Pressire,
               long tire3Age, double tire3Pressire,
               long tire4Age, double tire4Pressire) {
        this.model = model;
        this.engine = new Engine(engineSpeed,enginePower);
        this.cargo = new Cargo(cargoWeight,cargoType);
        this.tires=new Tire[4];
        this.tires[0]=new Tire(tire1Age,tire1Pressire);
        this.tires[1]=new Tire(tire2Age,tire2Pressire);
        this.tires[2]=new Tire(tire3Age,tire3Pressire);
        this.tires[3]=new Tire(tire4Age,tire4Pressire);
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTires() {
        return tires;
    }
}
