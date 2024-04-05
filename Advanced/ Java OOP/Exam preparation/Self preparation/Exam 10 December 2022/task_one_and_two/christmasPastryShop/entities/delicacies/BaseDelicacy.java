package christmasPastryShop.entities.delicacies;

import christmasPastryShop.ExceptionThrower;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseDelicacy implements Delicacy {
    private String name;
    private double portion;
    private double price;

    protected BaseDelicacy ( String name, double portion, double price ) {
        this.setName ( name );
        this.setPortion ( portion );
        this.setPrice ( price );
    }

    private void setName ( String name ) {
        ExceptionThrower.throwIfEmptyString ( name, INVALID_NAME );
        this.name = name;
    }

    private void setPortion ( double portion ) {
        ExceptionThrower.throwIfNumberIsLessOrZero ( portion,INVALID_PORTION );
        this.portion = portion;
    }

    private void setPrice ( double price ) {
        ExceptionThrower.throwIfNumberIsLessOrZero ( price ,INVALID_PRICE );
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

    @Override
    public String toString () {
        return String.format ( "%s: %.2fg - %.2f", this.name, this.portion, this.price );
    }
}
