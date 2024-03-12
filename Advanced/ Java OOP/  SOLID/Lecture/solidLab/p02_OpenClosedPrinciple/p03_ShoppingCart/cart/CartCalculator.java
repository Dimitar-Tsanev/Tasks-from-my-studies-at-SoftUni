package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.cart;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.interfaces.OrderItem;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.cart.interfaces.Cart;

public class CartCalculator {
    private CartCalculator () {
    }
    public static double calculateTotalAmount( Cart cart){
        double total = 0;

        for ( OrderItem item : cart.getItems () ) {
            total += item.getItemPrice ();
        }
        return total;
    }
}
