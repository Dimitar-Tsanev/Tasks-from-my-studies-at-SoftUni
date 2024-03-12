package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.orders;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.cart.CartCalculator;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.cart.interfaces.Cart;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.orders.interfaces.Order;

public abstract class OrderImpl implements Order {
    private final Cart cart;
    private final double totalAmount;

    public OrderImpl ( Cart cart ) {
        this.cart = cart;
        this.totalAmount = CartCalculator.calculateTotalAmount( this.cart );
    }
    @Override
    public String getOrderInfo () {
        StringBuilder report = new StringBuilder ();
        this.cart.getItems ()
                .forEach ( i -> report.append ( String.format (
                        "Item: %s Quantity: %d Price: %.2f%n",
                        i.getName (),
                        i.getQuantity (),
                        i.getItemPrice () ) ) );

        report.append ( String.format ("Total %.2f",this.totalAmount  ));

        return report.toString ();
    }
}
