package shopping_spree;

class Product {
    private String name;
    private double cost;

    public Product ( String name, double cost ) {
        this.setName ( name );
        this.setCost ( cost );
    }

    private void setName ( String name ) {
        if( name.trim ( ).isEmpty ( ) ){
            throw new IllegalArgumentException ( "Name cannot be an empty" );
        }
        this.name = name;
    }

    private void setCost ( double cost ) {
        if (cost < 0.00){
            throw new IllegalArgumentException ( "Cost cannot be a negative" );
        }
        this.cost = cost;
    }

    public String getName () {
        return this.name;
    }

    public double getCost () {
        return this.cost;
    }

    @Override
    public String toString () {
        return getName ();
    }
}
