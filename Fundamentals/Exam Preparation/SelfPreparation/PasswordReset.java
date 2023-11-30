import java.util.Scanner;

public class PasswordReset {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        StringBuilder input = new StringBuilder (scanner.nextLine ());

        String commandLine = scanner.nextLine ( );

        while (!commandLine.equals("Done")){
            String command = commandLine.split ( " " )[0];

            switch (command){
                case "TakeOdd":
                    input = takeOdd ( input );

                    break;

                case "Cut":
                    int startIndex = Integer.parseInt ( commandLine.split ( " " )[1] );
                    int endIndex = startIndex + Integer.parseInt (  commandLine.split ( " " )[2] );

                    input.delete ( startIndex,endIndex );

                    break;

                case "Substitute":
                    String replace = commandLine.split ( " " )[1];
                    String replacement = commandLine.split ( " " )[2];

                    if (!input.toString ().contains ( replace )){
                        System.out.println ( "Nothing to replace!" );

                        commandLine = scanner.nextLine ( );

                        continue;

                    }
                    input = new StringBuilder ( input.toString ( ).replace ( replace, replacement ) );

                    break;

            }
            System.out.println ( input );

            commandLine = scanner.nextLine ( );

        }
        System.out.println ( "Your password is: " + input);
    }
    public static StringBuilder takeOdd (StringBuilder input){
        StringBuilder odds = new StringBuilder ();

        for ( int i = 0 ; i < input.length () ; i++ ) {
            if (i % 2 != 0){
                odds.append ( input.charAt ( i ) );

            }
        }
        return  odds;
    }
}
