import java.util.LinkedHashMap;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfHeroes = Integer.parseInt ( scanner.nextLine ( ) );

        LinkedHashMap<String, Integer> heroesHP = new LinkedHashMap<> ();
        LinkedHashMap<String, Integer> heroesMP = new LinkedHashMap<> ();

        for ( int i = 1 ; i <= numberOfHeroes  ; i++ ) {
            String[] heroData = scanner.nextLine ().split ( " " );

            String name = heroData[0];
            int health = Integer.parseInt ( heroData[1] );
            int mana = Integer.parseInt ( heroData[2] );

            heroesHP.put ( name,health );
            heroesMP.put ( name,mana );

        }
        String commandLine = scanner.nextLine ( );

        while (!commandLine.equals ( "End" )){
            String[] commandData = commandLine.split ( " - " );

            String command = commandData[0];
            String name = commandData[1];

            switch (command){
                case "CastSpell":
                    int neededMP = Integer.parseInt ( commandData[2]);
                    String spellName = commandData[3];

                    castSpell ( heroesMP,name,neededMP,spellName );

                    break;

                case "TakeDamage":
                    int lostHp = Integer.parseInt ( commandData[2] );
                    String attacker = commandData[3];

                    takeAttack ( heroesHP,heroesMP,name,lostHp,attacker );

                    break;

                case "Recharge":
                    int recoveredMP = Integer.parseInt ( commandData[2] );

                    recharge ( heroesMP,name,recoveredMP );

                    break;

                case "Heal":
                    int healedHP = Integer.parseInt ( commandData[2] );

                    heal ( heroesHP,name,healedHP );

                    break;
            }
            commandLine = scanner.nextLine ( );
        }
        heroesHP.forEach ( (k, v) -> System.out.printf ( "%s%n HP: %d%n MP: %d%n",k,v,heroesMP.get ( k ) ) );
    }
    public static void castSpell (LinkedHashMap<String, Integer> heroesMP, String name, int neededMana, String spellName){
        if ( heroesMP.get ( name ) >= neededMana ){
            heroesMP.put ( name, heroesMP.get ( name ) - neededMana );

            System.out.printf ( "%s has successfully cast %s and now has %d MP!%n", name, spellName,heroesMP.get ( name ) );

        }else {
            System.out.printf ( "%s does not have enough MP to cast %s!%n",name,spellName );

        }
    }
    public static void takeAttack (LinkedHashMap<String, Integer> heroesHP,LinkedHashMap<String, Integer> heroesMP, String name, int lostHP, String attacker){
        if ( (heroesHP.get ( name ) - lostHP) > 0){
            heroesHP.put ( name, heroesHP.get ( name ) - lostHP );

            System.out.printf ( "%s was hit for %d HP by %s and now has %d HP left!%n", name, lostHP, attacker,heroesHP.get ( name ) );

        }else {
            heroesHP.remove ( name );
            heroesMP.remove ( name );

            System.out.printf ( "%s has been killed by %s!%n",name,attacker );
        }
    }
    public static void recharge (LinkedHashMap<String, Integer> heroesMP, String name, int recoveredMana){
        int maxMana = 200;

        if (maxMana < (heroesMP.get ( name ) + recoveredMana)){
            recoveredMana = maxMana - heroesMP.get ( name );

        }
        heroesMP.put ( name,heroesMP.get ( name ) + recoveredMana );

        System.out.printf ( "%s recharged for %d MP!%n",name, recoveredMana );
    }
    public static void heal (LinkedHashMap<String, Integer> heroesHP, String name, int healedHp){
        int maxMana = 100;

        if (maxMana < (heroesHP.get ( name ) + healedHp)){
            healedHp = maxMana - heroesHP.get ( name );

        }
        heroesHP.put ( name,heroesHP.get ( name ) + healedHp );

        System.out.printf ( "%s healed for %d HP!%n",name, healedHp );
    }
}
