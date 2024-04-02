package robotService.entities.robot;

import robotService.NullStringChecker;

import static robotService.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot {
    private String name;
    private String kind;
    private int kilograms;
    private double price;

    public BaseRobot ( String name, String kind, int kilograms, double price ) {
        this.setName ( name );
        this.setKind ( kind );
        this.setKilograms ( kilograms );
        this.setPrice ( price );
    }

    private void setKind ( String kind ) {
        NullStringChecker.throwExceptionIfStringNullOrEmpty (
                kind,
                ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY );

        this.kind = kind;
    }

    protected void setKilograms ( int kilograms ) {
        this.kilograms = kilograms;
    }

    private void setPrice ( double price ) {
        if ( price <= 0.00 ) {
            throw new IllegalArgumentException ( ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO );
        }
        this.price = price;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public void setName ( String name ) {
        NullStringChecker.throwExceptionIfStringNullOrEmpty (
                name,
                ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY );
        this.name = name;
    }

    @Override
    public int getKilograms () {
        return this.kilograms;
    }

    @Override
    public double getPrice () {
        return this.price;
    }
}
