package vehicles_extension;

class Truck extends Vehicle {
    private static final double TRUCK_FUEL_CONSUMPTION_INCREASED = 1.6;
    public Truck ( double fuelQuantity, double fuelConsumption, double tankCapacity ) {
        super ( fuelQuantity, fuelConsumption + TRUCK_FUEL_CONSUMPTION_INCREASED, tankCapacity );
    }
    @Override
    public void refuel ( double liters ) {
        if (liters <= 0) {
            throw new IllegalArgumentException ( FUEL_EXCEPTION );

        }
        if (getFuelQuantity () + liters > getTankCapacity ()) {
            throw new IllegalArgumentException ( FUEL_TANK_OVERLOAD_EXCEPTION );

        }
        this.setFuelQuantity ( getFuelQuantity () + liters * 0.95 );
    }
}
