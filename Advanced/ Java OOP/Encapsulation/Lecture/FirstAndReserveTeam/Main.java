package FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfPlayers = Integer.parseInt ( scanner.nextLine () );

        List<Person> players = new ArrayList<> ();

        for ( int i = 0 ; i < numberOfPlayers ; i++ ) {
            String[] input = scanner.nextLine ().split ( "\\s+" );
            try {
                players.add ( new Person ( input[0], input[1], Integer.parseInt ( input[2] ), Double.parseDouble ( input[3] ) ) );

            }catch (IllegalArgumentException e){
                System.out.println ( e.getMessage () );
            }
        }

        Team team = new Team ( "Black eagles" );

        for ( Person player: players ){
            team.addPlayer ( player );

        }
        System.out.println ( "First team have " + team.getFirstTeam ().size () + " players" );
        System.out.println ( "Reserve  team have " + team.getReserveTeam ().size () + " players");
    }
}
