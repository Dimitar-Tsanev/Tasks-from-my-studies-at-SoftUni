package restaurant.entities.healthyFoods;

import restaurant.ExceptionThrower;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import static restaurant.common.ExceptionMessages.*;

public abstract class Food implements HealthyFood {
    private String name;
    private double portion;
    private double price;

    public Food ( String name, double portion, double price ) {
        this.setName ( name );
        this.setPortion ( portion );
        this.setPrice ( price );
    }

    private void setName ( String name ) {
        ExceptionThrower.throwIfEmptyString ( name, INVALID_NAME );
        this.name = name;
    }

    private void setPortion ( double portion ) {
        ExceptionThrower.throwIfNumberIsLesOrZero ( portion, INVALID_PORTION );
        this.portion = portion;
    }

    private void setPrice ( double price ) {
        ExceptionThrower.throwIfNumberIsLesOrZero ( price, INVALID_PRICE );
        this.price = price;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public double getPortion () {
        return this.portion;
    }

    @Override
    public double getPrice () {
        return this.price;
    }
}
