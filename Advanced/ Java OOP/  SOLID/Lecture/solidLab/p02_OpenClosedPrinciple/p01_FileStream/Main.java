package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

import solidLab.p02_OpenClosedPrinciple.p01_FileStream.StreamableFiles.File;
import solidLab.p02_OpenClosedPrinciple.p01_FileStream.StreamableFiles.Music;
import solidLab.p02_OpenClosedPrinciple.p01_FileStream.StreamableFiles.interfaces.Streamable;

public class Main {
    public static void main(String[] args) {
        File file = new File ( "some name", 20 );
        Music musicFile = new Music ( "some song name", 10 );

        musicFile.setAlbum ( "album" );
        musicFile.setArtist ( "artist" );

        System.out.print ( "Current streaming " + file.getName () + System.lineSeparator ()  );
        streamFile ( file );

    }
    private static void streamFile ( Streamable streamable ) {
        Progress progress = new Progress ( streamable );

        do {
            System.out.print ( progress.getCurrentPercent ( ) + "%" + " ");

        } while (progress.getCurrentPercent ( ) < 100);
    }
}

