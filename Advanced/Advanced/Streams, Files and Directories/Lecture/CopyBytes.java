import java.io.*;

public class CopyBytes {
    public static void main ( String[] args ) {
        String inputPath = "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\35988\\Desktop\\output.txt";

        try (InputStream fileInputStream = new FileInputStream ( inputPath );
             OutputStream outputStream = new FileOutputStream ( outputPath )){

            int oneByte;
            while ((oneByte = fileInputStream.read ()) >=0){
                if (oneByte == 10 || oneByte == 32){
                    outputStream.write ( oneByte );

                }else{
                    String asciiCode = String.valueOf ( oneByte );
                    for ( char element: asciiCode.toCharArray () ){
                        outputStream.write ( element );

                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace ();

        }
    }
}
