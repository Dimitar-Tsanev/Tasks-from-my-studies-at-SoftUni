package car_shop_extend;

import java.io.Serializable;

class CarImpl implements Car, Serializable {
    private String model;
    private String color;
    private int horsePower;
    private String countryOfProduced;

    public CarImpl ( String model, String color, Integer horsePower, String countryOfProduced ) {
        this.setModel ( model );
        this.setColor ( color );
        this.setHorsePower ( horsePower );
        this.setCountryOfProduced ( countryOfProduced );

    }
    private void setModel ( String model ) {
        this.model = model;
    }
    private void setColor ( String color ) {
        this.color = color;
    }
    private void setHorsePower ( int horsePower ) {
        this.horsePower = horsePower;
    }
    private void setCountryOfProduced ( String countryOfProduced ) {
        this.countryOfProduced = countryOfProduced;
    }

    @Override
    public String getModel () {
        return this.model;
    }

    @Override
    public String getColor () {
        return this.color;
    }

    @Override
    public Integer getHorsePower () {
        return this.horsePower;
    }

    @Override
    public String countryProduced () {
        return this.countryOfProduced;
    }
    @Override
    public String toString(){
        return String.format (
                "This is %s produced in %s and have %d tires",
                getModel (),
                countryProduced (),
                Car.TIRES);
    }
}
