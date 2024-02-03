package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main ( String[] args ) {
        List <Integer> ints = new ArrayList<> ();
        List <String> strings = new ArrayList<> ();

        Collections.addAll ( ints, 1,2,3,18,2,0 );
        Collections.addAll ( strings,"a", "b", "c","d" );

       String min = ListUtils.getMin ( strings );
       String max = ListUtils.getMax ( strings );

        int minInt = ListUtils.getMin ( ints );
        int maxInt = ListUtils.getMax ( ints );

        System.out.println ( min + " " + max );
        System.out.println (minInt );
        System.out.println (maxInt );
    }
}
