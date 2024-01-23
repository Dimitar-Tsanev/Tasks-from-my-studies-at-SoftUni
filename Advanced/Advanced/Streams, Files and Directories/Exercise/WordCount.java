import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class WordCount {
    public static void main ( String[] args ) {

        Set<String> wordsToFind = new HashSet<> (  );
        Map<String, Integer> wordsCounter = new LinkedHashMap<> (  );

        readWordsToFind ( wordsToFind );
        findWordsInText ( wordsToFind,wordsCounter );

        Map<String, Integer> sortedByBiggerValue = wordsCounter.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        printToFile(sortedByBiggerValue);

    }

    private static void printToFile ( Map<String, Integer> sortedByBiggerValue ) {
        String outputPath = "C:\\Users\\35988\\Desktop\\output.txt";

        try(PrintWriter output = new PrintWriter ( outputPath )){
            sortedByBiggerValue.forEach ( (k,v ) -> output.println (  k + " - " + v ));

        }catch (IOException e){
            e.printStackTrace ();
        }
    }

    private static void findWordsInText( Set<String> wordsToFind, Map<String, Integer> wordsCounter){
        Path inputPath  = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        try(BufferedReader input = Files.newBufferedReader ( inputPath )) {
            String line = input.readLine ( );

            while (line != null) {
                String[] words = line.split ( "\\s+" );
                for ( String word : words ) {
                    if ( wordsToFind.contains ( word ) ) {
                        wordsCounter.putIfAbsent ( word, 0 );
                        wordsCounter.put ( word, wordsCounter.get ( word ) + 1 );
                    }
                }
                line = input.readLine ( );
            }
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    private static void readWordsToFind (Set<String> wordsToFind){
        Path readWords = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        try (BufferedReader reader = Files.newBufferedReader ( readWords )){
            String line = reader.readLine ();

            while (line != null) {

                String[] words = line.split ( "\\s+" );
                wordsToFind.addAll ( List.of ( words ) );

                line = reader.readLine ();
            }

        }catch (IOException e){
            e.printStackTrace ();

        }
    }
}
