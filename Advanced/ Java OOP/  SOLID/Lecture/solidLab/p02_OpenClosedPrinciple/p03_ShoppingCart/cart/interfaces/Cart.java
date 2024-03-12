package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.cart.interfaces;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.interfaces.OrderItem;

import java.util.Collection;

public interface Cart {
    Collection<OrderItem> getItems ();
    void addItem ( OrderItem orderItem );
    String removeItem (OrderItem orderItem );
}
