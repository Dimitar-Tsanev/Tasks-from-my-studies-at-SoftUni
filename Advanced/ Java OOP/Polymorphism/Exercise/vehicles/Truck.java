package vehicles;

class Truck extends Vehicle{

    public Truck ( double fuelQuantity, double fuelConsumption ) {
        super ( fuelQuantity, fuelConsumption );
    }
    @Override
    public void refuel ( double liters ) {
        this.setFuelQuantity ( getFuelQuantity () + liters * 0.95 );
    }
}
