import java.io.File;

public class ListFiles {
    public static void main ( String[] args ) {
        File file = new File ( "C:\\Users\\35988\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams" );

        if (file.exists ()){
            if (file.isDirectory ()) {
                File[] files = file.listFiles ();
                for ( File currentFile : files ){
                    if (!currentFile.isDirectory ()){
                        System.out.printf ( "%s: [%s]%n", currentFile.getName (), currentFile.length () );
                    }
                }
            }
        }

    }
}
