import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String type = scan.nextLine ().toLowerCase (  );
        switch (type){
            case "int":
                int result = getMax ( Integer.parseInt ( scan.nextLine ( ) ),
                        Integer.parseInt ( scan.nextLine ( ) ));
                System.out.println ( result );
                break;
            case "char":
                char resultC = getMax ( scan.nextLine ().charAt ( 0 ),
                        scan.nextLine ().charAt ( 0 ));
                System.out.println ( resultC );
                break;
            case "string":
                String res = getMax ( scan.nextLine (), scan.nextLine ( ) );
                System.out.println ( res );
                break;
        }
    }
    static int getMax (int firstNum, int secondNum){
        if ( firstNum > secondNum ) {
            return firstNum;
        }
        return secondNum;
    }
    static char getMax ( char firstChar, char secondChar){
        if ( firstChar >= secondChar ) {
            return firstChar;
        }
        return secondChar;
    }
    static String getMax ( String firstString, String secondString){
        if (firstString.compareTo (secondString) >= 0){
            return firstString;
        }
        return secondString;
    }
}
