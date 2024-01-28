package CarSalesman;

class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car ( String model, Engine engine, int weight, String color ) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car ( String model, Engine engine, int weight ) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }
    public Car ( String model, Engine engine, String color ) {
        this.model = model;
        this.engine = engine;
        this.weight = -1 ;
        this.color = color;
    }
    public Car ( String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    @Override
    public String toString () {
        String weightSt;
        if ( weight == -1 ) {
            weightSt = "n/a";

        } else {
            weightSt = String.valueOf ( weight );
        }

        return String.format ( "%s:%n%s%nWeight: %s%nColor: %s"
                , model, engine, weightSt, color );
    }
}
