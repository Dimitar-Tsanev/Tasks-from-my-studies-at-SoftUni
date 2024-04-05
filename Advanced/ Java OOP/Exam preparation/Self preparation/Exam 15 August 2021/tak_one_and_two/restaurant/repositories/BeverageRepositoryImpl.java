package restaurant.repositories;

import restaurant.entities.drinks.BaseBeverage;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    Map<String, Beverages> beverages;

    public BeverageRepositoryImpl () {
        this.beverages = new LinkedHashMap<> ( );
    }

    @Override
    public Collection<Beverages> getAllEntities () {
        return Collections.unmodifiableCollection ( this.beverages.values ( ) );
    }

    @Override
    public void add ( Beverages beverage ) {
        beverages.put ( beverage.getName ( ), beverage );
    }

    @Override
    public Beverages beverageByName ( String drinkName, String drinkBrand ) {
        Beverages beverage = beverages.get ( drinkName );
        if (beverage != null){
            if (drinkBrand.equals ( beverage.getBrand () )){
                return beverage;
            }
        }
        return null;
    }
}
