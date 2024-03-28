package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class DivingImpl implements Diving{

    @Override
    public void searching ( DivingSite divingSite, Collection<Diver> divers ) {
        Collection<String> seaCreatures = divingSite.getSeaCreatures();

        for ( Diver diver: divers ){
            while (diver.canDive () &&  seaCreatures.iterator().hasNext()) {
                String currentSeaCreature = seaCreatures.iterator().next();

                diver.shoot();
                diver.getSeaCatch().getSeaCreatures().add(currentSeaCreature);

                seaCreatures.remove(currentSeaCreature);
            }
        }
    }
}