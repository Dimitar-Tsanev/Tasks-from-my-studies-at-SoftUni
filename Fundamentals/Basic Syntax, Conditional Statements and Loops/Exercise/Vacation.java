import java.util.Scanner;
import java.util.function.DoubleFunction;

public class Vacation {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int persons = Integer.parseInt ( scan.nextLine ( ) );
        String type = scan.nextLine ( );
        String day = scan.nextLine ();
        double onePersonPrice = 0.0;
        double discount = 0.0;
        if (day.equals ( "Friday" )){
            switch (type){
                case "Students": onePersonPrice =8.45;
                    break;
                case "Business": onePersonPrice =10.9;
                    break;
                case "Regular": onePersonPrice = 15.0;
                    break;
            }
        }else if (day.equals ( "Saturday" )){
            switch (type){
                case "Students": onePersonPrice =9.80;
                    break;
                case "Business": onePersonPrice =15.60;
                    break;
                case "Regular": onePersonPrice = 20.0;
                    break;
            }
        } else if ( day.equals ( "Sunday" ) ) {
            switch (type){
                case "Students": onePersonPrice =10.46;
                    break;
                case "Business": onePersonPrice =16.0;
                    break;
                case "Regular": onePersonPrice = 22.50;
                    break;
            }
        }
        if (persons >= 30 && type.equals ( "Students" )){
            discount = 0.15;
        }else if (persons >= 100 && type.equals ( "Business" )){
            persons -= 10;
        }else if (persons >= 10 && persons <= 20 && type.equals ( "Regular" )){
            discount = 0.05;
        }
        double totalPrice = (persons * onePersonPrice) * (1 - discount);
        System.out.printf ( "Total price: %.2f", totalPrice);
    }
}
