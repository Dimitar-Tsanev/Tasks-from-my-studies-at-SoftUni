import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args){
        Scanner scanner = new Scanner ( System.in );

        String text = scanner.nextLine ( );

        String commandLine = scanner.nextLine ( );

        while (!commandLine.equals ( "Reveal" )){
            String[] commandArguments = commandLine.split ( ":\\|:" );
            String command = commandArguments[0];

            switch (command){
                case "InsertSpace":
                    int index = Integer.parseInt ( commandArguments[1] );

                    text = text.substring ( 0,index ) + " " + text.substring ( index );

                    break;

                case "Reverse":
                    String reversed = commandArguments[1];

                    if ( !text.contains ( reversed ) ){
                        System.out.println ( "error" );

                        commandLine = scanner.nextLine ();

                        continue;
                    }
                    int firstIndex =  text.indexOf ( reversed );
                    String corrected = revers ( reversed );

                    text = text.substring ( 0, firstIndex ) + text.substring ( firstIndex + reversed.length () ) + corrected;

                    break;

                case "ChangeAll":
                    String replace = commandArguments[1];
                    String replacement = commandArguments[2];

                    text = text.replace (replace,replacement  );

                    break;

            }
            System.out.println ( text );
            commandLine = scanner.nextLine ( );
        }
        System.out.print ( "You have a new text message: " );
        System.out.println ( text );

    }
    public static String revers (String reversed){
        StringBuilder corrected = new StringBuilder ( reversed );
        corrected.reverse ();
        return corrected.toString ();
    }
}
