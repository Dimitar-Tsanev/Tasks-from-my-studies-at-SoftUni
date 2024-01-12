import java.util.*;

public class MaximumElement {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfLines = Integer.parseInt ( scanner.nextLine ( ) );
        Deque<Integer> numbersStack = new ArrayDeque<> (  );

        for ( int i = 0 ; i < numberOfLines ; i++ ) {
            int[] currentLine = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                    .mapToInt ( Integer::parseInt )
                    .toArray ();

            switch (currentLine[0]){
                case 1:
                    numbersStack.push ( currentLine[1] );
                    break;

                case 2:
                    numbersStack.pop ();
                    break;

                case 3:
                    System.out.println ( Collections.max ( numbersStack ) );
                    break;

            }
        }
    }
}
