package vehicleShop.models.vehicle;

import vehicleShop.common.ExceptionThrower;

import static vehicleShop.common.ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY;
import static vehicleShop.common.ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO;

public class VehicleImpl implements Vehicle{
    private static final int REQUIRED_STRENGTH_DROP = 5;
    private String name;
    private int strengthRequired;

    public VehicleImpl ( String name, int strengthRequired ) {
        this.setName ( name );
        this.setStrengthRequired ( strengthRequired );
    }

    private void setName ( String name ) {
        ExceptionThrower.throwIfEmptyString ( name,VEHICLE_NAME_NULL_OR_EMPTY );
        this.name = name;
    }

    private void setStrengthRequired ( int strengthRequired ) {
        ExceptionThrower.throwIfNumberIsNegative ( strengthRequired, VEHICLE_STRENGTH_LESS_THAN_ZERO );
        this.strengthRequired = strengthRequired;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public int getStrengthRequired () {
        return this.strengthRequired;
    }

    @Override
    public boolean reached () {
        return this.strengthRequired == 0;
    }

    @Override
    public void making () {
        setStrengthRequired ( Math.max ( 0, this.strengthRequired - REQUIRED_STRENGTH_DROP  ) );
    }
}
