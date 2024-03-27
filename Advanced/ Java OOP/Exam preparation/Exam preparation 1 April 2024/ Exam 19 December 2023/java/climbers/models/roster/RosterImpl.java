package climbers.models.roster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RosterImpl implements Roster{

    private List<String> peeks;

    public RosterImpl ( ) {
        this.peeks = new ArrayList<> ();
    }

    @Override
    public Collection<String> getPeaks () {
        return this.peeks;
    }
}
