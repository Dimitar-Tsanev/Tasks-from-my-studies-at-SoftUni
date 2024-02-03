package GenericArrayCreator;

public class Main {
    public static void main ( String[] args ) {
        String[] strings = ArrayCreator.create ( 10,"none" );
        Integer[] ints = ArrayCreator.create ( Integer.class, 10,0 );
        System.out.println ( );
    }
}
