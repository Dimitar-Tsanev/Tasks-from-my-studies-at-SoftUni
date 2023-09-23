import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int num = Integer.parseInt ( scan.nextLine ( ) );
        int multiplier = Integer.parseInt ( scan.nextLine ( ) );
        do{
           int product = num * multiplier;
            System.out.printf ( "%d X %d = %d%n",num, multiplier, product );
            multiplier++;
        }while (multiplier <= 10);
    }
}
