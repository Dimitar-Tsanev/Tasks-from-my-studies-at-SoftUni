package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.Enumenations.DiscountedItem;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.interfaces.OrderItem;

public class OrderItemImpl extends SupportedItemImpl implements OrderItem {

    private double itemPrice;

    public OrderItemImpl ( String name, int quantity ) {
        super ( name, quantity );
        setItemPrice ();
    }

    private void setItemPrice ( ) {
        this.itemPrice = this.getQuantity () * this.getType ().getSinglePrice ();

        for ( DiscountedItem item: DiscountedItem.values () ){
            if (this.getType ().toString ().equals ( item.toString () )){
                this.itemPrice = this.itemPrice - item.getDiscountable ().discount ( this );
            }
        }
    }

    @Override
    public double getItemPrice (){
        return this.itemPrice;
    }
}
