package car_shop_extend;

class Audi extends CarImpl implements Rentable{
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi ( String model,
                  String color,
                  Integer horsePower,
                  String countryOfProduced,
                  Integer minRentDay,
                  Double pricePerDay ) {

        super ( model, color, horsePower, countryOfProduced );
        this.setMinRentDay ( minRentDay );
        this.setPricePerDay ( pricePerDay );
    }

    public void setMinRentDay ( Integer minRentDay ) {
        this.minRentDay = minRentDay;
    }

    public void setPricePerDay ( Double pricePerDay ) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay () {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay () {
        return this.pricePerDay;
    }

    @Override
    public String toString () {
        return super.toString () +
                System.lineSeparator () +
                String.format (
                        "Minimum rental period of %d days. Price per day %f",
                        this.getMinRentDay (),
                        this.getPricePerDay () );
    }
}
