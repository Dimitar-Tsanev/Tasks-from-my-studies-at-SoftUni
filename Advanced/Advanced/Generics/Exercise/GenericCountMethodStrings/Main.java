package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        List<Box<String>> boxes = new ArrayList<> ();

        int linesNumber = Integer.parseInt ( scanner.nextLine () );

        for ( int i = 0 ; i < linesNumber ; i++ ) {
            Box <String>box = new Box<> ( scanner.nextLine ()  );

            boxes.add (box );
        }

        Box <String> toCompare = new Box<> ( scanner.nextLine ()  );

        int counter = 0;
        for ( Box<String> box: boxes ){
            if(box.compare ( toCompare )){
                counter++;
            }
        }
        System.out.println ( counter );
    }
}
