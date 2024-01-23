import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Set;

public class CountCharacterTypesSecondWay {
    public static void main ( String[] args ) {

        Path inputPath = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt" );
        Path outputPath = Paths.get ( "C:\\Users\\35988\\Desktop\\output.txt" );

        Set<Character> vowelsSet = Set.of ( 'a', 'e', 'i', 'o', 'u'  );
        Set<Character> punctuationSet = Set.of ( '.',',','!','?' );

        try (BufferedReader inputStream = Files.newBufferedReader ( inputPath ) ;
             BufferedWriter outputStream = Files.newBufferedWriter ( outputPath )) {

            String line = inputStream.readLine ( ).toLowerCase ( Locale.ROOT );

            int vowels = 0;
            int punctuation = 0;
            int other = 0;

            while (line != null) {
                for ( char character : line.toCharArray ( ) ) {

                    if ( vowelsSet.contains ( character ) ) {
                        vowels++;

                    } else if ( punctuationSet.contains ( character ) ) {
                        punctuation++;

                    }else if ( !Character.isWhitespace ( character ) ){
                        other++;

                    }
                }
                line = inputStream.readLine ( );
            }
            outputStream.write ( "Vowels: " + vowels );
            outputStream.newLine ( );
            outputStream.write ( "Other symbols: " + other );
            outputStream.newLine ( );
            outputStream.write ( "Punctuation: " + punctuation );

        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }
}