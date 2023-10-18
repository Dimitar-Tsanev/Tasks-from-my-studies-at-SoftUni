import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int[] numbers = Arrays.stream ( scan.nextLine ( ).split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );

        String[] commandLine = scan.nextLine ( ).split ( " " );

        while (!commandLine[0].equals ( "end" )) {
            if ( commandLine[0].equals ( "swap" ) || commandLine[0].equals ( "multiply" ) ) {
                int firsIndex = Integer.parseInt ( commandLine[1] );
                int secondIndex = Integer.parseInt ( commandLine[2] );
                if ( checksIfIndexAreValid ( numbers, firsIndex, secondIndex ) ) {
                    switch (commandLine[0]) {
                        case "swap":
                            int swapper = numbers[firsIndex];
                            numbers[firsIndex] = numbers[secondIndex];
                            numbers[secondIndex] = swapper;

                            break;
                        case "multiply":
                            numbers[firsIndex] *= numbers[secondIndex];
                            break;
                    }
                }
            } else if ( commandLine[0].equals ( "decrease" ) ) {
                for ( int i = 0 ; i < numbers.length ; i++ ) {
                    numbers[i] -= 1;
                }
            }

            commandLine = scan.nextLine ( ).split ( " " );
        }
        System.out.println ( Arrays.toString ( numbers ).replaceAll ( "[\\[\\]]", "" ) );
    }
    public static boolean checksIfIndexAreValid ( int [] numbers, int inx1, int inx2){
        return (inx1 >= 0 && inx1 < numbers.length) && (inx2 >=0 && inx2 < numbers.length);
    }
}
