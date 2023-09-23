package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PokeMon {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner (System.in);
        int pokePower = Integer.parseInt ( scan.nextLine ( ) );
        int targetDistance = Integer.parseInt ( scan.nextLine ( ) );
        int exhaustionFactor = Integer.parseInt ( scan.nextLine ( ) );
        int pokedTargets = 0;
        int startingPower = pokePower;
        while ( pokePower >= targetDistance){
            pokePower -= targetDistance;
            pokedTargets++;
            if (exhaustionFactor > 0 && startingPower/2 == pokePower){
                pokePower /= exhaustionFactor;
            }
        }
        System.out.println ( pokePower );
        System.out.println ( pokedTargets );

    }
}
