import java.util.*;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        List<String> input = Arrays.stream ( scan.nextLine ( ).split ( " " ) ).collect ( Collectors.toList ( ) );
        String operationLine = scan.nextLine ( );
        while (!operationLine.equals ( "3:1" )) {
            String[] divideOperation = operationLine.split ( " " );
            if ( operationLine.contains ( "merge" ) ) {
                int startIndex = Integer.parseInt ( divideOperation[1] );
                int endIndex = Integer.parseInt ( divideOperation[2] );
                if ( startIndex < 0 ) {
                    startIndex = 0;
                } else if ( startIndex >= input.size ( ) - 1 ) {
                    startIndex = input.size ( ) - 1;
                }
                if ( endIndex < 0 ) {
                    endIndex = 0;
                } else if ( endIndex >= input.size ( ) - 1 ) {
                    endIndex = input.size ( ) - 1;
                }
                while (startIndex < endIndex) {
                    String elementToAdd = input.get ( startIndex ) + input.get ( startIndex + 1 );
                    input.set ( startIndex, elementToAdd );
                    endIndex--;
                    input.remove ( startIndex + 1 );
                }
            } else if ( operationLine.contains ( "divide" ) ) {
                int index = Integer.parseInt ( divideOperation[1] );
                int partitions = Integer.parseInt ( divideOperation[2] );
                String toManipulate = input.get ( index );
                if ( partitions != 0 ) {
                    int counter = 0;
                    if ( input.get ( index ).length ( ) % partitions == 0 ) {
                        for ( int i = 0 ; i < partitions ; i++ ) {
                            StringBuilder build = new StringBuilder ( );
                            for ( int j = 0 ; j < toManipulate.length ( ) / partitions ; j++ ) {
                                build.append ( toManipulate.charAt ( counter ) );
                                counter++;
                            }
                            input.add ( index + i + 1, build.toString ( ) );
                        }
                    } else {
                        for ( int i = 0 ; i < partitions ; i++ ) {
                            StringBuilder build = new StringBuilder ( );
                            for ( int j = 0 ; j < toManipulate.length ( ) / partitions ; j++ ) {
                                build.append ( toManipulate.charAt ( counter ) );
                                counter++;
                            }
                            if( i + 1 == partitions ){
                                for ( int k = counter ; k < toManipulate.length () ; k++ ) {
                                    build.append ( toManipulate.charAt ( counter ) );
                                    counter++;
                                }
                            }
                            input.add ( index + i + 1, build.toString ( ) );
                        }

                    }
                    input.remove ( index );
                }
            }
            operationLine = scan.nextLine ( );
        }
        for ( String element : input ) {
            System.out.print ( element + " " );
        }
    }
}
