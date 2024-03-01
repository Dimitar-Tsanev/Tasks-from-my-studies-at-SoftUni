package food_shortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfBuyers = Integer.parseInt ( scanner.nextLine () );
        Map<String, Buyer> namesOfBuyers = new HashMap<> ();

        addBuyers ( namesOfBuyers, numberOfBuyers,scanner );

        String buyer = scanner.nextLine ();

        while ( !"End".equals ( buyer )){
            if (namesOfBuyers.containsKey ( buyer )){
                namesOfBuyers.get ( buyer ).buyFood ();
            }
            buyer = scanner.nextLine ();
        }

        int totalBoughtFood = namesOfBuyers.values ().stream ().mapToInt ( Buyer::getFood ).sum ();

        System.out.println ( totalBoughtFood );

    }
    private static void addBuyers (Map<String, Buyer> namesOfBuyers, int numberOfBuyers,Scanner scanner ){
        for ( int i = 1 ; i <= numberOfBuyers  ; i++ ) {
            String[] personData = scanner.nextLine ().split ( "\\s+" );

            if (personData.length == 4){
                Citizen citizen = new Citizen ( personData[0],
                        Integer.parseInt ( personData[1] ),
                        personData[2],
                        personData[3] );

                namesOfBuyers.put ( personData[0],citizen );

            }else if (personData.length == 3){
                Rebel rebel = new Rebel ( personData[0],
                        Integer.parseInt ( personData[1] ),
                        personData[2] );

                namesOfBuyers.put ( personData[0],rebel );
            }
        }
    }
}
