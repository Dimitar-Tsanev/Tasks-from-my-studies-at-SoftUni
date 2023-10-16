import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        List<String> schedule = Arrays.stream ( scan.nextLine ( ).split ( ", " ) )
                .collect ( Collectors.toList ( ) );

        String[] commandLine = scan.nextLine ( ).split ( ":" );

        while (!commandLine[0].equals ( "course start" )) {
            String command = commandLine[0];
            String title = commandLine[1];
            switch (command) {
                case "Add":
                    if ( !schedule.contains ( title ) ) {
                        schedule.add ( title );
                    }
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt ( commandLine[2] );
                    if ( indexToInsert >= 0 && indexToInsert < schedule.size ( ) && !schedule.contains ( title ) ) {
                        schedule.add ( indexToInsert, title );
                    }
                    break;
                case "Remove":
                    if ( schedule.contains ( title ) ) {
                        int indexOfRemoval = schedule.indexOf ( title );
                        schedule.remove ( indexOfRemoval );
                        String titleExercise = title + "-Exercise";
                        if ( indexOfRemoval + 1 < schedule.size ( ) && schedule.get ( indexOfRemoval + 1 ).equals ( titleExercise ) ) {
                            schedule.remove ( indexOfRemoval + 1 );
                        }
                    }
                    break;
                case "Swap":
                    String secondTitle = commandLine[2];
                    if ( schedule.contains ( title ) && schedule.contains ( secondTitle ) ) {
                        int firstTitleIndex = schedule.indexOf ( title );
                        int secondTitleIndex = schedule.indexOf ( secondTitle );
                        schedule.set ( firstTitleIndex, secondTitle );
                        schedule.set ( secondTitleIndex, title );
                        String titleExercise = title + "-Exercise";
                        String secondTitleExercise = secondTitle + "-Exercise";
                        if ( firstTitleIndex + 1 < schedule.size ( ) && secondTitleIndex + 1 < schedule.size ( ) ) {
                            if ( schedule.get ( firstTitleIndex + 1 ).equals ( titleExercise ) ) {
                                schedule.add ( secondTitleIndex + 1, titleExercise );
                                schedule.remove ( firstTitleIndex + 1 );
                            }
                            if ( schedule.get ( secondTitleIndex + 1 ).equals ( secondTitleExercise ) ) {
                                schedule.remove ( secondTitleIndex + 1 );
                                schedule.add ( firstTitleIndex + 1, secondTitleExercise );

                            }
                        } else if ( firstTitleIndex + 1 >= schedule.size ( ) ) {
                            if ( schedule.get ( secondTitleIndex + 1 ).equals ( secondTitleExercise ) ) {
                                schedule.remove ( secondTitleIndex + 1 );
                                schedule.add ( secondTitleExercise );
                            }
                        } else if ( secondTitleIndex + 1 >= schedule.size ( ) ) {
                            if ( schedule.get ( firstTitleIndex + 1 ).equals ( titleExercise ) ) {
                                schedule.add ( titleExercise );
                                schedule.remove ( firstTitleIndex + 1 );
                            }
                        }
                    }
                    break;
                case "Exercise":
                    String titleExercise = title + "-Exercise";
                    if ( schedule.contains ( title ) ) {
                        int titleIndex = schedule.indexOf ( title );
                        if ( titleIndex + 1 < schedule.size ( ) ) {
                            if ( !schedule.get ( titleIndex + 1 ).equals ( titleExercise ) ) {
                                schedule.add ( titleIndex + 1, titleExercise );
                            }
                        } else if ( titleIndex + 1 >= schedule.size ( ) ) {
                            schedule.add ( titleExercise );
                        }
                    } else {
                        schedule.add ( title );
                        schedule.add ( titleExercise );
                    }
                    break;
            }
            commandLine = scan.nextLine ( ).split ( ":" );
        }
        for ( int i = 1 ; i <= schedule.size ( ) ; i++ ) {
            System.out.printf ( "%d.%s%n", i, schedule.get ( i - 1 ) );
        }
    }

}
