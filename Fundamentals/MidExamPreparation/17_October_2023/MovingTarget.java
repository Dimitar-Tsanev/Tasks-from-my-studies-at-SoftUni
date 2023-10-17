import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        List <Integer> targets =
                Arrays.stream ( scan.nextLine ().split ( " " ) )
                .map ( Integer::parseInt )
                .collect( Collectors.toList());

        String [] commandLine = scan.nextLine ().split ( " " );

        while (!commandLine [0].equals ( "End" )){
            String command = commandLine [0];
            int index = Integer.parseInt ( commandLine [1] );

            switch (command){

                case "Shoot":
                    int power = Integer.parseInt ( commandLine [2] );
                    if (index >= 0 && index < targets.size ()){
                        targets.set ( index, targets.get ( index ) - power);
                        if (targets.get ( index ) <= 0){
                            targets.remove ( index );
                        }
                    }
                    break;

                case "Add":
                    int value = Integer.parseInt ( commandLine [2] );
                    if (index>=0 && index < targets.size ()){
                        targets.add ( index,value );
                    }else {
                        System.out.println ( "Invalid placement!" );
                    }
                    break;

                case "Strike":
                    int radiusOfDestruction = Integer.parseInt ( commandLine [2] );
                    int firstIndexToDestroy = index - radiusOfDestruction;
                    int finalIndexToDestroy = index + radiusOfDestruction;
                    if (firstIndexToDestroy >= 0 && finalIndexToDestroy < targets.size ()){
                        while ( firstIndexToDestroy <= finalIndexToDestroy){
                            targets.remove ( firstIndexToDestroy );
                            finalIndexToDestroy--;
                        }
                    }else {
                        System.out.println ( "Strike missed!" );
                    }
                    break;
            }
            commandLine = scan.nextLine ().split ( " " );
        }
        for ( int i = 0 ; i < targets.size () ; i++ ) {
            if (i < targets.size () - 1 ) {
                System.out.printf ( "%d|", targets.get ( i ));
            }else {
                System.out.println ( targets.get ( i ) );
            }
        }
    }
}
