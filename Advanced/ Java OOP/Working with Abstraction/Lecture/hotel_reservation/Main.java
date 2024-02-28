package hotel_reservation;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] reservationInfo = scanner.nextLine ().split ( "\\s+" );

        double price = Double.parseDouble (reservationInfo[0]);
        int days = Integer.parseInt ( reservationInfo[1] );
        String season = reservationInfo[2];
        String discountType = reservationInfo[3];

        PriceCalculator reservation = new PriceCalculator ( price,days,season,discountType );

        System.out.printf ( "%.2f",reservation.getPrice () );
    }
}
