import java.io.File;
import java.util.Arrays;
import java.util.List;

public class GetFolderSize {
    public static void main ( String[] args ) {
        File file = new File ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        int filesSize = 0;
        if (file.exists ()) {
            if ( file.isDirectory ( ) ) {
                List<File> listFiles = Arrays.stream ( file.listFiles ( ) ).toList ( );
                for ( File currentFile : listFiles ){
                   filesSize += (int) currentFile.length ();
                }
            }
        }
        System.out.println ("Folder size: " + filesSize );
    }
}
