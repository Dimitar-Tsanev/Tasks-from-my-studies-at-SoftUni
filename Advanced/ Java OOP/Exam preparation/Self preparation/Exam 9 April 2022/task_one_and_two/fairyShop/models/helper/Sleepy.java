package fairyShop.models.helper;

import fairyShop.models.helper.BaseHelper;

public class Sleepy extends BaseHelper {
    private static final int WORK_ENERGY_DROP = 15;
    private static final int ENERGY = 50;
    public Sleepy ( String name ) {
        super ( name, ENERGY );
    }

    @Override
    protected int getEnergyDrop () {
        return WORK_ENERGY_DROP;
    }
}
