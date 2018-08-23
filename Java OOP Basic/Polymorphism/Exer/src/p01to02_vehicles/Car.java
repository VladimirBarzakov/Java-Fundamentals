package p01to02_vehicles;

public class Car extends Vehicle {

    private static final double CAR_SUMMER_AIR_CONDITIONER_INCREASE = 0.9d;
    
    Car(double fuelQuantity, double fuelConsumption, double fuelTankCapacity) {
        super(fuelQuantity, fuelConsumption, fuelTankCapacity);
    }
    
    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + CAR_SUMMER_AIR_CONDITIONER_INCREASE);
    }

    @Override
    public void drive(double distance) {
        if (super.isDistanceDrivable(distance)){
            super.drive(distance);
            System.out.printf("Car travelled %s km%n",DECIMAL_FORMAT.format(distance));
        } else{
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void printFuelQuantity() {
        System.out.printf("Car: %.2f%n",this.getFuelQuantity());
    }


}
