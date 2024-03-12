package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.interfaces.Discountable;

public class Special implements Discountable {

    public double discount ( OrderItemImpl item ){
        double discount = 0;
        if (item.getQuantity () > 2){
            int sets = item.getQuantity ( ) / 3;
            discount = sets * 0.2;
        }
        return discount;
    }
}
