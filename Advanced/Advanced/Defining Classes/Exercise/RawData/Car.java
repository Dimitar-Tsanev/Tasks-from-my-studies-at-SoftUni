package RawData;

class Car {
    private String model;
    private Tier[] tires = new Tier[4];

    private Engine engine;

    private Cargo cargo;

    public Car ( String model, Tier[] tires, Engine engine, Cargo cargo ) {
        this.model = model;
        this.tires = tires;
        this.engine = engine;
        this.cargo = cargo;

    }
    public String getModel () {
        return this.model;
    }

    public Tier[] getTires () {
        return this.tires;
    }

    public Engine getEngine () {
        return this.engine;
    }

    public Cargo getCargo () {
        return this.cargo;
    }


}
