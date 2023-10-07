import java.util.Scanner;

public class CharactersInRange {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner(System.in);
        char firstChar = scan.nextLine ().charAt ( 0 );
        char secondChar = scan.nextLine ().charAt ( 0 );
        characterPrinter ( firstChar,secondChar );
    }
    public static void characterPrinter (char firstChar, char secondChar){
        if (firstChar > secondChar){
            char swapper = firstChar;
            firstChar = secondChar;
            secondChar = swapper;
        }
        for ( int i = firstChar + 1; i < secondChar  ; i++ ) {
            System.out.printf ( "%c ", i );
        }
    }
}
