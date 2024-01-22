import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main ( String[] args ) {
        String inputPath = "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\35988\\Desktop\\output.txt";


        try (Scanner scanner = new Scanner ( new FileInputStream (inputPath) );
             PrintWriter output = new PrintWriter ( new FileOutputStream ( outputPath ) )) {
            while (scanner.hasNext ( )){
                if ( scanner.hasNextInt ( ) ){
                    output.println ( scanner.nextInt () );
                }
                scanner.next ();

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException ( e );

        }
    }
}
