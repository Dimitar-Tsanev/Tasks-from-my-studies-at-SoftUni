import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        int [] neighbors = Arrays.stream ( scan.nextLine ().split ( "@" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        String command = scan.nextLine ( );
        int currentPosition = 0;

        while (!command.equals ( "Love!" )){
            int jumpToIndex = Integer.parseInt ( command.split ( " " ) [1]);
            currentPosition += jumpToIndex;
            if (currentPosition >= neighbors.length){
                currentPosition = 0;
            }
            if ( neighbors [currentPosition] != 0) {
                neighbors[currentPosition] -= 2;
                if (neighbors [currentPosition] == 0){
                    System.out.printf ( "Place %d has Valentine's day.%n", currentPosition);
                }
            }else {
                System.out.printf ( "Place %d already had Valentine's day.%n", currentPosition);
            }
            command = scan.nextLine ( );
        }
        System.out.printf ( "Cupid's last position was %d.%n", currentPosition );

        if ( checksIfAllHousesGetTheirValentine ( neighbors ) ){
            System.out.println ( "Mission was successful." );

        }else{
            System.out.printf ( "Cupid has failed %d places.%n",countTheHousesThatDidntGetTheirValentine ( neighbors ) );
        }
    }
    public static boolean checksIfAllHousesGetTheirValentine ( int [] neighbors ){
        int houses = countTheHousesThatDidntGetTheirValentine ( neighbors );
        return houses == 0;
    }
    public static int countTheHousesThatDidntGetTheirValentine (int [] neighbors){
        int houseCount = 0;
        for ( int neighbor : neighbors ) {
            if ( neighbor != 0 ) {
                houseCount++;
            }
        }
        return houseCount;
    }

}
