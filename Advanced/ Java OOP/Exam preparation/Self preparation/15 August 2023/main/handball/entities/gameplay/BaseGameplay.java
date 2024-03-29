package handball.entities.gameplay;

import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static handball.common.ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY;

public abstract class BaseGameplay implements Gameplay {
    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    public BaseGameplay ( String name, int capacity ) {
        this.setName ( name );
        this.capacity = capacity;
        this.equipments = new ArrayList<> ( );
        this.teams = new ArrayList<> ( );
    }

    private void setName ( String name ) {
        if ( name == null || name.trim ( ).isEmpty ( ) ) {
            throw new NullPointerException ( GAMEPLAY_NAME_NULL_OR_EMPTY );
        }
        this.name = name;
    }

    @Override
    public int allProtection () {
        return this.equipments.stream ( ).mapToInt ( Equipment::getProtection ).sum ( );
    }

    @Override
    public void addTeam ( Team team ) {
        this.teams.add ( team );
    }

    @Override
    public void removeTeam ( Team team ) {
        this.teams.remove ( team );
    }

    @Override
    public void addEquipment ( Equipment equipment ) {
        this.equipments.add ( equipment );
    }

    @Override
    public void teamsInGameplay () {
        for ( Team team : teams ) {
            team.play ( );
        }
    }

    @Override
    public Collection<Team> getTeam () {
        return Collections.unmodifiableCollection ( teams );
    }

    @Override
    public Collection<Equipment> getEquipments () {
        return Collections.unmodifiableCollection ( equipments );
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public String toString () {
        StringBuilder information = new StringBuilder ( );
        information.append (
                        String.format ( "%s %s", this.name, this.getClass ( ).getSimpleName ( ) ) )
                .append ( System.lineSeparator ( ) );

        String teamInformation = teams.isEmpty ( ) ?
                "none" :
                this.teams.stream ( ).map ( Team::getName ).collect ( Collectors.joining ( " " ) );

        information.append ( String.format ( "Team: %s", teamInformation ) )
                .append ( System.lineSeparator ( ) );

        information.append (
                        String.format ( "Equipment: %d, Protection: %d",
                                equipments.size ( ),
                                this.allProtection ( ) ) )
                .append ( System.lineSeparator ( ) );

        return information.toString ( );
    }
}
