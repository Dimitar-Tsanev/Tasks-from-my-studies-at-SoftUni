package ListUtilities;

import java.util.Comparator;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMax( List<T> list) {
        if (list.size () == 0 ){
            throw new IllegalArgumentException ( "Empty list" );
        }
        return list.stream( ).max ( Comparable::compareTo ).get ();
    }
    public static <T extends Comparable<T>> T getMin( List<T> list) {
        if (list.size () == 0 ){
            throw new IllegalArgumentException ( "Empty list" );
        }
        return list.stream( ).min ( Comparator.naturalOrder ( ) ).get ();
    }
}
