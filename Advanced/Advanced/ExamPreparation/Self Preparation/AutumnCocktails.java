import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {
        Map<Integer, String> cocktailsFreshness = Map.of (
                150, "Pear Sour",
                250, "The Harvest",
                300, "Apple Hinny",
                400, "High Fashion" );

        Queue<Integer> ingredientsQueue = fillQueue ( );
        Deque<Integer> freshnessStack = fillDeque ( );

        Map<String, Integer> doneCocktails = new TreeMap<> ();

        while (!ingredientsQueue.isEmpty () && !freshnessStack.isEmpty ()){
            int ingredients = ingredientsQueue.poll ();
            int freshnessLevel = freshnessStack.pop ();

            while (!ingredientsQueue.isEmpty () && ingredients <= 0 ) {
                ingredients = ingredientsQueue.poll ( );

            }
            if(ingredientsQueue.isEmpty () && ingredients <= 0 ) {
                break;

            }

            int freshness = ingredients * freshnessLevel;

            if (cocktailsFreshness.containsKey ( freshness )){
                String cocktail = cocktailsFreshness.get ( freshness );

                doneCocktails.putIfAbsent ( cocktail, 0);
                doneCocktails.put ( cocktail, doneCocktails.get ( cocktail ) + 1 );

            }else {
                ingredientsQueue.offer ( 5 + ingredients );

            }
        }
        printResult ( doneCocktails,ingredientsQueue );

    }
    private static void printResult ( Map<String, Integer> doneCocktails, Queue<Integer> ingredientsQueue){
        String win = "It's party time! The cocktails are ready!";
        String lose = "What a pity! You didn't manage to prepare all cocktails.";

        System.out.println ( doneCocktails.size () == 4? win:lose );

        int leftIngredients = ingredientsQueue.stream ( ).mapToInt ( element -> element ).sum ( );

        if (leftIngredients > 0){
            System.out.println ( "Ingredients left: " + leftIngredients);
        }
        doneCocktails.forEach ( (k,v) -> System.out.printf (" # %s --> %d%n",k,v ) );
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
