package Jar;

public class Main {
    public static void main ( String[] args ) {
        Jar<Integer> jars = new Jar<Integer> ();

        jars.add ( 1 );
        jars.add ( 2 );

        jars.remove ();

        System.out.println ( );
    }
}
