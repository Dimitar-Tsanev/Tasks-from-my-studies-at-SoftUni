package CarSalesman;

class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine ( String model, int power, int displacement, String efficiency ) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;

    }

    public Engine () {

    }

    public Engine ( String model, int power, int displacement ) {
        this.model = (model);
        this.power = (power);
        this.displacement = (displacement);
        this.efficiency = "n/a";

    }

    public Engine ( String model, int power, String efficiency ) {
        this.model = (model);
        this.power = (power);
        this.displacement = -1;
        this.efficiency = (efficiency);

    }

    public Engine ( String model, int power ) {
        this.model = (model);
        this.power = (power);
        this.displacement = -1;
        this.efficiency = "n/a";

    }

    public String getModel () {
        return this.model;
    }

    @Override
    public String toString () {
        String displacementSt;
        if ( displacement == -1 ) {
            displacementSt = "n/a";

        } else {
            displacementSt = String.valueOf ( displacement );
        }

        return String.format ( "%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s",
                model, power, displacementSt, efficiency );
    }
}
