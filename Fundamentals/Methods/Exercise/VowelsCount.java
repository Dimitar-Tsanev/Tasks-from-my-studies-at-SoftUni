import java.util.Scanner;

public class VowelsCount {
    public static void main (String[] args) {
        Scanner scan = new Scanner ( System.in );
        String [] text = scan.nextLine ( ).toLowerCase (  ).split ( "" );
        int vowels = countVowels ( text );
        System.out.println ( vowels );
    }
    public static int countVowels (String [] input){
        int vowels = 0;
        for ( int i = 0 ; i < input.length ; i++ ) {
            if (input [i].equals ( "a" ) || input [i].equals ( "e" ) ||
                    input [i].equals ( "o" ) || input [i].equals ( "i" ) ||
                    input [i].equals ( "u" ) ){
                vowels++;
            }

        }
        return vowels;
    }
}
