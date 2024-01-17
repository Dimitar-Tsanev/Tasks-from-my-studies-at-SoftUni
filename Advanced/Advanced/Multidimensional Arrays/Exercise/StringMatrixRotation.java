import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    private static final Scanner scanner = new Scanner ( System.in );
    private static int longestWord = 0;

    public static void main ( String[] args ) {

        String command = scanner.nextLine ( );

        Pattern pattern = Pattern.compile ( "Rotate\\((?<degree>[0-9]+)\\)" );
        Matcher matcher = pattern.matcher ( command );

        int degree = matcher.find ( ) ? Integer.parseInt ( matcher.group ( "degree" ) ) : 0;

        Queue<String> texts = new ArrayDeque<> ( );
        fillQueue ( texts );
        equalWordsLength ( texts );

        while (degree > 360){
            degree -= 360;
        }

        if(degree % 360 == 0 ){
            String[][] matrix = fillMatrix ( texts );
            printMatrix ( matrix );

        } else if ( degree % 270 == 0 ) {
            String[][] matrix = rotateMatrix270 ( texts );
            printMatrix ( matrix );

        } else if ( degree % 180 == 0 ) {
            String[][] matrix = rotateMatrix180 ( texts );
            printMatrix ( matrix );

        } else{
            String[][] matrix = rotateMatrix90 ( texts );
            printMatrix ( matrix );

        }

    }

    private static void printMatrix ( String[][] matrix ) {
        for ( String[] row : matrix ) {
            for ( String element : row ) {
                System.out.print ( element );
            }
            System.out.println ( );
        }
    }

    private static String[][] fillMatrix ( Queue<String> texts ) {
        int cols = longestWord;
        int rows = texts.size ( );

        String[][] matrix = new String[rows][cols];


        for ( int row = 0 ; row < rows ; row++ ) {
            String currentWord = texts.peek ( ) != null ? texts.poll ( ) : " ";
            int currentChar = 0;

            for ( int col = 0 ; col < cols ; col++ ) {
                matrix[row][col] = String.valueOf ( currentWord.charAt ( currentChar ) );

                currentChar++;

            }
        }

        return matrix;
    }

    private static String[][] rotateMatrix90 ( Queue<String> texts ) {
        int cols = texts.size ( );
        int rows = longestWord;

        String[][] matrix = new String[rows][cols];

        for ( int col = cols - 1 ; col >= 0 ; col-- ) {
            String currentWord = texts.peek ( ) != null ? texts.poll ( ) : " ";
            int currentChar = 0;

            for ( int row = 0 ; row < rows ; row++ ) {
                matrix[row][col] = String.valueOf ( currentWord.charAt ( currentChar ) );

                currentChar++;

            }
        }
        return matrix;
    }

    private static String[][] rotateMatrix180 ( Queue<String> texts ) {
        int cols = longestWord;
        int rows = texts.size ( );

        String[][] matrix = new String[rows][cols];


        for ( int row = rows -1 ; row >= 0 ; row-- ) {
            String currentWord = texts.peek ( ) != null ? texts.poll ( ) : " ";
            int currentChar = 0;

            for ( int col = cols - 1 ; col >= 0 ; col-- ) {
                matrix[row][col] = String.valueOf ( currentWord.charAt ( currentChar ) );

                currentChar++;

            }

        }
        return matrix;
    }

    private static String[][] rotateMatrix270 ( Queue<String> texts ) {
        int cols = texts.size ( );
        int rows = longestWord;

        String[][] matrix = new String[rows][cols];


        for ( int col = 0 ; col < cols ; col++ ) {
            String currentWord = texts.peek ( ) != null ? texts.poll ( ) : " ";
            int currentChar = 0;

            for ( int row = rows - 1 ; row >= 0 ; row-- ) {
                matrix[row][col] = String.valueOf ( currentWord.charAt ( currentChar ) );

                currentChar++;

            }
        }
        return matrix;
    }

    private static void equalWordsLength ( Queue<String> texts ) {
        for ( String ignored : texts ) {
            StringBuilder currentWord = new StringBuilder ( texts.peek ( ) != null ? texts.poll ( ) : " " );

            if ( currentWord.length ( ) < longestWord ) {
                currentWord.append ( " ".repeat ( Math.max ( 0, longestWord - currentWord.length ( ) ) ) );
                texts.offer ( currentWord.toString ( ) );

            } else {
                texts.offer ( currentWord.toString ( ) );

            }
        }
    }

    private static void fillQueue ( Queue<String> texts ) {
        String line = scanner.nextLine ( );

        while (!"END".equals ( line )) {
            texts.offer ( line );

            if ( line.length ( ) > longestWord ) {
                longestWord = line.length ( );

            }
            line = scanner.nextLine ( );

        }
    }
}
