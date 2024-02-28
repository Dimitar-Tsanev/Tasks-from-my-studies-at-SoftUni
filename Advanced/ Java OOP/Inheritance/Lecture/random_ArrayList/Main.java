package random_ArrayList;

public class Main {
    public static void main ( String[] args ) {

        RandomArrayList<String> strings = new RandomArrayList<String> ();

        strings.add ( "Pesho" );
        strings.add ( "Joro" );
        strings.add ( "Plamen" );
        strings.add ( "Mitko" );
        strings.add ( "Nikola" );
        strings.add ( "Stamat" );

        System.out.println ( strings.getRandomElement () );

    }
}
