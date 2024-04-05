package christmasPastryShop.repositories;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

public class BoothRepositoryImpl extends RepositoryImpl<Booth> implements BoothRepository<Booth> {
    @Override
    public Booth getByNumber ( int number ) {
        return super.getAll ().stream ()
                .filter ( d -> number == d.getBoothNumber () )
                .findFirst ()
                .orElse ( null );

    }
}
