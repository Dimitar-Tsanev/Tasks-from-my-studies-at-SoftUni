package ClassBox;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        try {
            Box box = new Box ( Double.parseDouble ( scanner.nextLine ( )),
                    Double.parseDouble ( scanner.nextLine ( )),
                    Double.parseDouble ( scanner.nextLine () ));

            System.out.printf ( "Surface Area - %f%n" +
                            "Lateral Surface Area - %f%n" +
                            "Volume – %f%n",
                    box.calculateSurfaceArea (),
                    box.calculateLateralSurfaceArea (),
                    box.calculateVolume ());

        }catch (IllegalArgumentException e){
            System.out.println ( e.getMessage () );

        }
    }
}
