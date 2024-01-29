package GoogleTask7;

class Car {
    private String model;
    private int speed;

    public Car ( String model, int speed ) {
        this.model = model;
        this.speed = speed;
    }
    @Override
    public String toString () {
        return String.format ( "%s %d%n", this.model,this.speed);
    }
}
