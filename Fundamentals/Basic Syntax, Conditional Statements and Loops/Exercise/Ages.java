import java.util.Scanner;

public class Ages {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int age = Integer.parseInt ( scan.nextLine ( ) );
        if (age >= 0 && age <= 2){
            System.out.print ( "baby" );
        }else if (age > 2 && age <= 13 ){
            System.out.print ( "child" );
        }else if (age > 13 && age <= 19){
            System.out.print ( "teenager" );
        }else if ( age > 19 && age <=65){
            System.out.print ( "adult" );
        }else if (age >= 66){
            System.out.print ( "elder" );
        }
    }
}
