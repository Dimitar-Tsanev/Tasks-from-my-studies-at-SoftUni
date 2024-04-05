package christmasPastryShop.repositories;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.Repository;

public class CocktailRepositoryImpl extends RepositoryImpl<Cocktail> implements CocktailRepository<Cocktail> {
    @Override
    public Cocktail getByName ( String name ) {
        return super.getAll ().stream ()
                .filter ( d -> name.equals (d.getName ()) )
                .findFirst ()
                .orElse ( null );
    }
}
