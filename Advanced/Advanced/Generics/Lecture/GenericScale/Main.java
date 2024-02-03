package GenericScale;

public class Main {
    public static void main ( String[] args ) {

        Scale<String> str = new Scale<> ( "a", "b" );

        Scale<Integer> ints = new Scale<> ( 1, 2 );

        System.out.println ( ints.getHeavier () + " " + str.getHeavier () );

    }
}
