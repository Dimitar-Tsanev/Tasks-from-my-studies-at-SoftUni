import java.util.Scanner;

public class TheImitationGame {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String textToDecipher = scanner.nextLine ();
        String commandLine = scanner.nextLine ( );

        while (!commandLine.equals ( "Decode" )){
            String[] commandArray = commandLine.split ( "\\|");
            String command = commandArray [0];

            switch (command){
                case "Move":
                    int numberOfLetters = Integer.parseInt ( commandArray [1] );
                    textToDecipher = textToDecipher.substring ( numberOfLetters ) + textToDecipher.substring ( 0,numberOfLetters );
                    break;

                case "Insert":
                    int index = Integer.parseInt ( commandArray [1] );
                    String string = commandArray [2];
                    textToDecipher = textToDecipher.substring ( 0,index ) + string + textToDecipher.substring ( index );
                    break;

                case "ChangeAll":
                    String toBeReplaced = commandArray [1];
                    String replacement = commandArray [2];
                    textToDecipher = textToDecipher.replace ( toBeReplaced,replacement );
                    break;
            }

            commandLine = scanner.nextLine ( );
        }
        System.out.print ( "The decrypted message is: " );
        System.out.println ( textToDecipher );
    }
}
