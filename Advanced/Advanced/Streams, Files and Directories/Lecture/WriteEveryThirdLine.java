import java.io.*;

public class WriteEveryThirdLine {
    public static void main ( String[] args ) {
        String inputPath = "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\35988\\Desktop\\output.txt";

        try (BufferedReader input = new BufferedReader (new FileReader ( inputPath )) ;
             PrintWriter output = new PrintWriter ( outputPath )) {

            String lineIn = input.readLine ();
            int counter = 1;
            while (null != lineIn){
                if (counter % 3 == 0){
                    output.println ( lineIn);

                }
                lineIn = input.readLine ();
                counter++;
            }

        } catch (IOException e) {
            throw new RuntimeException ( e );
        }
    }
}
