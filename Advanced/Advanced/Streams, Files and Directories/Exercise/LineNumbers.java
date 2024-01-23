import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main ( String[] args ) {
        Path inputPath = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt" );
        String outputPath = "C:\\Users\\35988\\Desktop\\output.txt";

        try(BufferedReader input = Files.newBufferedReader ( inputPath );
        PrintWriter output = new PrintWriter ( outputPath )){

            String line = input.readLine ();
            int counter = 0;

            while(line != null){
                counter++;
                output.println ( counter + ". " + line );
                line = input.readLine ();
            }

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
}
