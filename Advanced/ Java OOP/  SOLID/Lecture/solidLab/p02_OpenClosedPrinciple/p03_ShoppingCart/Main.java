package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.OrderItemImpl;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.interfaces.OrderItem;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.cart.CartImpl;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.cart.interfaces.Cart;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.customer.OnlineCustomerImpl;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.customer.interfaces.OnlineCustomer;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.orders.OnlineOrderImpl;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.orders.interfaces.Order;

public class Main {
    public static void main ( String[] args ) {
        OnlineCustomer onlineCustomer = new OnlineCustomerImpl ( "some name", "some@mail.what" );

        Cart cart = new CartImpl ( );

        OrderItem item1 = new OrderItemImpl ( "EACH_shoes", 5 );
        OrderItem item2 = new OrderItemImpl ( "WEIGHT_chees",500 );
        OrderItem item3 = new OrderItemImpl ( "SPECIAL_bubble_gum", 5 );

        cart.addItem ( item1 );
        cart.addItem ( item2 );
        cart.addItem ( item3 );

        Order order = new OnlineOrderImpl ( cart,onlineCustomer);
        System.out.println ( order.getOrderInfo () );

        System.out.println ( cart.removeItem ( item2 ));

        Order order1 = new OnlineOrderImpl ( cart,onlineCustomer );

        System.out.println ( order1.getOrderInfo () );

    }
}
