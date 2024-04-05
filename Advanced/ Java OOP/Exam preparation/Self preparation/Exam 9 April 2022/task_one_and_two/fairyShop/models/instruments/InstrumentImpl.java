package fairyShop.models.instruments;

import fairyShop.ExceptionThrower;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument{
    private static final int POWER_DROP = 10;
    private int power;

    public InstrumentImpl ( int power ) {
        this.setPower ( power );
    }

    private void setPower ( int power ) {
        ExceptionThrower.throwIfNumberIsNegative ( power, INSTRUMENT_POWER_LESS_THAN_ZERO );
        this.power = power;
    }

    @Override
    public int getPower () {
        return this.power;
    }

    @Override
    public void use () {
        this.setPower ( Math.max ( 0, this.power - POWER_DROP ) );
    }

    @Override
    public boolean isBroken () {
        return 0 == this.power;
    }
}
