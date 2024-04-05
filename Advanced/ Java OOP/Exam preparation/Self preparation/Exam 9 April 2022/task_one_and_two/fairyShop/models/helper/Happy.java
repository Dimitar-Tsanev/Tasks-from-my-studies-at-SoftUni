package fairyShop.models.helper;

import fairyShop.models.helper.BaseHelper;

public class Happy extends BaseHelper {
    private static final int WORK_ENERGY_DROP = 10;
    private static final int ENERGY = 100;
    public Happy ( String name ) {
        super ( name, ENERGY );
    }

    @Override
    protected int getEnergyDrop () {
        return WORK_ENERGY_DROP;
    }
}
