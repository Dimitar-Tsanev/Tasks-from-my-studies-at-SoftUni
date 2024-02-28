package greedy_times;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.String.format;

class Bag {
    private static final String TEMPLATE = "<%s> $%s";
    private long capacity;
    private List<Gold> gold;
    private List<Gems> gems;
    private List<Cash> money;

    public Bag ( long capacity ) {
        this.setCapacity ( capacity );
        this.setGold ( );
        this.setGems ( );
        this.setMoney ( );
    }

    private void setCapacity ( long capacity ) {
        this.capacity = capacity;
    }

    private void setGold () {
        this.gold = new ArrayList<> ( );
    }

    private void setGems () {
        this.gems = new ArrayList<> ( );
    }

    private void setMoney () {
        this.money = new ArrayList<> ( );
    }

    private long getTotalValue () {
        return Gold.getTotalAmount ( ) + Gems.getTotalAmount ( ) + Cash.getTotalAmount ( );
    }

    public void addItem ( String name, long amount ) {
        if ( amount + getTotalValue ( ) <= this.capacity ) {

            if ( name.equalsIgnoreCase ( "gold" ) ) {
                Gold goldItem = this.gold.stream ( )
                        .filter ( g -> g.getName ( ).equals ( name ) )
                        .findFirst ( )
                        .orElse ( null );

                if ( goldItem == null ) {
                    this.gold.add ( new Gold ( name, amount ) );

                } else {
                    goldItem.addGold ( amount );

                }

            } else if ( name.toLowerCase ( ).endsWith ( "gem" ) ) {
                if ( Gold.getTotalAmount ( ) >= Gems.getTotalAmount ( ) + amount ) {
                    Gems gem = this.gems.stream ( )
                            .filter ( g -> g.getName ( ).equals ( name ) )
                            .findFirst ( )
                            .orElse ( null );

                    if ( gem == null ) {
                        this.gems.add ( new Gems ( name, amount ) );

                    } else {
                        gem.addGems ( amount );

                    }
                }
            } else if ( name.length ( ) == 3 ) {
                if ( Gems.getTotalAmount ( ) >= Cash.getTotalAmount ( ) + amount ) {
                    Cash moneys = this.money.stream ( )
                            .filter ( g -> g.getName ( ).equals ( name ) )
                            .findFirst ( )
                            .orElse ( null );

                    if ( moneys == null ) {
                        this.money.add ( new Cash ( name, amount ) );

                    } else {
                        moneys.addCash ( amount );

                    }
                }
            }
        }
    }


    @Override
    public String toString () {
        StringBuilder bagContent = new StringBuilder ( );

        if ( !this.gold.isEmpty ( ) ) {
            bagContent.append ( format ( TEMPLATE, "Gold", Gold.getTotalAmount ( ) ) );
            bagContent.append ( System.lineSeparator ( ) );
            this.gold.stream ().sorted ( Comparator.comparing ( Gold::getName ).reversed () ).forEach ( g -> bagContent.append ( g ).append ( System.lineSeparator ( ) ) );
        }
        if ( !this.gems.isEmpty ( ) ) {
            bagContent.append ( format ( TEMPLATE, "Gem", Gems.getTotalAmount ( ) ) );
            bagContent.append ( System.lineSeparator ( ) );
            this.gems.stream ().sorted ( Comparator.comparing ( Gems::getName ).reversed () ).forEach ( g -> bagContent.append ( g ).append ( System.lineSeparator ( ) ) );
        }

        if ( !this.money.isEmpty ( ) ) {
            bagContent.append ( format ( TEMPLATE, "Cash", Cash.getTotalAmount ( ) ) );
            bagContent.append ( System.lineSeparator ( ) );
            this.money.stream ().sorted ( Comparator.comparing ( Cash::getName ).reversed () ).forEach ( g -> bagContent.append ( g ).append ( System.lineSeparator ( ) ) );
        }
        return bagContent.toString();
    }

}

