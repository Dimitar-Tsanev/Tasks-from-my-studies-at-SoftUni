import java.util.*;

public class CompanyUsers {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        LinkedHashMap <String, List <String>> companyEmploy = new LinkedHashMap<> ();

        String input = scanner.nextLine ();

        while (!input.equals ( "End" )){
            String [] data = Arrays.stream( input.split ( " " ) ).filter ( e -> !e.equals ( "->" ) ).toArray ( String[]::new );
            String company = data[0];
            String employID = data[1];

            if(!companyEmploy.containsKey ( company )){
                companyEmploy.put ( company, new ArrayList<> () );
                companyEmploy.get ( company ).add ( employID );

            }else{
                if( !companyEmploy.get ( company ).contains ( employID )) {
                    companyEmploy.get ( company ).add ( employID );
                }
            }
            input = scanner.nextLine ( );
        }
        for ( Map.Entry<String, List<String>> company: companyEmploy.entrySet () ) {
            System.out.println ( company.getKey ());
            for ( String employ: company.getValue () ) {
                System.out.printf ( "-- %s%n", employ );
            }
        }
    }
}
