import java.util.*;
import java.util.stream.Collectors;

public class MonsterExtermination {
    private static final Scanner scanner = new Scanner ( System.in );
    public static void main ( String[] args ) {

        Queue<Integer> monsterQueue = fillQueue ();
        Deque<Integer> soldierStack = fillDeque ();

        int monstersKilled = 0;

        while (!monsterQueue.isEmpty () && !soldierStack.isEmpty ()){
            int monsterArmor = monsterQueue.poll ();
            int soldierStrength = soldierStack.pop ();

            int difference = Math.abs ( monsterArmor - soldierStrength );
            monstersKilled++;

            if (monsterArmor > soldierStrength){
                monsterQueue.offer ( difference );
                monstersKilled--;

            }else if (monsterArmor < soldierStrength){
                if(soldierStack.isEmpty ()){
                    soldierStack.push ( difference );

                }else{
                    soldierStack.push ( soldierStack.pop () + difference );

                }
            }
        }
        String win = "All monsters have been killed!";
        String lose = "The soldier has been defeated.";

        System.out.println ( monsterQueue.isEmpty ()?
                !soldierStack.isEmpty ()?
                        win:
                        win + System.lineSeparator () + lose
                :lose );

        System.out.println ( "Total monsters killed: " + monstersKilled );
    }
    private static Deque<Integer> fillDeque ( ) {
        Deque <Integer> wormsDeque = new ArrayDeque <> (  );

        Arrays.stream( scanner.nextLine ().split ( "," ) )
                .map ( Integer::parseInt )
                .forEach ( wormsDeque::push );

        return  wormsDeque;
    }

    private static Queue<Integer> fillQueue (){
        return Arrays.stream ( scanner.nextLine ().split ( "," ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toCollection ( ArrayDeque::new ) );
    }

}
