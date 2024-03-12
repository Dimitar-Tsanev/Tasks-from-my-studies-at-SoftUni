package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.cart;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.interfaces.OrderItem;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.cart.interfaces.Cart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CartImpl implements Cart {
    private final List<OrderItem> items;
    public CartImpl () {
        this.items = new ArrayList<> ( );
    }
    @Override
    public Collection<OrderItem> getItems () {
        return Collections.unmodifiableCollection ( this.items );
    }
    @Override
    public void addItem ( OrderItem orderItem ) {
        this.items.add ( orderItem );

    }
    @Override
    public String removeItem (OrderItem orderItem ){
       boolean remove = this.items.removeIf ( i-> i.getName ().equals ( orderItem.getName ()) && i.getQuantity () == orderItem.getQuantity ()  );

       return remove? "Item was successfully removed!" : "Item not found!";
    }
}
