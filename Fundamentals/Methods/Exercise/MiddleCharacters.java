import java.util.Scanner;

public class MiddleCharacters {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );
        String input = scan.nextLine ( );
        print ( input );

    }
    public static void print (String input){
        System.out.println ( checksLength ( input ) );

    }
    public static String checksLength ( String input){

        if (input.length () % 2 == 0){
            return getMiddleTwo ( input );

        }else{
            return getMiddle ( input );
        }
    }
    public static String getMiddleTwo ( String input){

        char first = input.charAt ( (input.length ()/2) - 1 );
        char second = input.charAt ( input.length ()/2 );

        return first+""+second;
    }
    public static String getMiddle (String input){

        return input.charAt ( input.length ()/2 ) + "";
    }
}
