package handball.core;

import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static handball.common.ConstantMessages.*;
import static handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository equipmentRepository;
    private Collection<Gameplay> gameplays;

    public ControllerImpl () {
        this.equipmentRepository = new EquipmentRepository ( );
        this.gameplays = new ArrayList<> ( );
    }

    @Override
    public String addGameplay ( String gameplayType, String gameplayName ) {
        Gameplay gameplay;
        switch (gameplayType) {
            case "Outdoor":
                gameplay = new Outdoor ( gameplayName );
                break;
            case "Indoor":
                gameplay = new Indoor ( gameplayName );
                break;
            default:
                throw new NullPointerException ( INVALID_GAMEPLAY_TYPE );
        }
        gameplays.add ( gameplay );
        return String.format ( SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType );
    }

    @Override
    public String addEquipment ( String equipmentType ) {
        Equipment equipment;
        switch (equipmentType) {
            case "ElbowPad":
                equipment = new ElbowPad ( );
                break;
            case "Kneepad":
                equipment = new Kneepad ( );
                break;
            default:
                throw new IllegalArgumentException ( INVALID_EQUIPMENT_TYPE );
        }
        this.equipmentRepository.add ( equipment );
        return String.format ( SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType );
    }

    @Override
    public String equipmentRequirement ( String gameplayName, String equipmentType ) {
        Equipment searchedEquipment = this.equipmentRepository.findByType ( equipmentType );
        if ( searchedEquipment == null ) {
            throw new IllegalArgumentException ( String.format ( NO_EQUIPMENT_FOUND, equipmentType ) );
        }
        this.equipmentRepository.remove ( searchedEquipment );
        Gameplay gameplay = gameplays.stream ( )
                .filter ( g -> g.getName ( ).equals ( gameplayName ) )
                .findFirst ( )
                .orElse ( null );

        gameplay.addEquipment ( searchedEquipment );

        return String.format ( SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName );
    }

    @Override
    public String addTeam ( String gameplayName, String teamType, String teamName, String country, int advantage ) {
        Team team;
        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria ( teamName, country, advantage );
                break;
            case "Germany":
                team = new Germany ( teamName, country, advantage );
                break;
            default:
                throw new IllegalArgumentException ( INVALID_TEAM_TYPE );
        }

        Gameplay gameplay = gameplays.stream ( )
                .filter ( g -> g.getName ( ).equals ( gameplayName ) )
                .findFirst ( )
                .orElse ( null );

        if ( team instanceof Bulgaria && gameplay instanceof Outdoor ) {
            gameplay.addTeam ( team );

        } else if ( team instanceof Germany && gameplay instanceof Indoor ) {
            gameplay.addTeam ( team );

        } else {
            return GAMEPLAY_NOT_SUITABLE;

        }
        return String.format ( SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName );
    }

    @Override
    public String playInGameplay ( String gameplayName ) {
        Gameplay gameplay = gameplays.stream ( )
                .filter ( g -> g.getName ( ).equals ( gameplayName ) )
                .findFirst ( )
                .orElse ( null );

        gameplay.teamsInGameplay ( );

        return String.format ( TEAMS_PLAYED, gameplay.getTeam ( ).size ( ) );
    }

    @Override
    public String percentAdvantage ( String gameplayName ) {
        Gameplay gameplay = gameplays.stream ( )
                .filter ( g -> g.getName ( ).equals ( gameplayName ) )
                .findFirst ( )
                .orElse ( null );

        long sumAdvantage = gameplay.getTeam ( ).stream ( ).mapToInt ( Team::getAdvantage ).sum ( );

        return String.format ( ADVANTAGE_GAMEPLAY, gameplayName, sumAdvantage );
    }

    @Override
    public String getStatistics () {
        StringBuilder statistic = new StringBuilder ( );
        gameplays.forEach ( g -> statistic.append ( g.toString ( ) ) );
        return statistic.toString ( ).trim ( );
    }
}
