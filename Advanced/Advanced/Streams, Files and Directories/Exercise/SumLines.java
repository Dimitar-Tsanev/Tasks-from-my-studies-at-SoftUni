import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SumLines {
    public static void main ( String[] args ) {

        Path inputPath = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        try {
            List<String> lines = Files.readAllLines ( inputPath );
            for ( String line : lines ) {
                long sum = 0;
                for ( char current : line.toCharArray ( ) ) {
                    sum += current;
                }
                System.out.println ( sum );
            }

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
}
