import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class PredicateParty {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Predicate<String> parametersOfAction;

        List<String> names = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .collect( Collectors.toList());

        String commandLine = scanner.nextLine ( );

        while (!"Party!".equals ( commandLine )){
            String action = commandLine.split ( "\\s+" )[0];
            String command = commandLine.split ( "\\s+" )[1];
            String parameter = commandLine.split ( "\\s+" )[2];

            switch (command){
                case "StartsWith":
                    parametersOfAction = s -> s.startsWith ( parameter );
                    break;

                case "EndsWith" :
                    parametersOfAction = s -> s.endsWith ( parameter );
                    break;

                default:
                    parametersOfAction = s -> s.length () == Integer.parseInt ( parameter );
                    break;

            }
            if ("Remove".equals ( action)){
                names.removeIf ( parametersOfAction );

            }else{
                List<String> doubleSelected = names.stream ().filter ( parametersOfAction ).collect( Collectors.toList());
                names.addAll ( doubleSelected );

            }
            commandLine = scanner.nextLine ( );

        }
        names = names.stream ().sorted ().collect( Collectors.toList());

        System.out.println ( names.isEmpty ()? "Nobody is going to the party!":
                String.join ( ", ",names ) + " are going to the party!");

    }
}
