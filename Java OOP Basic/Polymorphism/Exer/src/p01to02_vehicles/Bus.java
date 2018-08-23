package p01to02_vehicles;

public class Bus extends Vehicle{

    private static final double BUS_SUMMER_AIR_CONDITIONER_INCREASE = 1.4d;

    Bus(double fuelQuantity, double fuelConsumption, double fuelTankCapacity) {
        super(fuelQuantity, fuelConsumption, fuelTankCapacity);
    }


    @Override
    public void printFuelQuantity() {
        System.out.printf("Bus: %.2f%n",this.getFuelQuantity());
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption+BUS_SUMMER_AIR_CONDITIONER_INCREASE);
    }

    private boolean isDistanceDrivableEmpty(double distance){
        return distance*(this.getFuelConsumption()-BUS_SUMMER_AIR_CONDITIONER_INCREASE)<this.getFuelQuantity();
    }


    void driveEmpty(double distance) {
        if (this.isDistanceDrivableEmpty(distance)){
            this.setFuelQuantity(this.getFuelQuantity()-distance*(this.getFuelConsumption()-BUS_SUMMER_AIR_CONDITIONER_INCREASE));
            super.setDistanceTravelled(this.getDistanceTravelled()+distance);
            System.out.printf("Bus travelled %s km%n",DECIMAL_FORMAT.format(distance));
        } else{
            System.out.println("Bus needs refueling");
        }
    }


    @Override
    public void drive(double distance) {
        if (super.isDistanceDrivable(distance)){
            super.drive(distance);
            System.out.printf("Bus travelled %s km%n",DECIMAL_FORMAT.format(distance));
        } else{
            System.out.println("Bus needs refueling");
        }
    }
}
