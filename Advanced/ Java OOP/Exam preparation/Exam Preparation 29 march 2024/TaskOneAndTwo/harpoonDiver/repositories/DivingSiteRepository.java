package harpoonDiver.repositories;

import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DivingSiteRepository implements Repository<DivingSite> {
    private Map<String, DivingSite> sites;

    public DivingSiteRepository (  ) {
        this.sites = new LinkedHashMap<> ( );
    }

    @Override
    public Collection<DivingSite> getCollection () {
        return Collections.unmodifiableCollection ( this.sites.values ( ) );
    }

    @Override
    public void add ( DivingSite site ) {
        this.sites.putIfAbsent ( site.getName ( ), site );
    }

    @Override
    public boolean remove ( DivingSite site ) {
        return this.sites.remove ( site.getName ( ), site );
    }

    @Override
    public DivingSite byName ( String name ) {
        return this.sites.get ( name );
    }
}
