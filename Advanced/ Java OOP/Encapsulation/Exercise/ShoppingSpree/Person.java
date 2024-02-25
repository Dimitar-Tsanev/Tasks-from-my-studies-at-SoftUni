package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person ( String name, double money ) {
        this.setName ( name );
        this.setMoney ( money );
        this.products = new ArrayList<> ();
    }
    private void setName ( String name ) {
        if( name.trim ( ).isEmpty ( ) ){
            throw new IllegalArgumentException ( "Name cannot be an empty" );
        }
        this.name = name;
    }
    private void setMoney ( double money ) {
        if (money < 0.00){
            throw new IllegalArgumentException ( "Money cannot be a negative" );
        }
        this.money = money;
    }

    public String getName () {
        return name;
    }
    public void buyProduct ( Product product){
        if (this.money < product.getCost ()){
            throw new IllegalArgumentException ( String.format ( "%s can't afford %s", getName (),product.getName ()));
        }
        setMoney ( this.money - product.getCost ( ) );
        this.products.add ( product );
    }

    @Override
    public String toString () {
        StringBuilder report = new StringBuilder ();
        report.append ( getName () ).append ( " - " );

        if (this.products.isEmpty ()){
            return report + "Nothing bought";
        }

        report.append ( products.toString ().replaceAll ( "[\\[\\]]", "" ));

        return report.toString ();
    }
}
