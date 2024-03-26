package climbers.repositories;

import climbers.models.climber.Climber;

import java.util.*;

public class ClimberRepository implements Repository<Climber>{
    private Map<String, Climber> climbers;

    public ClimberRepository (  ) {
        this.climbers = new LinkedHashMap<> (  );
    }

    @Override
    public Collection<Climber> getCollection () {
        return Collections.unmodifiableCollection ( this.climbers.values () );
    }

    @Override
    public void add ( Climber climber ) {
        this.climbers.putIfAbsent ( climber.getName (),climber );
    }

    @Override
    public boolean remove ( Climber climber ) {
        return climbers.remove ( climber.getName (),climber);
    }

    @Override
    public Climber byName ( String name ) {
        return this.climbers.get ( name );
    }
}
