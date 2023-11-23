import java.util.Scanner;

public class ActivationKeys {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        StringBuilder input = new StringBuilder ( scanner.nextLine ( ) );

        String commandLine = scanner.nextLine ( );

        while (!commandLine.equals ( "Generate" )) {
            String[] commandArguments = commandLine.split ( ">{3}" );

            String command = commandArguments[0];

            switch (command) {
                case "Contains":
                    String searched = commandArguments[1];

                    if ( input.toString ( ).contains ( searched ) ) {
                        System.out.printf ( "%s contains %s%n", input, searched );

                    } else {
                        System.out.println ( "Substring not found!" );

                    }
                    break;

                case "Flip":
                    String transformer = commandArguments[1];
                    int fromIndex = Integer.parseInt ( commandArguments[2] );
                    int toIndex = Integer.parseInt ( commandArguments[3] );

                    String subString = input.substring ( fromIndex,toIndex );

                    input.delete ( fromIndex,toIndex );


                    if ( transformer.equals ( "Upper" ) ) {
                        input.insert ( fromIndex, subString.toUpperCase (  ) );

                    } else if ( transformer.equals ( "Lower" ) ) {
                        input.insert ( fromIndex, subString.toLowerCase (  ) );

                    }

                    System.out.println ( input );

                    break;

                case "Slice":
                    int startIndex = Integer.parseInt ( commandArguments[1] );
                    int endIndex = Integer.parseInt ( commandArguments[2] );

                    input.delete ( startIndex,endIndex );

                    System.out.println ( input );

                    break;

            }
            commandLine = scanner.nextLine ( );

        }
        System.out.println ( "Your activation key is: " + input );

    }
}
