package vehicles;

class Car extends Vehicle{
    public Car ( double fuelQuantity, double fuelConsumption ) {
        super ( fuelQuantity, fuelConsumption );
    }

    @Override
    public void refuel ( double liters ) {
        this.setFuelQuantity ( getFuelQuantity () + liters );
    }
}
