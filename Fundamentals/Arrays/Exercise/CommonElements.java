package Exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String [] firstArray = scan.nextLine ().split (" " );
        String [] secondArray = scan.nextLine ().split (" " );
        StringBuilder commonElements = new StringBuilder ( );
        for ( int secondPosition = 0 ; secondPosition < secondArray.length ; secondPosition++ ) {
            for ( int position = 0 ; position < firstArray.length ; position++ ) {
                if (secondArray [secondPosition].equals ( firstArray [position] )){
                    commonElements.append ( secondArray[secondPosition] ).append ( " " );
                }
            }
        }
        System.out.println ( commonElements );
    }
}
