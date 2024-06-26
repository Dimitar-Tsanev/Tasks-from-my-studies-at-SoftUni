package onlineShop.models.products.components;

import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;

public abstract class BaseComponent extends BaseProduct implements Component {
    private int generation;

    public BaseComponent ( int id,
                           String manufacturer,
                           String model,
                           double price,
                           double overallPerformance,
                           int generation ) {

        super ( id, manufacturer, model, price, overallPerformance );
        this.setGeneration ( generation );
    }

    private void setGeneration ( int generation ) {
        this.generation = generation;
    }

    @Override
    public int getGeneration () {
        return this.generation;
    }

    @Override
    public String toString () {
        return super.toString () +
                String.format ( OutputMessages.COMPONENT_TO_STRING,
                        this.getGeneration ());
    }
}
