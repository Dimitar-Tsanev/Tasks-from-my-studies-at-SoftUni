package climbers.repositories;

import climbers.models.mountain.Mountain;

import java.util.*;

public class MountainRepository implements Repository<Mountain>{
    private Map<String, Mountain> mountains;

    public MountainRepository (  ) {
        this.mountains = new LinkedHashMap<> (  );
    }

    @Override
    public Collection<Mountain> getCollection () {
        return Collections.unmodifiableCollection ( this.mountains.values () );
    }

    @Override
    public void add ( Mountain mountain ) {
        this.mountains.putIfAbsent ( mountain.getName (), mountain );
    }

    @Override
    public boolean remove ( Mountain mountain ) {
        return mountains.remove ( mountain.getName (),mountain);
    }

    @Override
    public Mountain byName ( String name ) {
        return this.mountains.get ( name );
    }
}
