import java.util.Scanner;

public class Fixing {
    /*This program is throwing an ArrayIndexOutOfBoundsException.
    Using your skills, fix this problem using a try-catch block. (without Judge)*/

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );
        String[] weekdays = new String[5];

        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";

        int errorLength = weekdays.length;

        try {
            for ( int i = 0 ; i <= errorLength ; i++ ) {
                System.out.println ( weekdays[i] );
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            errorLength = weekdays.length - 1;
        }

        for ( int i = Integer.parseInt ( scanner.nextLine () ) ; i <= errorLength ; i++ ) {
            System.out.println ( weekdays[i] );
        }
    }
}
