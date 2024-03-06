package vehicles_extension;

class Car extends Vehicle {
    private static final double CAR_FUEL_CONSUMPTION_INCREASED = 0.9;
    public Car ( double fuelQuantity, double fuelConsumption, double tankCapacity ) {
        super ( fuelQuantity, fuelConsumption + CAR_FUEL_CONSUMPTION_INCREASED, tankCapacity );
    }
    @Override
    public void refuel ( double liters ) {
        if (liters <= 0) {
            throw new IllegalArgumentException ( FUEL_EXCEPTION );

        }
        if (getFuelQuantity () + liters > getTankCapacity ()) {
            throw new IllegalArgumentException ( FUEL_TANK_OVERLOAD_EXCEPTION );

        }
        this.setFuelQuantity ( getFuelQuantity ( ) + liters );
    }
}
