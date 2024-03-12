package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.interfaces;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.OrderItemImpl;

public interface Discountable {
   double discount ( OrderItemImpl item );
}
