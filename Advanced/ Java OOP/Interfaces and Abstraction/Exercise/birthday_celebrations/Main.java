package birthday_celebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ();
        List<Birthable> theyHasBirthdays = new ArrayList<> ();

        while (!"End".equals ( input )){
            String[] data = input.split ( "\\s+" );

            switch (data[0]){
                case"Citizen":
                    Citizen citizen = new Citizen ( data[1], Integer.parseInt ( data[2] ),data[3],data[4] );
                    theyHasBirthdays.add ( citizen );
                    break;

                case "Pet":
                    Pet pet = new Pet ( data[1],data[2] );
                    theyHasBirthdays.add ( pet );
                    break;

            }
            input = scanner.nextLine ();
        }

       String bornInYear = scanner.nextLine ();

        theyHasBirthdays.stream ()
                .filter ( e-> e.getBirthDate ().endsWith ( bornInYear ) )
                .forEach ( e-> System.out.println ( e.getBirthDate () ) );
    }
}
