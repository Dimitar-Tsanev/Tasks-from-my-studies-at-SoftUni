package fairyShop.models.present;

import fairyShop.ExceptionThrower;

import static fairyShop.common.ExceptionMessages.*;

public class PresentImpl implements Present {
    private static final int ENERGY_REQUIRED_DROP = 10;
    private String name;
    private int energyRequired;

    public PresentImpl ( String name, int energyRequired ) {
        this.setName ( name );
        this.setEnergyRequired ( energyRequired );
    }

    private void setName ( String name ) {
        ExceptionThrower.throwIfEmptyString ( name, PRESENT_NAME_NULL_OR_EMPTY );
        this.name = name;
    }

    private void setEnergyRequired ( int energyRequired ) {
        ExceptionThrower.throwIfNumberIsNegative ( energyRequired,PRESENT_ENERGY_LESS_THAN_ZERO );
        this.energyRequired = energyRequired;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public int getEnergyRequired () {
        return this.energyRequired;
    }

    @Override
    public boolean isDone () {
        return 0 == energyRequired;
    }

    @Override
    public void getCrafted () {
        this.setEnergyRequired ( Math.max ( 0, this.energyRequired - ENERGY_REQUIRED_DROP ) );
    }
}
