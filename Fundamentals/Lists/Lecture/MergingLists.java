import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        List <Integer> firstList =
                Arrays.stream ( scan.nextLine ().split ( " " ) )
                        .map ( Integer::parseInt )
                        .collect( Collectors.toList());
        List <Integer> secondList =
                Arrays.stream ( scan.nextLine ().split ( " " ) )
                        .map ( Integer::parseInt )
                        .collect( Collectors.toList());
        int loops;

        if (firstList.size () > secondList.size ()){
            loops = secondList.size () - 1;
            mergeLists ( firstList,secondList,loops );

        }else {
            loops = firstList.size () - 1;
            mergeLists ( firstList,secondList,loops );

            for ( int i = loops + 1; i < secondList.size ()  ; i++ ) {
                firstList.add ( secondList.get ( i ) );

            }
        }

        for ( Integer element: firstList ) {
            System.out.print ( element + " " );
        }

    }
    public static void mergeLists (List <Integer> list1, List <Integer> list2, int loops ){
        for ( int i = 0 ; i <= loops ; i++ ) {
            list1.add ( i + 1 + i, list2.get ( i ) );
        }
    }
}
