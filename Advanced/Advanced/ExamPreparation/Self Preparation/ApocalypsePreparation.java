import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {

        Map<Integer,String> healingItemMaterials = Map.of (
                30, "Patch",
                40,"Bandage",
                100,"MedKit");

        Queue<Integer> textileQueue = fillQueue ();
        Deque<Integer> medicamentStack = fillDeque ();

        Map<String, Integer> createdItems = new TreeMap<> ();

        while (!textileQueue.isEmpty () && !medicamentStack.isEmpty ()){
            int textile = textileQueue.poll ();
            int medicament = medicamentStack.pop ();

            int materials = medicament + textile;

            if (healingItemMaterials.containsKey ( materials )) {
                String item =  healingItemMaterials.get ( materials );

                createdItems.putIfAbsent ( item, 0 );
                createdItems.put ( item, createdItems.get ( item ) + 1 );

            } else if ( materials > 100 ) {
                materials -= 100;

                createdItems.putIfAbsent ( "MedKit", 0 );
                createdItems.put ( "MedKit", createdItems.get ( "MedKit" ) + 1 );

                if (!medicamentStack.isEmpty ()){
                    medicamentStack.push ( medicamentStack.pop () + materials );

                }

            }else {
                medicament += 10;
                medicamentStack.push ( medicament );

            }
        }
        System.out.println ( textileQueue.isEmpty ()?
                medicamentStack.isEmpty ()?
                        "Textiles and medicaments are both empty." :
                        "Textiles are empty.":
                "Medicaments are empty.");

        createdItems.entrySet ()
                .stream ()
                .sorted ( (e1,e2) -> e2.getValue ().compareTo ( e1.getValue ( ) ))
                .forEach ( e-> System.out.println ( e.getKey () + " - " + e.getValue () ) );

        if (!medicamentStack.isEmpty ()){

            System.out.println ( "Medicaments left: " +
                    medicamentStack.toString ().replaceAll ( "[\\[\\]]","" ) );

        } else if ( !textileQueue.isEmpty () ) {
            System.out.println ( "Textiles left: " +
                    textileQueue.toString ().replaceAll ( "[\\[\\]]","" ) );


        }

    }
    private static Deque<Integer> fillDeque ( ) {
        Deque <Integer> wormsDeque = new ArrayDeque <> (  );

        Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .forEach ( wormsDeque::push );

        return  wormsDeque;
    }
    private static Queue<Integer> fillQueue (){
        return Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toCollection ( ArrayDeque::new ) );
    }

}
