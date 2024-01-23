import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class CountCharacterTypes {
    public static void main ( String[] args ) {

        Path inputPath = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt" );
        Path outputPath = Paths.get ( "C:\\Users\\35988\\Desktop\\output.txt" );

        try (BufferedReader inputStream = Files.newBufferedReader ( inputPath ) ;
             BufferedWriter outputStream = Files.newBufferedWriter ( outputPath )) {

            String line = inputStream.readLine ().toLowerCase( Locale.ROOT );

            int vowels = 0;
            int punctuation = 0;
            int other = 0;

            while (line != null){
                for ( char character: line.toCharArray () ){
                    if (character == ' '){
                        continue;
                    }
                    String type = isVowels(character) ? "vowel" : isPunctuation(character) ? "punctuation": "other";

                    switch (type){
                        case "vowel":
                            vowels++;
                            break;
                        case "punctuation":
                            punctuation++;
                            break;
                        case "other":
                            other++;
                            break;
                    }
                }
                line = inputStream.readLine ();
            }
            outputStream.write ( "Vowels: " + vowels );
            outputStream.newLine ();
            outputStream.write ( "Other symbols: " + other );
            outputStream.newLine ();
            outputStream.write ( "Punctuation: " + punctuation );

        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }

    private static boolean isPunctuation ( char character ) {
        return switch (character) {
            case '.', ',', '!', '?' -> true;
            default -> false;
        };
    }

    private static boolean isVowels ( char character ) {
        return switch (character) {
            case 'a', 'e', 'o', 'u', 'i' -> true;
            default -> false;
        };
    }
}
