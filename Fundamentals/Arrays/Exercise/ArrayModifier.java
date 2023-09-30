package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int [] givenArray = Arrays.stream ( scan.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();
        String [] command = scan.nextLine ( ).split ( " " );
        while (!command [0].equals ( "end" ) ){
            if ( command.length > 1) {
                int firstPosition = Integer.parseInt ( command[1] );
                int secondPosition = Integer.parseInt ( command[2] );
                switch (command[0]) {
                    case "swap":
                        int keep = givenArray[firstPosition];
                        givenArray[firstPosition] = givenArray[secondPosition];
                        givenArray[secondPosition] = keep;
                        break;
                    case "multiply":
                        givenArray [firstPosition] *= givenArray[secondPosition];
                        break;
                }
            } else if ( command[0].equals ( "decrease" ) ) {
                for ( int index = 0 ; index < givenArray.length ; index++ ) {
                    givenArray [index]--;
                }
            }
            command = scan.nextLine ( ).split ( " " );
        }
        for ( int position = 0 ; position < givenArray.length ; position++ ) {
            if(position < givenArray.length-1) {
                System.out.print ( givenArray[position] + ", " );
            }else{
                System.out.print ( givenArray[position]);
            }
        }
    }
}
