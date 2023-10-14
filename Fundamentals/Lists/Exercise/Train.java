import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        List<Integer> wagons =
                 Arrays.stream ( scan.nextLine ().split ( " " ) )
                .map ( Integer::parseInt )
                .collect( Collectors.toList());

        int maximumCapacityOfWagon = Integer.parseInt ( scan.nextLine () );

        String [] command =  scan.nextLine ().split ( " " );

        while (!command [0].equals ( "end" )){

            if (command [0].equals ("Add")){
                int passengersInTheAdditionalWagon = Integer.parseInt ( command[1] );

                if (passengersInTheAdditionalWagon <= maximumCapacityOfWagon){
                   wagons.add ( passengersInTheAdditionalWagon );
                }
            }else{
                int passengersToAdd = Integer.parseInt ( command [0] );

                for ( int i = 0 ; i < wagons.size () ; i++ ) {

                    if (wagons.get ( i ) + passengersToAdd <= maximumCapacityOfWagon ){
                        wagons.set ( i,wagons.get ( i ) + passengersToAdd );
                        break;
                    }
                }
            }
            command = scan.nextLine ().split ( " " );
        }
        for ( int element: wagons) {
            System.out.print ( element + " " );
        }
    }
}
