package CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int lines = Integer.parseInt ( scanner.nextLine ( ) );

        List<Car> cars = new ArrayList<> ();

        for ( int i = 0 ; i < lines ; i++ ) {
            String currentLine = scanner.nextLine ( );
            String brand = currentLine.split ( "\\s+" )[0];
            String model = currentLine.split ( "\\s+" )[1];
            int horsePower = Integer.parseInt ( currentLine.split ( "\\s+" )[2] );

            Car car = new Car ( brand,model,horsePower );

            cars.add ( car );
        }
        cars.forEach ( x-> System.out.println ( x.carInfo () ) );
    }
}
