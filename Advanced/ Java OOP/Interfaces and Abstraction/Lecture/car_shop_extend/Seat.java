package car_shop_extend;

class Seat extends CarImpl implements Sellable{
    private Double price;

    public Seat ( String model,
                  String color,
                  Integer horsePower,
                  String countryOfProduced,
                  Double price ) {

        super ( model, color, horsePower, countryOfProduced );
        this.setPrice ( price );
    }

    public void setPrice ( Double price ) {
        this.price = price;
    }

    @Override
    public Double getPrice () {
        return this.price;
    }

    @Override
    public String toString () {
        return super.toString () +
                System.lineSeparator () +
                String.format ( "%s sells for %f", this.getModel (), this.getPrice () );
    }
}
