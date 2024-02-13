import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] arr = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        System.out.println ( getRecursiveSum(arr, 0));
    }

    private static int getRecursiveSum ( int[] arr, int index) {
        if (index == arr.length - 1){
            return arr[index];
        }
        return arr[index] + getRecursiveSum ( arr,index + 1 );
    }
}
