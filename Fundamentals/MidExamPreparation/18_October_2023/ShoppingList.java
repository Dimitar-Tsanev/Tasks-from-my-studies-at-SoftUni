import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        List <String> shoppingList =
                Arrays.stream ( scan.nextLine ().split ( "!" ))
                        .collect( Collectors.toList());

        String command = scan.nextLine ();

        while (!command.equals ( "Go Shopping!" )){
            String [] commandLine = command.split ( " " );
            if (shoppingList.contains ( commandLine [1] )){
                switch (commandLine [0]){
                    case "Unnecessary":
                        shoppingList.remove ( commandLine [1] );
                        break;
                    case "Correct":
                        int indexOfTheItemToReplace = shoppingList.indexOf ( commandLine [1] );
                        shoppingList.set ( indexOfTheItemToReplace, commandLine [2] );
                        break;
                    case "Rearrange":
                        shoppingList.add ( commandLine [1] );
                        shoppingList.remove ( commandLine [1] );
                        break;
                }
            }else if ( commandLine [0].equals ( "Urgent" ) ){
                shoppingList.add ( 0, commandLine [1] );
            }

            command = scan.nextLine ();
        }
        System.out.println ( String.valueOf ( shoppingList ).replaceAll ( "[\\[\\]]", "" ) );
    }
}
