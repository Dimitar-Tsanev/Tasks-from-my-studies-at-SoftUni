import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        List <Integer> numbers =
                Arrays.stream ( scan.nextLine ().split ( " " ) )
                .map ( Integer::parseInt )
                .collect( Collectors.toList());

        String [] command = scan.nextLine ( ).split ( " " );

        while (!command [0].equals ( "end" )){
            switch (command [0]){
                case "Contains":
                    printIfNumberContain ( numbers,Integer.parseInt ( command [1] ) );
                    break;

                case "Print":
                    if ( command [1].equals ( "even" ) ){
                        printEvenNumbers ( numbers );
                    }else if (command [1].equals ( "odd" )){
                        printOddNumbers ( numbers );
                    }
                    break;
                case "Get":
                    printTheSumOfTheList ( numbers );
                    break;
                case "Filter":
                    switch (command [1]){
                        case "<":
                            printSmallerFromTheGivenNumber ( numbers,
                                    Integer.parseInt ( command [2]) );
                            break;
                        case ">":
                            printLargerFromTheGivenNumber ( numbers,
                                    Integer.parseInt ( command [2]) );
                            break;
                        case ">=":
                            printLargerOrEqualFromTheGivenNumber ( numbers,
                                    Integer.parseInt ( command[2] ));
                            break;
                        case "<=":
                            printSmallerOrEqualFromTheGivenNumber ( numbers,
                                    Integer.parseInt ( command[2] ));
                            break;
                    }
                    break;
            }
            command = scan.nextLine ().split ( " " );
        }
    }
    public static void printIfNumberContain (List <Integer> list, int numberToCheck){
            if (list.contains ( numberToCheck )){
                System.out.println ( "Yes" );
            }else{
                System.out.println ( "No such number" );
            }
    }
    public static void printEvenNumbers (List<Integer> list){
        for ( Integer element: list ) {
            if (element % 2 == 0){
                System.out.print ( element + " " );
            }
        }
        System.out.println ( );
    }
    public static void printOddNumbers (List<Integer> list){
        for ( Integer element: list ) {
            if (element % 2 != 0){
                System.out.print ( element + " " );
            }
        }
        System.out.println ( );
    }
    public static void printTheSumOfTheList (List<Integer> list){
        int sum = 0;
        for ( Integer element: list ) {
            sum += element;
        }
        System.out.println ( sum );
    }
    public static void printSmallerFromTheGivenNumber (List<Integer> list, int num){
        for ( Integer element: list ) {
            if ( element < num ){
                System.out.print ( element + " " );
            }
        }
        System.out.println ( );
    }
    public static void printLargerFromTheGivenNumber (List<Integer> list, int num){
        for ( Integer element: list ) {
            if ( element > num ){
                System.out.print ( element + " " );
            }
        }
        System.out.println ( );
    }
    public static void printSmallerOrEqualFromTheGivenNumber (List<Integer> list, int num){
        for ( Integer element: list ) {
            if ( element <= num ){
                System.out.print ( element + " " );
            }
        }
        System.out.println ( );
    }
    public static void printLargerOrEqualFromTheGivenNumber (List<Integer> list, int num){
        for ( Integer element: list ) {
            if ( element >= num ){
                System.out.print ( element + " " );
            }
        }
        System.out.println ( );
    }
}
