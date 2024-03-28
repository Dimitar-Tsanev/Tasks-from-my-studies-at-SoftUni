package harpoonDiver.repositories;

import harpoonDiver.models.diver.Diver;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiverRepository implements Repository<Diver> {
    private Map<String,Diver> divers;

    @Override
    public Collection<Diver> getCollection () {
        return Collections.unmodifiableCollection ( this.divers.values ());
    }

    @Override
    public void add ( Diver diver ) {
        if (divers == null){
            this.divers = new LinkedHashMap<> (  );

        }
        divers.putIfAbsent ( diver.getName (), diver );
    }

    @Override
    public boolean remove ( Diver diver ) {
        return this.divers.remove ( diver.getName (),diver );
    }

    @Override
    public Diver byName ( String name ) {
        return this.divers.get ( name );
    }
}
