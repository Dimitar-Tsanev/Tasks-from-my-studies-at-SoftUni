import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {
    public static void main ( String[] args ) {
        Path inputPath = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        try (BufferedReader reader = Files.newBufferedReader ( inputPath )){
            String line = reader.readLine ();
            long charSum = 0;
            while (line != null){
                for ( char character: line.toCharArray () ){
                    charSum +=character;
                }
                line = reader.readLine ( );
            }
            System.out.println ( charSum );
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
}
