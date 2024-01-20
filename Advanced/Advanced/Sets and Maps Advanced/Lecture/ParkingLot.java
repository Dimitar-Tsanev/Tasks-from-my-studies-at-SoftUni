import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Set<String> carNumbers = new LinkedHashSet<> (  );

        String input = scanner.nextLine ();

        while(!"END".equals (input)){
            String command = input.split ( ", " )[0];
            String carNumber = input.split ( ", " )[1];
            switch (command){
                case "IN":
                    carNumbers.add ( carNumber );
                    break;
                case"OUT":
                    carNumbers.remove ( carNumber );
                    break;

            }
            input = scanner.nextLine ();

        }
        if(carNumbers.isEmpty ()){
            System.out.println ("Parking Lot is Empty");
            return;
        }
        carNumbers.forEach ( System.out::println );
    }
}
