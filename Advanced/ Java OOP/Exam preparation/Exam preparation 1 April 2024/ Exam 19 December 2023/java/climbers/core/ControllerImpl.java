package climbers.core;

import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.Climbing;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;
import climbers.repositories.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static climbers.common.ConstantMessages.*;
import static climbers.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Climber> climberRepository;
    private Repository<Mountain> mountainRepository;
    private int climbedMountainsCount;

    public ControllerImpl () {
        this.climberRepository = new ClimberRepository ( );
        this.mountainRepository = new MountainRepository ( );
        this.climbedMountainsCount = 0;
    }

    @Override
    public String addClimber ( String type, String climberName ) {
        Climber climber;

        switch (type) {
            case "RockClimber":
                climber = new RockClimber ( climberName );
                break;
            case "WallClimber":
                climber = new WallClimber ( climberName );
                break;
            default:
                throw new IllegalArgumentException ( CLIMBER_INVALID_TYPE );
        }
        this.climberRepository.add ( climber );

        return String.format ( CLIMBER_ADDED, type, climberName );
    }

    @Override
    public String addMountain ( String mountainName, String... peaks ) {
        Mountain mountain = new MountainImpl ( mountainName );
        Arrays.stream ( peaks ).forEach ( p -> mountain.getPeaksList ( ).add ( p ) );
        this.mountainRepository.add ( mountain );

        return String.format ( MOUNTAIN_ADDED, mountainName );
    }

    @Override
    public String removeClimber ( String climberName ) {
        Climber climber = this.climberRepository.byName ( climberName );
        if ( climber == null || !this.climberRepository.remove ( climber ) ) {
            throw new IllegalArgumentException ( String.format ( CLIMBER_DOES_NOT_EXIST, climberName ) );
        }

        return String.format ( CLIMBER_REMOVE, climberName );
    }

    @Override
    public String startClimbing ( String mountainName ) {
        if ( climberRepository.getCollection ( ).isEmpty ( ) ) {
            throw new IllegalArgumentException ( THERE_ARE_NO_CLIMBERS );

        }
        Climbing climbing = new ClimbingImpl ( );

        climbing.conqueringPeaks (
                mountainRepository.byName ( mountainName ),
                climberRepository.getCollection ( ) );

        long excludedClimbers = climberRepository.getCollection ( )
                .stream ( )
                .filter ( c -> c.getStrength ( ) <= 0 )
                .mapToDouble ( Climber::getStrength )
                .count ( );

        climbedMountainsCount++;

        return String.format ( PEAK_CLIMBING, mountainName, excludedClimbers );
    }

    @Override
    public String getStatistics () {
        StringBuilder statistic = new StringBuilder ( );
        statistic.append (
                        String.format ( FINAL_MOUNTAIN_COUNT, climbedMountainsCount ) )
                .append ( System.lineSeparator ( ) );

        statistic.append ( FINAL_CLIMBERS_STATISTICS )
                .append ( System.lineSeparator ( ) );

        for ( Climber climber : climberRepository.getCollection ( ) ) {

            statistic.append ( String.format ( FINAL_CLIMBER_NAME, climber.getName ( ) ) )
                    .append ( System.lineSeparator ( ) );

            statistic.append ( String.format ( FINAL_CLIMBER_STRENGTH, climber.getStrength ( ) ) )
                    .append ( System.lineSeparator ( ) );

            String peeks = climber.getRoster ( ).getPeaks ( ).isEmpty ( ) ?
                    "None" :
                    climber.getRoster ( )
                            .getPeaks ( ).stream ( ).collect ( Collectors.joining ( FINAL_CLIMBER_FINDINGS_DELIMITER ) );

            statistic.append ( String.format ( FINAL_CLIMBER_PEAKS, peeks ) ).append ( System.lineSeparator ( ) );
        }
        return statistic.toString ( ).trim ( );
    }
}
