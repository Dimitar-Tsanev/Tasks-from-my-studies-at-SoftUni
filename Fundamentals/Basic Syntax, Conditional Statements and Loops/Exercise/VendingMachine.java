import java.util.Scanner;

public class VendingMachine {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String input = scan.nextLine ();
        double totalCoins = 0.0;
        while (!input.equals ( "Start" )){
            double coins = Double.parseDouble ( input );
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2 ){
                totalCoins += coins;
            }else{
                System.out.printf ( "Cannot accept %.2f%n", coins );
            }
            input = scan.nextLine ();
        }
        input = scan.nextLine ();
        while (!input.equals ( "End" )){
            double price = 0.0;
            switch (input){
                case "Nuts": price = 2.0;
                    if (totalCoins >= price){
                        totalCoins -= price;
                        System.out.println ( "Purchased Nuts");
                    }else{
                        System.out.println ( "Sorry, not enough money");
                    }
                    break;
                case "Water": price = 0.7;
                    if (totalCoins >= price){
                        totalCoins -= price;
                        System.out.println ( "Purchased Water");
                    }else{
                        System.out.println ( "Sorry, not enough money");
                    }
                    break;
                case "Crisps":price = 1.5;
                    if (totalCoins >= price){
                        totalCoins -= price;
                        System.out.println ( "Purchased Crisps");
                    }else{
                        System.out.println ( "Sorry, not enough money");
                    }
                    break;
                case "Soda":price = 0.8;
                    if (totalCoins >= price){
                        totalCoins -= price;
                        System.out.println ( "Purchased Soda");
                    }else{
                        System.out.println ( "Sorry, not enough money");
                    }
                    break;
                case "Coke":price = 1.0;
                    if (totalCoins >= price){
                        totalCoins -= price;
                        System.out.println ( "Purchased Coke");
                    }else{
                        System.out.println ( "Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println ( "Invalid product" );
                    break;
            }
            input = scan.nextLine ();
        }
        System.out.printf ( "Change: %.2f",totalCoins );
    }
}
