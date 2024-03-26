package climbers.models.climbing;

import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class ClimbingImpl implements Climbing {
    @Override
    public void conqueringPeaks ( Mountain mountain, Collection<Climber> climbers ) {
        Deque<String> peeks = new ArrayDeque<> ( );
        mountain.getPeaksList ( ).forEach ( peeks::offer );

        for ( Climber climber : climbers ) {
            while (climber.canClimb ( ) && !peeks.isEmpty ( )) {
                String peek = peeks.poll ( );

                climber.climb ( );
                climber.getRoster ( ).getPeaks ( ).add ( peek );
            }

        }
    }
}
