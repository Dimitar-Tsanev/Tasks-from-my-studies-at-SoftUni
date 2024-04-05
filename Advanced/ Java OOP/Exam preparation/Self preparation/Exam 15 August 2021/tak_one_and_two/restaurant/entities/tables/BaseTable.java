package restaurant.entities.tables;

import restaurant.ExceptionThrower;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private static final String TEMPLATE = "Table - %d%nSize - %d%nType - %s%nAll price - %f";
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable ( int number, int size, double pricePerPerson ) {
        this.number = number;
        this.setSize ( size );
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new ArrayList<> ( );
        this.beverages = new ArrayList<> ( );

    }

    private void setSize ( int size ) {
        ExceptionThrower.throwIfNumberIsLesOrZero ( size, INVALID_TABLE_SIZE );
        this.size = size;
    }

    private void setNumberOfPeople ( int numberOfPeople ) {
        ExceptionThrower.throwIfNumberIsLesOrZero ( numberOfPeople, INVALID_NUMBER_OF_PEOPLE );
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber () {
        return this.number;
    }

    @Override
    public int getSize () {
        return this.size;
    }

    @Override
    public int numberOfPeople () {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson () {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable () {
        return this.isReservedTable;
    }

    @Override
    public double allPeople () {
        return this.allPeople;
    }

    @Override
    public void reserve ( int numberOfPeople ) {
        this.setNumberOfPeople ( numberOfPeople );
        this.allPeople = this.pricePerPerson * this.pricePerPerson;

        this.isReservedTable = true;

    }

    @Override
    public void orderHealthy ( HealthyFood food ) {
        this.healthyFood.add ( food );
    }

    @Override
    public void orderBeverages ( Beverages beverages ) {
        this.beverages.add ( beverages );
    }

    @Override
    public double bill () {
        double beveragesPrice = this.beverages.stream ( ).mapToDouble ( Beverages::getPrice ).sum ( );
        double foodPrice = this.healthyFood.stream ( ).mapToDouble ( HealthyFood::getPrice ).sum ( );

        return this.allPeople + beveragesPrice + foodPrice;
    }

    @Override
    public void clear () {
        this.beverages.clear ( );
        this.healthyFood.clear ( );
        this.numberOfPeople = 0;
        this.isReservedTable = false;
        this.allPeople = 0.00;

    }

    @Override
    public String tableInformation () {
        return String.format ( TEMPLATE, this.number, this.size, this.getClass ( ).getSimpleName ( ), this.allPeople );
    }
}
