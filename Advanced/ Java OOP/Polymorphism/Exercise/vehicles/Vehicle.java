package vehicles;

import java.text.DecimalFormat;

abstract class Vehicle {
    private static final String TRAVEL_TEMPLATE = "%s travelled %s km";
    private static final String NEED_REFUEL_TEMPLATE = "%s needs refueling";
    private static final double TRUCK_FUEL_INCREASED = 1.6;
    private static final double CAR_FUEL_INCREASED = 0.9;
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle ( double fuelQuantity, double fuelConsumption ) {
        this.setFuelQuantity ( fuelQuantity );
        this.setFuelConsumption ( fuelConsumption );
    }

    protected void setFuelQuantity ( double fuelQuantity ) {
        this.fuelQuantity = fuelQuantity;
    }

    private void setFuelConsumption ( double fuelConsumption ) {
        if ( this instanceof Truck ) {
            this.fuelConsumption = fuelConsumption + TRUCK_FUEL_INCREASED;

        } else if ( this instanceof Car ) {
            this.fuelConsumption = fuelConsumption + CAR_FUEL_INCREASED;
        }
    }

    protected double getFuelQuantity () {
        return fuelQuantity;
    }

    private double getFuelConsumption () {
        return fuelConsumption;
    }

    public void drive ( double distance ){
        double neededFuel = distance * getFuelConsumption ();

        if (this.getFuelQuantity () >= neededFuel ){
            this.printTraveledDistance ( distance );
            this.setFuelQuantity ( getFuelQuantity () - neededFuel );

        }else {
            this.printNeedRefuel ( );

        }
    }

    public abstract void refuel ( double liters );

    private void printTraveledDistance ( double distance ) {
        System.out.printf ( TRAVEL_TEMPLATE + System.lineSeparator ( ),
                this.getClass ( ).getSimpleName ( ),
                new DecimalFormat ( "#.##" ).format ( distance ) );

    }

    private void printNeedRefuel () {
        System.out.printf ( NEED_REFUEL_TEMPLATE + System.lineSeparator ( ),
                this.getClass ( ).getSimpleName ( ) );
    }

    @Override
    public String toString () {
        return String.format ( "%s: %.2f", this.getClass ().getSimpleName (), this.getFuelQuantity () );
    }
}
