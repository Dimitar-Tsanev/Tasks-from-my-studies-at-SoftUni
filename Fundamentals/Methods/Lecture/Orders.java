import java.util.Scanner;

public class Orders {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        orderCalculator (scan.nextLine (), Integer.parseInt ( scan.nextLine ( ) ) );
    }
    public static void orderCalculator ( String product, int quantity){
        double price = 0;
        switch (product) {
            case "coffee":
                price = 1.5;
                break;
            case "water":
                price = 1.0;
                break;
            case "coke":
                price = 1.40;
                break;
            case "snacks":
                price = 2.0;
                break;
        }
        System.out.printf ( "%.2f", price * quantity  );
    }
}
