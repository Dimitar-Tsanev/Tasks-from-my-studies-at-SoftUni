package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] personsRegister = scanner.nextLine ( ).split ( ";" );

        List<Person> persons = new ArrayList<> ();

        for (String personDataSet: personsRegister){
            String[] dataElements = personDataSet.split ( "=" );
            String name = dataElements[0];
            double money = Double.parseDouble ( dataElements[1]);

            try {
                Person person = new Person ( name, money );
                persons.add ( person );

            }catch (IllegalArgumentException e){
                System.out.println ( e.getMessage () );

            }
        }

        String[] productCatalog = scanner.nextLine ( ).split ( ";" );

        List<Product> products = new ArrayList<> ();

        for (String productDataSet: productCatalog){
            String[] dataElements = productDataSet.split ( "=" );
            String name = dataElements[0];
            double cost = Double.parseDouble ( dataElements[1]);

            try {
                Product product = new Product ( name, cost );
                products.add ( product );

            }catch (IllegalArgumentException e){
                System.out.println ( e.getMessage () );

            }
        }

        String command = scanner.nextLine ( );

        while (!"END".equals ( command)){
            String personName = command.split ( " " )[0];
            String productName = command.split ( " " )[1];

            Person person = persons.stream ()
                    .filter ( p -> p.getName ().equals ( personName ) )
                    .findFirst ()
                    .orElse ( null );

            Product product = products.stream ()
                    .filter ( p -> p.getName ().equals ( productName ) )
                    .findFirst ()
                    .orElse ( null );

            if (person != null && product != null){
                try{
                    person.buyProduct ( product );
                    System.out.printf ( "%s bought %s%n",personName,productName);

                }catch (IllegalArgumentException e){
                    System.out.println (e.getMessage () );

                }
            }
            command = scanner.nextLine ( );
        }
        persons.forEach ( System.out::println );
    }
}
