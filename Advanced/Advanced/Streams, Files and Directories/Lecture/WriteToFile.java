import java.io.*;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {
    public static void main ( String[] args ) {
        String inputPath = "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\35988\\Desktop\\output.txt";

        List<Character> punctuations = Arrays.asList(',', '.', '!', '?');


        try (InputStream fileInputStream = new FileInputStream ( inputPath ) ;
             OutputStream fileOutputStream = new FileOutputStream ( outputPath )) {

            int oneByte = 0;

            while ((oneByte = fileInputStream.read (  )) >=0){
                if (!punctuations.contains( ( char )oneByte)){
                    fileOutputStream.write ( oneByte );
                }
            }

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
}
