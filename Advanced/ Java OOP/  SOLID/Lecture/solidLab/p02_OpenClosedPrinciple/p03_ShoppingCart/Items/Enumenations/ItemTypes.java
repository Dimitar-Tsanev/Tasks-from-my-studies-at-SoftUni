package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.Items.Enumenations;

public enum ItemTypes {
    EACH(5.0), WEIGHT(0.004), SPECIAL(0.4);

    private final double price;

    ItemTypes ( double price ) {
        this.price = price;
    }

    public double getSinglePrice () {
        return price;
    }
}
