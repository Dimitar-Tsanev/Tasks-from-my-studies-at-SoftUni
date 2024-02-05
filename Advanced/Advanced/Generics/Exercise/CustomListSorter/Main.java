package CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        CustomList<String> strings = new CustomList<> ( );

        String commandLine = scanner.nextLine ( );

        while (!"END".equals ( commandLine )) {
            String[] commandArgs = commandLine.split ( "\\s+" );
            String command = commandArgs[0];
            String element;
            int index;

            switch (command) {
                case "Add":
                    element = commandArgs[1];
                    strings.add ( element );
                    break;
                case "Remove":
                    index = Integer.parseInt ( commandArgs[1] );
                    strings.remove ( index );
                    break;
                case "Contains":
                    element = commandArgs[1];
                    System.out.println (strings.contains ( element ));
                    break;
                case "Swap":
                    index = Integer.parseInt ( commandArgs[1]);
                    int index2 = Integer.parseInt ( commandArgs [2]);
                    strings.swap ( index,index2 );
                    break;
                case "Greater":
                    element = commandArgs[1];
                    System.out.println ( strings.countGreaterThan ( element ));
                    break;
                case "Max":
                    System.out.println ( strings.getMax () );
                    break;
                case "Min":
                    System.out.println ( strings.getMin () );
                    break;
                case "Sort":
                    strings = strings.sort ();
                    break;
                case "Print":
                    for ( int i = 0 ; i < strings.size () ; i++ ) {
                        System.out.println ( strings.get ( i ) );
                    }
                    break;
            }
            commandLine = scanner.nextLine ( );
        }
    }
}