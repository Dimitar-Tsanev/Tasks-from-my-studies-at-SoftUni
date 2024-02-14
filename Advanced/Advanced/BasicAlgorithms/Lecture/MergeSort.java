import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] input = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );

        int[] sorted = mergeSort ( input );

        System.out.println ( Arrays.toString ( sorted ).replaceAll ( "[\\[,\\]]", "" ) );

    }

    private static int[] mergeSort ( int[] input ) {
        if ( input.length == 1 ) {
            return input;
        }
        int halfIndex = input.length / 2;
        int secondArrayLength = input.length - halfIndex;

        int[] partition1 = new int[halfIndex];
        int[] partition2 = new int[secondArrayLength];

        System.arraycopy ( input, 0, partition1, 0, partition1.length );
        System.arraycopy ( input, halfIndex, partition2, 0, partition2.length );

        mergeSort ( partition1 );
        mergeSort ( partition2 );

        int mainIndex = 0;
        int partitionOneIndex = 0;
        int partitionTwoIndex = 0;

        while (partitionOneIndex < partition1.length && partitionTwoIndex < partition2.length) {
            if ( partition1[partitionOneIndex] < partition2[partitionTwoIndex] ) {
                input[mainIndex] = partition1[partitionOneIndex];
                partitionOneIndex++;

            } else {
                input[mainIndex] = partition2[partitionTwoIndex];
                partitionTwoIndex++;
            }
            mainIndex++;
        }
        while (partitionOneIndex < partition1.length) {
            input[mainIndex] = partition1[partitionOneIndex];
            partitionOneIndex++;
            mainIndex++;
        }
        while (partitionTwoIndex < partition2.length) {
            input[mainIndex] = partition2[partitionTwoIndex];
            partitionTwoIndex++;
            mainIndex++;
        }
        return input;
    }
}
