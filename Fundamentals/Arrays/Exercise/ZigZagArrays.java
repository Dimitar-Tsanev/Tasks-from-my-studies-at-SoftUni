package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int numberOfArrays = Integer.parseInt ( scan.nextLine ( ) );
        int[] outputFirst = new int[numberOfArrays];
        int[] outputSecond = new int[numberOfArrays];
        for ( int i = 0 ; i < numberOfArrays ; i++ ) {
            int[] Array = Arrays.stream ( scan.nextLine ( ).split ( " " ) )
                    .mapToInt ( Integer::parseInt ).toArray ( );
            if (i %2 == 0) {
                outputFirst[i] = Array[0];
                outputSecond[i] = Array[1];
            }else{
                outputFirst[i] = Array[1];
                outputSecond[i] = Array[0];
            }
        }
        for ( Integer element :
                outputFirst ) {
            System.out.print ( element + " " );
        }
        System.out.println ( );
        for ( Integer element :
              outputSecond ) {
            System.out.print ( element + " " );
        }
    }
}
