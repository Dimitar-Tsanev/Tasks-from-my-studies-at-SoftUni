import java.util.*;

public class ListOfProducts {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int productsCount = Integer.parseInt ( scan.nextLine () );
        List <String> products = new ArrayList<> (  );
        for ( int i = 0 ; i < productsCount ; i++ ) {
            products.add ( scan.nextLine () );
        }
        Collections.sort ( products);
        for ( int i = 1 ; i <=products.size ()  ; i++ ) {
            products.set ( i - 1, i + "." +  products.get ( i -1 ) );
        }
        for ( String element: products ) {
            System.out.println ( element );
        }
    }
}
