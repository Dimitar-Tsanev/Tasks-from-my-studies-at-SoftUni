package harpoonDiver.models.divingSite;

import harpoonDiver.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public class DivingSiteImpl implements DivingSite{
    private String name;
    private Collection<String> seaCreatures;

    public DivingSiteImpl ( String name ) {
        this.setName ( name );
        this.setSeaCreatures ();
    }

    private void setName ( String name ) {
        if (null == name || name.trim ().isEmpty () ){
            throw new NullPointerException ( ExceptionMessages.SITE_NAME_NULL_OR_EMPTY );
        }
        this.name = name;
    }

    private void setSeaCreatures (  ) {
        this.seaCreatures = new ArrayList<> ();
    }

    @Override
    public Collection<String> getSeaCreatures () {
        return this.seaCreatures;
    }

    @Override
    public String getName () {
        return this.name;
    }
}
