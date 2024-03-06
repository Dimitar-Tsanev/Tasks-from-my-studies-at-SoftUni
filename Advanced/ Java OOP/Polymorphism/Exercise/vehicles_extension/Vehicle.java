package vehicles_extension;

import java.text.DecimalFormat;

abstract class Vehicle {
    private static final String TRAVEL_TEMPLATE = "%s travelled %s km";
    private static final String NEED_REFUEL_EXCEPTION = "%s needs refueling";
    protected static final String FUEL_EXCEPTION = "Fuel must be a positive number";
    protected static final String FUEL_TANK_OVERLOAD_EXCEPTION = "Cannot fit fuel in tank";
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle ( double fuelQuantity, double fuelConsumption, double tankCapacity ) {
        this.setFuelQuantity ( fuelQuantity );
        this.setFuelConsumption ( fuelConsumption );
        this.setTankCapacity ( tankCapacity );
    }

    private void setTankCapacity ( double tankCapacity ) {
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelConsumption ( double fuelConsumption ) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void setFuelQuantity ( double fuelQuantity ) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelQuantity () {
        return fuelQuantity;
    }

    protected double getFuelConsumption () {
        return fuelConsumption;
    }

    protected double getTankCapacity () {
        return tankCapacity;
    }

    public void drive ( double distance ) {

        double neededFuel = distance * getFuelConsumption ( );

        if ( this.getFuelQuantity ( ) >= neededFuel ) {
            this.setFuelQuantity ( getFuelQuantity ( ) - neededFuel );

            System.out.printf ( TRAVEL_TEMPLATE + System.lineSeparator ( ),
                    this.getClass ( ).getSimpleName ( ),
                    new DecimalFormat ( "#.##" ).format ( distance ) );

        } else {
            throw new IllegalArgumentException (
                    String.format ( NEED_REFUEL_EXCEPTION,
                            this.getClass ( ).getSimpleName ( ) ) );

        }
    }

    public abstract void refuel ( double liters );

    @Override
    public String toString () {
        return String.format ( "%s: %.2f", this.getClass ( ).getSimpleName ( ), this.getFuelQuantity ( ) );
    }
}
