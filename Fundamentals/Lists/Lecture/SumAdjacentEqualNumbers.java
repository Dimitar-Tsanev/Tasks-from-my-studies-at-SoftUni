import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main (String [] args){
        Scanner scan = new Scanner ( System.in );
        List <Double> numbers = Arrays.stream ( scan.nextLine ().split ( " " ) )
                .map ( Double::parseDouble )
                .collect( Collectors.toList());


        for ( int index = 0 ; index < numbers.size ()-1 ; index++ ) {

            if ( numbers.get ( index ).equals ( numbers.get ( index + 1 ) ) ){
                numbers.set ( index, numbers.get ( index) + numbers.get ( index + 1 ) );
                numbers.remove ( index + 1 );
                index = -1;
            }
        }

        for ( Double index: numbers) {
            System.out.print (  new DecimalFormat ( "0.#" ).format ( index)  + " ");
        }
    }
}
