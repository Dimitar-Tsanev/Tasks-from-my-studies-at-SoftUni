import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<Double,String> chocolatePercentages = Map.of ( 0.30, "Milk Chocolate", 0.50, "Dark Chocolate", 1.00, "Baking Chocolate" );

        Queue<Double> milkQueue = Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Double::parseDouble )
                .collect( Collectors.toCollection ( ArrayDeque::new ));

        Deque<Double> cacaoDeque = getDeque(scanner);

        Map<String,Integer> producedChocolate = new TreeMap<> (  );

        while (!milkQueue.isEmpty () && !cacaoDeque.isEmpty ()){
            double milk = milkQueue.poll ();
            double cacao = cacaoDeque.pop ();

            double percent = cacao / (milk + cacao);

            if (chocolatePercentages.containsKey ( percent )){
                String typeProduced = chocolatePercentages.get ( percent );

                producedChocolate.putIfAbsent ( typeProduced, 0 );
                producedChocolate.put ( typeProduced, producedChocolate.get ( typeProduced ) + 1 );

            }else {
                milk += 10;
                milkQueue.offer ( milk );

            }
        }
        String win = "It’s a Chocolate Time. All chocolate types are prepared.";
        String lose = "Sorry, but you didn't succeed to prepare all types of chocolates.";

        System.out.println ( producedChocolate.size () == 3 ? win: lose);
        producedChocolate.forEach ( (k,v ) -> System.out.println ( "# " + k + " --> " + v ));

    }


    private static Deque<Double> getDeque ( Scanner scanner ) {
        Deque<Double> deque = new ArrayDeque<> (  );

        List<Double> list = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Double::parseDouble )
                .collect( Collectors.toList());

        list.forEach ( deque::push );

        return deque;
    }
}
