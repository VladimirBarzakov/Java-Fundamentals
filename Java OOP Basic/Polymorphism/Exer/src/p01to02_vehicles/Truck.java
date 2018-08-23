package p01to02_vehicles;

public class Truck extends Vehicle {

    private static double TRUCK_REFUEL_EFFICIENCY = 0.95d;
    private static final double TRUCK_SUMMER_AIR_CONDITIONER_INCREASE = 1.6d;

    Truck(double fuelQuantity, double fuelConsumption, double fuelTankCapacity) {
        super(fuelQuantity, fuelConsumption, fuelTankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption+TRUCK_SUMMER_AIR_CONDITIONER_INCREASE);
    }

    @Override
    protected void refuel(double fuelQuantity) {
        super.refuel(fuelQuantity*TRUCK_REFUEL_EFFICIENCY);
    }

    @Override
    protected void drive(double distance) {
        if (super.isDistanceDrivable(distance)){
            super.drive(distance);
            System.out.printf("Truck travelled %s km%n",DECIMAL_FORMAT.format(distance));
        } else{
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void printFuelQuantity() {
        System.out.printf("Truck: %.2f%n",this.getFuelQuantity());
    }
}
