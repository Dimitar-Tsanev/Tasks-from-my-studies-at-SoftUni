package StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        CustomStack<Integer> stack = new CustomStack<Integer> ( );

        String commandData = scanner.nextLine ( );

        while (!"END".equals ( commandData )) {
            String[] commandTokens = commandData.split ( "\\s+|, " );
            String command = commandTokens[0];

            if ( command.equals ( "Push" ) ) {
                Integer[] elements = Arrays.stream ( commandTokens ).skip ( 1 )
                        .map ( Integer::parseInt )
                        .toArray ( Integer[]::new );

                stack.push ( elements );

            } else if ( command.equals ( "Pop" ) ) {
                stack.pop ( );

            }
            commandData = scanner.nextLine ( );

        }
        if ( stack.size ( ) != 0 ) {
            stack.forEach ( System.out::println );
            stack.forEach ( System.out::println );

        }
    }
}
