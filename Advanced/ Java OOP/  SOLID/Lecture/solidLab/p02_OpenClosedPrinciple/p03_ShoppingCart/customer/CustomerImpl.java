package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.customer;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.customer.interfaces.Customer;

public abstract class CustomerImpl implements Customer {
    private String name;

    public CustomerImpl ( String name ) {
        this.setName ( name );
    }

    public void setName ( String name ) {
        if (name == null || name.isBlank ()){
            throw new IllegalArgumentException ( "Empty name!" );
        }
        this.name = name;
    }

    @Override
    public String getName (){
        return this.name;
    }
}
