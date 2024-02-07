package ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        ListyIterator<String> listy = new ListyIterator<String> ( );

        String command = scanner.nextLine ( );

        while (!"END".equals ( command )) {
            String[] commandData = command.split ( "\\s+" );

            switch (commandData[0]) {
                case "Create":
                    String[] elements = Arrays.stream ( commandData ).skip ( 1 ).toArray ( String[]::new );
                    listy = new ListyIterator<> ( elements );
                    break;
                case "Move":
                    System.out.println ( listy.move ( ) );
                    break;
                case "HasNext":
                    System.out.println ( listy.hasNext ( ) );
                    break;
                case "Print":
                    listy.print ( );
                    break;
            }
            command = scanner.nextLine ( );
        }
    }
}
