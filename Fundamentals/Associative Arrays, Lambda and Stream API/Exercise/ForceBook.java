import java.util.*;

public class ForceBook {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        LinkedHashMap<String, List<String>> forcesUsers = new LinkedHashMap<> ( );

        String input = scanner.nextLine ( );

        while (!input.equals ( "Lumpawaroo" )) {
            boolean stringIsSwap = input.contains ( " -> " );

            String [] commandLine = returnsUserData ( stringIsSwap,input );
            String force = commandLine[0];
            String user = commandLine[1];
            
            boolean newUser = checksIfUserIsInTheList ( user, forcesUsers );

            if (newUser && !forcesUsers.containsKey ( force )){
                forcesUsers.put ( force, new ArrayList<> () );
                forcesUsers.get ( force ).add ( user );
                
            } else if ( newUser )  {
                forcesUsers.get ( force ).add ( user );

            }else {
                if (stringIsSwap){
                    String userCurrentForce = "";
                    for ( Map.Entry <String, List<String>> entry:  forcesUsers.entrySet () ) {
                        for ( String member: entry.getValue ()) {
                            if ( member.equals ( user ) ) {
                                userCurrentForce = entry.getKey ( );
                                break;
                            }
                        }
                    }
                    forcesUsers.get ( userCurrentForce ).remove ( user );

                    if (forcesUsers.containsKey ( force )) {
                        forcesUsers.get ( force ).add ( user );

                    }else{
                        forcesUsers.put ( force, new ArrayList<> () );
                        forcesUsers.get ( force ).add ( user );
                    }
                }
            }
            if ( stringIsSwap ){
                System.out.printf ( "%s joins the %s side!%n", user, force );
            }

            input = scanner.nextLine ( );
        }

        for ( Map.Entry<String, List<String>> force: forcesUsers.entrySet () ) {
            if (!force.getValue ().isEmpty ()) {
                System.out.printf ( "Side: %s, Members: %d%n", force.getKey (), force.getValue ().size () );
                for ( String user : force.getValue () ) {
                    System.out.println ( "! " + user );
                }
            }
        }
    }
    public static String[] returnsUserData (boolean stringIsSwap, String input ){
        if (stringIsSwap){
           String[] commandList =  input.split ( " -> " );
           String swapper = commandList[0];
           commandList [0] = commandList[1];
           commandList [1] = swapper;

           return commandList;

        }else {
            return input.split ( " \\| " );
        }
    }
    public static boolean checksIfUserIsInTheList (String user, LinkedHashMap<String, List<String>> forcesUsers){
        for ( Map.Entry<String, List<String>> force: forcesUsers.entrySet () ) {
            for ( String member: force.getValue ()) {
                if (member.equals ( user )){
                    return false;
                }
            }
        }
        return true;
    }
}