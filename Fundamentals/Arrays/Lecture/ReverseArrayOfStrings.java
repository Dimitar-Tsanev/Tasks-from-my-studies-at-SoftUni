package Lecture;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String input = scan.nextLine ();
        String [] items = input.split ( " " );
        for ( int position = 0 ; position < items.length/2 ; position++ ) {
           String elementSave = items[position];
           items [position] = items [items.length - 1 - position];
           items [items.length - 1 - position] = elementSave;
        }
        System.out.println (String.join ( " ", items ) );
    }
}
