package greedyTimes;

class Gems {
    private static long totalAmount;
    private String name;
    private long amount;

    public Gems ( String name, long amount ) {
        this.setName ( name );
        this.addGems ( amount );
    }

    public String getName () {
        return name;
    }

    private void setName ( String name ) {
        this.name = name;
    }

    public long getAmount () {
        return amount;
    }
    public void addGems ( long amount ) {
        this.amount += amount;
        totalAmount += amount;
    }
    public static long getTotalAmount(){
        return totalAmount;
    }
    @Override
    public String toString () {
        return String.format ( "##%s - %d",getName (),getAmount () );
    }

}
