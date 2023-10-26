package Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        int songsNumber = Integer.parseInt ( scan.nextLine () );

        List <Song> songs = new ArrayList<> ();

        for ( int i = 0 ; i < songsNumber ; i++ ) {
            String [] data = scan.nextLine ().split ( "_" );

            Song song = new Song ( data[0],data[1],data[2] );

            songs.add ( song );
        }
        String typeList = scan.nextLine ();
        if (!typeList.equals ( "all" )){
            for ( Song song: songs ) {
                if ( song.getTypeList ().equals ( typeList ) ){
                    System.out.println ( song.getName () );
                }
            }
        }else {
            for ( Song song: songs ) {
                System.out.println ( song.getName () );
            }
        }
    }
}
