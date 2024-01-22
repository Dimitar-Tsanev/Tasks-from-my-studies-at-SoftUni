import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main ( String[] args ) {
        Path inputPath = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt" );
        Path outputPath = Paths.get ( "C:\\Users\\35988\\Desktop\\output.txt" );

        try {
            List<String> textLines = Files.readAllLines ( inputPath);

            textLines = textLines.stream ().filter(l ->!l.isBlank()).collect( Collectors.toList());

            Collections.sort ( textLines );

            Files.write ( outputPath,textLines );

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
}
