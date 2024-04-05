package christmasPastryShop.entities.booths;

import christmasPastryShop.ExceptionThrower;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseBooth ( int boothNumber, int capacity, double pricePerPerson ) {
        this.setBoothNumber ( boothNumber );
        this.setCapacity ( capacity );
        this.setPricePerPerson ( pricePerPerson );
        this.setCocktailOrders ();
        this.setDelicacyOrders ();
        this.setReserved ( false );

    }

    private void setCapacity ( int capacity ) {
        ExceptionThrower.throwIfNumberIsNegative ( capacity,INVALID_TABLE_CAPACITY  );
        this.capacity = capacity;
    }

    private void setNumberOfPeople ( int numberOfPeople ) {
        ExceptionThrower.throwIfNumberIsLessOrZero ( numberOfPeople,INVALID_NUMBER_OF_PEOPLE );
        this.numberOfPeople = numberOfPeople;
    }

    private void setDelicacyOrders (  ) {
        this.delicacyOrders = new ArrayList<> ();
    }

    private void setCocktailOrders (  ) {
        this.cocktailOrders = new ArrayList<> (  );
    }

    private void setBoothNumber ( int boothNumber ) {
        this.boothNumber = boothNumber;
    }

    private void setPricePerPerson ( double pricePerPerson ) {
        this.pricePerPerson = pricePerPerson;
    }

    private void setReserved ( boolean reserved ) {
        isReserved = reserved;
    }

    private void setPrice ( double price ) {
        this.price = price;
    }

    @Override
    public int getBoothNumber () {
        return this.boothNumber;
    }

    @Override
    public int getCapacity () {
        return this.capacity;
    }

    @Override
    public boolean isReserved () {
        return this.isReserved;
    }

    @Override
    public double getPrice () {
        return this.price;
    }

    @Override
    public void reserve ( int numberOfPeople ) {
        this.setNumberOfPeople ( numberOfPeople );

        this.setPrice ( this.numberOfPeople * this.pricePerPerson );

        this.setReserved ( true );
    }

    @Override
    public double getBill () {
        double cocktailsPrice = this.cocktailOrders.stream( )
                .mapToDouble (Cocktail::getPrice  ).sum ();

        double delicacyPrice = this.delicacyOrders.stream( )
                .mapToDouble (Delicacy::getPrice  ).sum ();

        return this.price + cocktailsPrice + delicacyPrice;
    }

    @Override
    public void clear () {
        this.setCocktailOrders ();
        this.setDelicacyOrders ();
        this.setPrice ( 0 );
        this.numberOfPeople = 0;
        this.setReserved ( false );
        this.setPricePerPerson ( 0 );

    }
}
