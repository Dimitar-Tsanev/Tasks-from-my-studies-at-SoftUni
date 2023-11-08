import java.util.Scanner;

public class ExtractFile {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String filePath = scanner.nextLine ();

        int indexOfFileName = filePath.lastIndexOf ( "\\" ) + 1;
        int indexOfFileDot = filePath.indexOf ( "." );

        System.out.printf ( "File name: %s%n", filePath.substring ( indexOfFileName,indexOfFileDot ) );
        System.out.printf ( "File extension: %s%n", filePath.substring ( indexOfFileDot + 1 ) );
    }
}