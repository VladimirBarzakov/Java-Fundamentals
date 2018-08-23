package p06_raw_data;

public class Cargo {

    private long cargoWeight;
    private String cargoType;

    public Cargo() {
    }

    public Cargo(long cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public long getCargoWeight() {
        return cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }
}
