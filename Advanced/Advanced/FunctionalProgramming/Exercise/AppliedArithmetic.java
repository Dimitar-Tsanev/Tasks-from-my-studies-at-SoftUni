import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public class AppliedArithmetic {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Function<String, UnaryOperator<Integer>>  getsOperation =  operation -> {
            switch (operation){
                case "add":
                    return x -> x + 1 ;
                case "multiply":
                    return x -> x * 2;
                case "subtract":
                    return x -> x - 1;
                default:
                   return x -> x;
            }
        };

        int[] numbers = Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt  )
                .toArray ();

        String line = scanner.nextLine ();


        while (!"end".equals ( line )){
            UnaryOperator <Integer> doOperation = getsOperation.apply ( line );

            for ( int i = 0; i < numbers.length; i++ ){
                numbers[i] = doOperation.apply ( numbers[i] );

            }
            if ("print".equals ( line )){
                System.out.print ( Arrays.toString ( numbers ).replaceAll ( "[\\[,\\]]","" ));
                System.out.println ( );

            }
            line = scanner.nextLine ( );
        }
    }
}
