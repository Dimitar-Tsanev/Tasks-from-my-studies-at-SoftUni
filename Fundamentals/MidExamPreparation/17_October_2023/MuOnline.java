import java.util.Scanner;

public class MuOnline {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        String [] rooms = scan.nextLine ().split ( "\\|" );

        int coins = 0;
        int health = 100;

        for ( int i = 0 ; i < rooms.length ; i++ ) {
            String [] whatWillHappenedInTheRoom = rooms [i].split ( " " );
            if ( whatWillHappenedInTheRoom [0].equals ( "potion" )){
                int potionPower = Integer.parseInt ( whatWillHappenedInTheRoom [1] );
                if( health < 100){
                    if (health + potionPower <= 100){
                        health += potionPower;
                    } else if ( health + potionPower > 100 ) {
                        potionPower = 100 - health;
                        health += potionPower;
                    }
                    System.out.printf ("You healed for %d hp.%n", potionPower );
                }else {
                    System.out.println ("You healed for 0 hp.");
                }

                System.out.printf ( "Current health: %d hp.%n", health );

            } else if ( whatWillHappenedInTheRoom [0].equals ( "chest" )) {
                int coinsFound = Integer.parseInt ( whatWillHappenedInTheRoom [1] );
                coins += coinsFound;
                System.out.printf ( "You found %d bitcoins.%n", coinsFound );
            }else{
                String monsterName = whatWillHappenedInTheRoom [0];
                int monsterAP = Integer.parseInt ( whatWillHappenedInTheRoom [1] );
                health -= monsterAP;
                if ( health > 0 ){
                    System.out.printf ( "You slayed %s.%n", monsterName  );
                }else{
                    System.out.printf ( "You died! Killed by %s.%n",monsterName );
                    System.out.printf ( "Best room: %d%n", i + 1 );
                    return;
                }
            }
        }
        System.out.println ( "You've made it!" );
        System.out.printf ( "Bitcoins: %d%n", coins  );
        System.out.printf ( "Health: %d%n", health );
    }
}
