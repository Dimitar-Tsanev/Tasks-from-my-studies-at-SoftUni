package PokémonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<String, Trainer> trainers = new LinkedHashMap<> ( );

        String input = scanner.nextLine ( );

        while (!"Tournament".equals ( input )) {
            String[] trainerData = input.split ( "\\s+" );
            String trainerName = trainerData[0];

            Trainer trainer = new Trainer ( trainerName );

            trainers.putIfAbsent ( trainerName, trainer );

            Pokemon pokemon = createPokemon ( trainerData );

            trainers.get ( trainerName ).addPokemon ( pokemon );

            input = scanner.nextLine ( );
        }

        input = scanner.nextLine ( );

        while (!"End".equals ( input )) {
            getBadges ( input, trainers );

            input = scanner.nextLine ( );

        }
        printResult ( trainers );
    }

    private static void printResult ( Map<String, Trainer> trainers ) {
        Comparator<Trainer> badgeComparator = ( x1, x2 ) -> {
            if ( x1.getBadges ( ) > x2.getBadges ( ) ) {
                return -1;

            } else if ( x1.getBadges ( ) < x2.getBadges ( ) ) {
                return 1;

            }
            return 0;
        };

        trainers.entrySet ( )
                .stream ( )
                .sorted ( Map.Entry.comparingByValue ( badgeComparator )
                ).forEach ( stringTrainerEntry -> System.out.println ( stringTrainerEntry.getValue ()) );
    }

    private static void getBadges ( String input, Map<String, Trainer> trainers ) {
        for ( Map.Entry<String, Trainer> trainer : trainers.entrySet ( ) ) {
            boolean gotBadge = false;
            for ( Pokemon pokemon : trainer.getValue ( ).getPokemons ( ) ) {
                if ( input.equals ( pokemon.getPokemonElement ( ) ) ) {
                    trainer.getValue ( ).increaseBadges ( );
                    gotBadge = true;
                    break;

                }
            }
            if ( !gotBadge ) {
                trainer.getValue ( ).getPokemons ( ).forEach ( Pokemon::loseHealth );
                trainer.getValue ( ).getPokemons ( ).removeIf ( pokemon -> pokemon.getPokemonHealth ( ) <= 0 );
            }

        }
    }

    private static Pokemon createPokemon ( String[] trainerData ) {
        String pokemonName = trainerData[1];
        String pokemonAttribute = trainerData[2];
        int pokemonHp = Integer.parseInt ( trainerData[3] );

        return new Pokemon ( pokemonName, pokemonAttribute, pokemonHp );
    }
}
