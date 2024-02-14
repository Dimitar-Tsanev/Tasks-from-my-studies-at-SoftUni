import java.util.Arrays;
import java.util.Scanner;

public class Quicksort {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] input = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );

        quickSort ( input );

        System.out.println ( Arrays.toString ( input ).replaceAll ( "[\\[,\\]]", "" ) );

    }

    private static void quickSort ( int[] input ) {
        quickSort ( input, 0, input.length - 1 );

    }

    private static void quickSort ( int[] input, int low, int high ) {
        if ( low < high ) {
            int partition = partition ( input, low, high );
            quickSort ( input, low, partition - 1 );
            quickSort ( input, partition + 1, high );
        }
    }

    private static int partition ( int[] input, int low, int high ) {
        int pivot = input[high];
        int i = (low - 1);

        for ( int j = low ; j < high ; j++ ) {
            if ( input[j] <= pivot ) {
                i++;

                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }
        int temp = input[i+ 1];
        input [i + 1] = input[high];
        input[high] = temp;

        return i + 1;
    }
}

