package christmasPastryShop.entities.cocktails;

import christmasPastryShop.ExceptionThrower;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseCocktail implements Cocktail {
    private String name;
    private int size;
    private double price;
    private String brand;

    protected BaseCocktail ( String name, int size, double price, String brand ) {
        this.setName ( name );
        this.setSize ( size );
        this.setPrice ( price );
        this.setBrand ( brand );
    }

    private void setName ( String name ) {
        ExceptionThrower.throwIfEmptyString ( name, INVALID_NAME );
        this.name = name;
    }

    private void setSize ( int size ) {
        ExceptionThrower.throwIfNumberIsLessOrZero ( size,INVALID_SIZE );
        this.size = size;
    }

    private void setPrice ( double price ) {
        ExceptionThrower.throwIfNumberIsLessOrZero ( price, INVALID_PRICE );
        this.price = price;
    }

    private void setBrand ( String brand ) {
        ExceptionThrower.throwIfEmptyString ( brand, INVALID_BRAND );
        this.brand = brand;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public int getSize () {
        return this.size;
    }

    @Override
    public double getPrice () {
        return this.price;
    }

    @Override
    public String getBrand () {
        return this.brand;
    }

    @Override
    public String toString () {
        return String.format ( "%s %s - %dml - %.2flv", this.name,this.brand, this.size, this.price );
    }
}
