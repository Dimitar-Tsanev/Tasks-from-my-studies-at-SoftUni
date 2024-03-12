package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.orders;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.cart.interfaces.Cart;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.customer.interfaces.OnlineCustomer;

public class OnlineOrderImpl extends OrderImpl {

    private final OnlineCustomer onlineCustomer;

    public OnlineOrderImpl ( Cart cart, OnlineCustomer onlineCustomer ) {
        super ( cart );
        this.onlineCustomer = onlineCustomer;
    }
    @Override
    public String getOrderInfo () {
        String orderReport = super.getOrderInfo ( );

        return String.format ( "Customer: %s %s%n%s",onlineCustomer.getName (),onlineCustomer.getCustomerEmail (),orderReport );
    }
}
