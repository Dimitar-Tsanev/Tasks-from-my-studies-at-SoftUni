import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String currentURl = scanner.nextLine ();

        ArrayDeque <String> history = new ArrayDeque<> ();

        while (!"Home".equals ( currentURl )){
            if ("back".equals ( currentURl )){

                if  ( history.size () <= 1 ){
                    System.out.println ( "no previous URLs" );

                }else {
                    history.pop ();
                    System.out.println (history.peek ());

                }
            }else{
                history.push ( currentURl );
                System.out.println ( history.peek () );

            }
            currentURl = scanner.nextLine ();
        }
    }
}
