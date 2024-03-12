package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.Enumenations.ItemTypes;
import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.interfaces.SupportedItem;

public class SupportedItemImpl extends ItemImpl implements SupportedItem {
    private int quantity;
    private ItemTypes type;

    public SupportedItemImpl ( String name, int quantity ) {
        super ( name );
        setQuantity ( quantity );
        setType ();
    }
    private void setQuantity ( int quantity ) {
        if (quantity < 1){
            throw new IllegalArgumentException ( "Item quantity must be positive number!" );
        }
        this.quantity = quantity;
    }
    private void setType (  ) {
        boolean supportedType = false;
        for (ItemTypes enuM: ItemTypes.values () ){
            if (this.getName ().toUpperCase ().contains ( enuM.toString () ) ){
                this.type = enuM;
                supportedType = true;
                break;
            }
        }
        if (!supportedType){
            throw new IllegalArgumentException ( "Unsupported item type!" );
        }
    }
    protected ItemTypes getType () {
        return this.type;
    }
    @Override
    public int getQuantity () {
        return this.quantity;
    }
}
