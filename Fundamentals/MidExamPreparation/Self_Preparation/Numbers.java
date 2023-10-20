import java.util.*;

public class Numbers {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        int [] numbersline = Arrays.stream ( scan.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int sumOfTheElements = 0;
        for ( int element : numbersline ) {
            sumOfTheElements += element;
        }
        double average = sumOfTheElements * 1.0 / numbersline.length;

        List <Integer> result = new ArrayList<> ();

        for ( int element : numbersline ) {
            if ( element > average ) {
                result.add ( element );
            }
        }
        if(result.isEmpty ()){
            System.out.println ( "No" );
            return;
        }
        if ( result.size () > 5){
            while (result.size () > 5){
                int minValue = Integer.MAX_VALUE;
                for ( int i = 0 ; i < result.size () -1 ; i++ ) {
                    minValue = Math.min (Math.min ( result.get ( i ),result.get ( i + 1 )), minValue );
                }
                result.remove ( (Integer) minValue );
            }
        }
        Collections.sort ( result );
        Collections.reverse ( result );
        System.out.print ( String.join ( " ", result.toString ().replaceAll ( "[\\[\\],]","" ) ));
    }
}
