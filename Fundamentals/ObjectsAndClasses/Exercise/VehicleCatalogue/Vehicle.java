package VehicleCatalogue;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle ( String type, String model, String color, int horsepower ) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getType () {
        return type;
    }

    public String getModel () {
        return model;
    }

    public int getHorsepower () {
        return horsepower;
    }

    public String getInformation () {
        return String.format ( "Type: %s%n" +
                        "Model: %s%n" +
                        "Color: %s%n" +
                        "Horsepower: %d%n",
                type.substring ( 0, 1 ).toUpperCase ( ) + type.substring ( 1 ), model, color, horsepower );
    }
}
