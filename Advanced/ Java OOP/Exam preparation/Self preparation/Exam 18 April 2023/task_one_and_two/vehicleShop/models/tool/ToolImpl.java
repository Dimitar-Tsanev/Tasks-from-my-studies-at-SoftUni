package vehicleShop.models.tool;

import vehicleShop.common.ExceptionThrower;

import static vehicleShop.common.ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO;

public class ToolImpl implements Tool{
    private static final int POWER_DROP = 5;
    private int power;

    public ToolImpl ( int power ) {
        this.setPower ( power );
    }

    private void setPower ( int power ) {
        ExceptionThrower.throwIfNumberIsNegative ( power, TOOL_POWER_LESS_THAN_ZERO );
        this.power = power;
    }

    @Override
    public int getPower () {
        return this.power;
    }

    @Override
    public void decreasesPower () {
        this.setPower ( Math.max ( 0, this.power - POWER_DROP ) );
    }

    @Override
    public boolean isUnfit () {
        return this.power == 0;
    }
}
