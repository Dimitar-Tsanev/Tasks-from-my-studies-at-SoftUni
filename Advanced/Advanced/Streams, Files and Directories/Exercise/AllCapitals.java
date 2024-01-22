import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main ( String[] args ) {
        Path inputPath = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt" );
        String outputPath =  "C:\\Users\\35988\\Desktop\\output.txt";

        try(BufferedReader inputStream = Files.newBufferedReader ( inputPath );
            PrintWriter outputStream =  new PrintWriter ( outputPath )){
            String line = inputStream.readLine ();

            while (line != null) {

                outputStream.println ( line.toUpperCase (  ) );
                line =  inputStream.readLine ();
            }

        }catch (IOException e){
            e.printStackTrace ();

        }
    }
}
