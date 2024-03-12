package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.customer;

import solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.customer.interfaces.OnlineCustomer;

public class OnlineCustomerImpl extends CustomerImpl implements OnlineCustomer {
    public String customerEmail;

    public OnlineCustomerImpl ( String name,String customerEmail  ) {
        super ( name );
        setCustomerEmail ( customerEmail );
    }
    public void setCustomerEmail ( String customerEmail ) {
        if (customerEmail == null || customerEmail.isBlank ()){
            throw new IllegalArgumentException ( "Empty email!" );
        }
        this.customerEmail = customerEmail;
    }
    @Override
    public String getCustomerEmail () {
        return this.customerEmail;
    }

    @Override
    public String getName () {
        return super.getName ();
    }
}
