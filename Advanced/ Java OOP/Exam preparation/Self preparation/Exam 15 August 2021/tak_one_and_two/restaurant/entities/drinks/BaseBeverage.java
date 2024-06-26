package restaurant.entities.drinks;

import restaurant.ExceptionThrower;
import restaurant.entities.drinks.interfaces.Beverages;

import static restaurant.common.ExceptionMessages.*;

public class BaseBeverage implements Beverages {
    private String name;
    private int counter;
    private double price;
    private String brand;

    public BaseBeverage ( String name, int counter, double price, String brand ) {
        this.setName ( name );
        this.setCounter ( counter );
        this.setPrice ( price );
        this.setBrand ( brand );
    }

    private void setName ( String name ) {
        ExceptionThrower.throwIfEmptyString ( name,INVALID_NAME );
        this.name = name;
    }

    private void setCounter ( int counter ) {
        ExceptionThrower.throwIfNumberIsLesOrZero ( counter, INVALID_COUNTER );
        this.counter = counter;
    }

    private void setPrice ( double price ) {
        ExceptionThrower.throwIfNumberIsLesOrZero ( price, INVALID_PRICE );
        this.price = price;
    }

    private void setBrand ( String brand ) {
        ExceptionThrower.throwIfEmptyString ( brand, INVALID_BRAND);
        this.brand = brand;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public int getCounter () {
        return this.counter;
    }

    @Override
    public double getPrice () {
        return this.price;
    }

    @Override
    public String getBrand () {
        return this.brand;
    }
 
}
