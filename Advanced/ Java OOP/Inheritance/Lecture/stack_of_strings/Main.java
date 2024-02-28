package stack_of_strings;

import java.util.NoSuchElementException;

public class Main {
    public static void main ( String[] args ) {
        StackOfStrings strings = new StackOfStrings ();

        try {
            strings.pop ();
        }catch (NoSuchElementException e){
            System.out.println ( e.getMessage () );
        }
        try {
            strings.peek ();
        }catch (NoSuchElementException e){
            System.out.println ( e.getMessage () );
        }
        System.out.println ( strings.isEmpty () );

        strings.push ( "Pesho" );
        strings.push ( "Joro" );
        strings.push ( "Plamen" );
        strings.push ( "Mitko" );
        strings.push ( "Nikola" );
        strings.push ( "Stamat" );

        System.out.println ( strings.pop () );
        System.out.println ( strings.peek () );

        System.out.println (strings.isEmpty () );
    }
}
