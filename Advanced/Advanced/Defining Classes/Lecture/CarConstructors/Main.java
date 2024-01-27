package CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int lines = Integer.parseInt ( scanner.nextLine ());

        List<Car> cars = new ArrayList<> ();

        for ( int i = 0 ; i < lines ; i++ ) {
            String[] currentLine = scanner.nextLine ( ).split ( "\\s+" );

            String brand = currentLine[0];

            if ( currentLine.length > 1 ) {
                String model = currentLine[1];
                int horsePower = Integer.parseInt ( currentLine[2] );

                Car car = new Car ( brand,model, horsePower );
                cars.add ( car );

            }else {
                Car car = new Car (brand);
                cars.add ( car );

            }
        }
        cars.forEach ( System.out::println );
    }
}
