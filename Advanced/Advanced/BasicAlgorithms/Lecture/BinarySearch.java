import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] input = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );

        int searchNumber = Integer.parseInt ( scanner.nextLine () );

        System.out.println ( getIndex(input,searchNumber) );
    }

    private static int getIndex ( int[] input, int searchNumber ) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end){
            int middle  = start + (end - start) / 2;

            if ( searchNumber < input[middle] ){
                end = middle - 1;

            } else if ( searchNumber > input[middle]  ) {
                start = middle + 1;

            }else {
                return middle;
            }
        }
        return -1;
    }
}
