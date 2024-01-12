import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] inputSequence = scanner.nextLine ( ).split ( "" );

        if ( inputSequence.length  % 2 != 0 ) {
            System.out.println ( "NO" );
            return;
        }

        String result = isBalanced(inputSequence)? "YES": "NO";

        System.out.println (result );
    }

    private static boolean isBalanced ( String[] inputSequence ) {
        Deque<String> openParenthesesStack = new ArrayDeque<> (  );

        for ( String element: inputSequence) {
            switch (element){
                case ")":
                    if (openParenthesesStack.isEmpty () || !"(".equals ( openParenthesesStack.pop ()  )){
                        return false;

                    }
                    break;

                case "]":
                    if (openParenthesesStack.isEmpty () || !"[".equals ( openParenthesesStack.pop () )){
                        return false;

                    }
                    break;

                case "}":
                    if (openParenthesesStack.isEmpty () || !"{".equals ( openParenthesesStack.pop () )){
                        return false;

                    }
                    break;

                default:
                    openParenthesesStack.push ( element );

                    break;

            }
        }
        return true;

    }
} 