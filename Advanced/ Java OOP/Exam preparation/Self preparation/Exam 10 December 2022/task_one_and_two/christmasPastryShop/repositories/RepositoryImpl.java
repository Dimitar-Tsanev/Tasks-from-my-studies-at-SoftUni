package christmasPastryShop.repositories;

import christmasPastryShop.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class RepositoryImpl<T> implements Repository<T> {
    private Collection<T> models;

    public RepositoryImpl ( ) {
        this.models = new ArrayList<> ();
    }

    @Override
    public Collection<T> getAll () {
        return Collections.unmodifiableCollection ( models );
    }

    @Override
    public void add ( T entity ) {
        this.models.add ( entity );
    }
}
