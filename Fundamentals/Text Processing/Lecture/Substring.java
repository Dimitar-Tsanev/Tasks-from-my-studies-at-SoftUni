import java.util.Scanner;

public class Substring {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String keyWord = scanner.nextLine ( );

        String text = scanner.nextLine ( );

        while (text.contains ( keyWord )) {

            text = text.replace ( keyWord, "" );
        }
        System.out.println ( text  );
    }
}
