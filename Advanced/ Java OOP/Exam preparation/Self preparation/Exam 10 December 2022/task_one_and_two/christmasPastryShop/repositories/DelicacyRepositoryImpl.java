package christmasPastryShop.repositories;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class DelicacyRepositoryImpl extends RepositoryImpl<Delicacy> implements DelicacyRepository<Delicacy> {
    @Override
    public Delicacy getByName ( String name ) {
        return super.getAll ().stream ()
                .filter ( d -> name.equals (d.getName ()) )
                .findFirst ()
                .orElse ( null );
    }
}
