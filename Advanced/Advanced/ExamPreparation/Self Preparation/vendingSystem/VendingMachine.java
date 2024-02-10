package vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine ( int buttonCapacity ) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<> ( );

    }

    public int getCount () {
        return drinks.size ( );
    }

    public void addDrink ( Drink drink ) {
        if ( buttonCapacity > this.drinks.size ( ) ) {
            this.drinks.add ( drink );
        }
    }
    public boolean removeDrink ( String name ) {
        Drink drink = this.drinks.stream ( )
                .filter ( d -> d.getName ( ).equals ( name ) )
                .findFirst ( )
                .orElse ( null );

        return drink != null && this.drinks.remove ( drink );
    }
    public Drink getLongest(){
        return drinks.stream( )
                .max ( Comparator.comparing ( Drink::getVolume ) )
                .orElse ( null );
    }
    public Drink getCheapest(){
     return drinks.stream ()
             .min ( Comparator.comparing ( Drink::getPrice ))
             .orElse ( null );
    }
    public String buyDrink(String name){
        return drinks.stream ()
                .filter ( d-> d.getName ().equals ( name ) )
                .findFirst ()
                .orElse ( null)
                .toString ();
    }
    public String report(){
        String string = "Drinks available:";
        StringBuilder drinksReport = new StringBuilder (  );
        drinksReport.append ( System.lineSeparator () );
        drinks.forEach ( d->{
            drinksReport.append ( d );
            drinksReport.append ( System.lineSeparator () );
        } );
        return string + drinksReport;
    }
}
