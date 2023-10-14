import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int guestsNumber = Integer.parseInt ( scan.nextLine () );

        List<String> guests = new ArrayList<> ();

        for ( int i = 0 ; i < guestsNumber ; i++ ) {
            String [] invitedPerson = scan.nextLine ().split ( " " );

            if (invitedPerson [2].equals ( "going!" ) && !guests.contains ( invitedPerson [0] ) ){
                guests.add ( invitedPerson [0] );

            } else if ( invitedPerson [2].equals ( "going!" ) && guests.contains ( invitedPerson [0]  ) ){
                System.out.println ( invitedPerson [0] + " is already in the list!" );

            } else if ( invitedPerson [2].equals ( "not" ) && guests.contains ( invitedPerson [0] )) {
               guests.remove ( invitedPerson [0] );

            } else if ( invitedPerson [2].equals ( "not" ) && !guests.contains ( invitedPerson [0]  ) ){
                System.out.println ( invitedPerson [0] + " is not in the list!" );

            }
        }
        for ( String element: guests ) {
            System.out.println ( element );
        }
    }
}
