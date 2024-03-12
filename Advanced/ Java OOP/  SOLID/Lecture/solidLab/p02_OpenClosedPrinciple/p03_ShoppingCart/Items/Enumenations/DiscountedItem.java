package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.Enumenations;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.Special;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.interfaces.Discountable;

public enum DiscountedItem {
    SPECIAL(new Special () );
    private final Discountable discountable;

    DiscountedItem ( Discountable discountable ) {
        this.discountable = discountable;
    }

    public Discountable getDiscountable () {
        return this.discountable;
    }
}
