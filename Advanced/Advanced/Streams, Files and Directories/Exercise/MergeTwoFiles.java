import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MergeTwoFiles {
    public static void main ( String[] args ) {
        Path input1Path = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt" );
        Path input2Path = Paths.get ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt" );
        String outputPath = "C:\\Users\\35988\\Desktop\\output.txt";

        try (PrintWriter output = new PrintWriter ( outputPath )){
            List<String> text1 = Files.readAllLines ( input1Path );
            List<String> text2 = Files.readAllLines ( input2Path );

            text1.addAll ( text2 );

            text1.forEach ( output::println );

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
}
