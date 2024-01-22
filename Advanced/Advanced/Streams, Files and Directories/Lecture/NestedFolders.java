import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class NestedFolders {
    public static void main ( String[] args ) {
        File file = new File ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams" );

        Queue <File> directories = new ArrayDeque<> (  );
        directories.offer ( file );

        int counter = 1;

        while (!directories.isEmpty ()){
            File currentFile = directories.poll ();
            File[] nestedFiles = currentFile.listFiles ();
            for ( File nestedFile: nestedFiles  ){
                if (nestedFile.isDirectory ()){
                    directories.offer ( nestedFile );
                    counter++;

                }
            }
            System.out.println (currentFile.getName () );

        }
        System.out.println ( counter + " folders" );
    }
}
