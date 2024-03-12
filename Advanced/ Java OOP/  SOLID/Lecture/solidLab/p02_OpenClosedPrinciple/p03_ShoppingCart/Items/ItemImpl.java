package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.interfaces.Item;

public class ItemImpl implements Item {
    private String name;
    public ItemImpl ( String name ) {
        this.setName ( name );
    }
    private void setName ( String name ) {
        if(name == null || name.isBlank ()){
            throw new IllegalArgumentException ( "Missing item name!" );
        }
        this.name = name;
    }

    @Override
    public String getName () {
        return this.name;
    }

}
