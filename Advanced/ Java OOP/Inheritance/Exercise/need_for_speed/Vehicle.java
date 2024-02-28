package need_for_speed;

class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle ( double fuel, int horsePower ) {
        this.setFuel ( fuel );
        this.setHorsePower ( horsePower );
        this.setFuelConsumption ( DEFAULT_FUEL_CONSUMPTION );
    }

    public void setFuelConsumption ( double fuelConsumption ) {
        if (DEFAULT_FUEL_CONSUMPTION < fuelConsumption){
            this.fuelConsumption = fuelConsumption;

        }
    }

    private void setFuel ( double fuel ) {
        if ( fuel >= 0 ) {
            this.fuel = fuel;
        }
    }

    private void setHorsePower ( int horsePower ) {
        this.horsePower = horsePower;
    }

    public double getFuelConsumption () {
        return fuelConsumption;
    }

    public double getFuel () {
        return fuel;
    }

    public int getHorsePower () {
        return horsePower;
    }

    public void drive ( double kilometers){
        double neededFuel = kilometers * this.fuelConsumption;

        if (neededFuel <= this.fuel){
            setFuel ( this.fuel -= neededFuel );
        }
    }
}
