package vehicles_extension;

class Bus extends Vehicle{
    private static final double BUS_WITH_PEOPLE_FUEL_CONSUMPTION_INCREASED = 1.4;
    private double defaultFuelConsumption;

    public Bus ( double fuelQuantity, double fuelConsumption, double tankCapacity ) {
        super ( fuelQuantity, fuelConsumption + BUS_WITH_PEOPLE_FUEL_CONSUMPTION_INCREASED, tankCapacity );
        this.setDefaultFuelConsumption (fuelConsumption);

    }

    private void setDefaultFuelConsumption ( double defaultFuelConsumption ) {
        this.defaultFuelConsumption = defaultFuelConsumption;
    }

    public void driveEmpty ( double distance){
        setFuelConsumption (this.defaultFuelConsumption );

        drive ( distance );

        setFuelConsumption ( defaultFuelConsumption + BUS_WITH_PEOPLE_FUEL_CONSUMPTION_INCREASED);
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
