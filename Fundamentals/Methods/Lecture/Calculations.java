import java.util.Scanner;

public class Calculations {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String calculationType = scan.nextLine ();
        switch (calculationType){
            case "add":
                add (Integer.parseInt ( scan.nextLine ( )),
                        Integer.parseInt ( scan.nextLine ( )) );
                break;
            case "multiply":
                multiply (Integer.parseInt ( scan.nextLine ( )),
                        Integer.parseInt ( scan.nextLine ( ) ) );
                break;
            case "subtract":
                subtract ( Integer.parseInt ( scan.nextLine ( )),
                        Integer.parseInt ( scan.nextLine ( ) ) );
                break;
            case "divide":
                divide ( Integer.parseInt ( scan.nextLine ( )),
                        Integer.parseInt ( scan.nextLine ( ) ) );
                break;
        }
    }
    public static void add (int num1, int num2){
        System.out.println ( num1+num2 );
    }
    public static void multiply (int num1, int num2){
        System.out.println ( num1 * num2 );
    }
    public static void subtract ( int num1, int num2) {
        System.out.println ( num1 - num2 );
    }
    public static void divide (int num1, int num2){
        System.out.print ( num1/num2 );
    }
}
