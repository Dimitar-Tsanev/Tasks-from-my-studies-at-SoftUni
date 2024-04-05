package christmasPastryShop.core;

import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.common.enums.CocktailType;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import static christmasPastryShop.common.ExceptionMessages.*;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;

    private double storeIncome;

    public ControllerImpl ( DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository ) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.storeIncome = 0;
    }

    @Override
    public String addDelicacy ( String type, String name, double price ) {
        Delicacy delicacy = null;
        if ( delicacyRepository.getByName ( name ) != null ) {
            throw new IllegalArgumentException ( String.format ( FOOD_OR_DRINK_EXIST, type, name ) );
        }
        if ( type.equals ( DelicacyType.Gingerbread.toString ( ) ) ) {
            delicacy = new Gingerbread ( name, price );

        } else if ( type.equals ( DelicacyType.Stolen.toString ( ) ) ) {
            delicacy = new Stolen ( name, price );

        }

            this.delicacyRepository.add ( delicacy );

        return String.format ( DELICACY_ADDED, name, type  );
    }

    @Override
    public String addCocktail ( String type, String name, int size, String brand ) {
        Cocktail cocktail = null;
        if ( this.cocktailRepository.getByName ( name ) != null ) {
            throw new IllegalArgumentException ( String.format ( FOOD_OR_DRINK_EXIST, type, name ) );
        }
        if ( type.equals ( CocktailType.Hibernation.toString ( ) ) ) {
            cocktail = new Hibernation ( name, size,brand );

        } else if ( type.equals ( CocktailType.MulledWine.toString ( ) ) ) {
            cocktail = new MulledWine ( name, size,brand );

        }

            this.cocktailRepository.add ( cocktail );

        return String.format ( COCKTAIL_ADDED, name, brand  );
    }

    @Override
    public String addBooth ( String type, int boothNumber, int capacity ) {
        Booth booth = null;
        if ( this.boothRepository.getByNumber ( boothNumber ) != null ) {
            throw new IllegalArgumentException ( String.format ( BOOTH_EXIST,boothNumber ) );
        }
        if ( type.equals ( BoothType.OpenBooth.toString ( ) ) ) {
            booth = new OpenBooth ( boothNumber,capacity );

        } else if ( type.equals ( BoothType.PrivateBooth.toString ( ) ) ) {
            booth = new PrivateBooth ( boothNumber,capacity );

        }
        this.boothRepository.add ( booth );
        return String.format ( BOOTH_ADDED, boothNumber  );
    }

    @Override
    public String reserveBooth ( int numberOfPeople ) {
        Booth searchedBooth = null;
        for ( Booth booth : boothRepository.getAll () ){
            if (booth == null){
                continue;
            }
            if (booth.getCapacity () >= numberOfPeople && !booth.isReserved ()){
                searchedBooth = booth;
                break;
            }
        }
        if (searchedBooth == null){
            return String.format ( RESERVATION_NOT_POSSIBLE, numberOfPeople );
        }

        searchedBooth.reserve ( numberOfPeople );

        return String.format ( BOOTH_RESERVED,
                searchedBooth.getBoothNumber (),
                numberOfPeople );
    }

    @Override
    public String leaveBooth ( int boothNumber ) {
        Booth booth = boothRepository.getByNumber ( boothNumber );

        double bill = booth.getBill ();

        storeIncome += bill;

        return String.format (BILL, booth.getBoothNumber (), bill);
    }

    @Override
    public String getIncome () {
        return String.format ( TOTAL_INCOME, storeIncome ) ;
    }

}
