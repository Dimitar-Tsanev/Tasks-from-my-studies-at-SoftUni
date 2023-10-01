import java.util.Scanner;

public class RepeatString {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String text = scan.nextLine ( );
        int repeats = Integer.parseInt ( scan.nextLine () );
        String end = repeatString ( text,repeats );
        System.out.println ( end );
    }
    private static String repeatString (String text, int repeats ){
        String result = "";
        for ( int i = 1 ; i <=repeats  ; i++ ) {
            result += text;
        }
        return result;
    }
}
