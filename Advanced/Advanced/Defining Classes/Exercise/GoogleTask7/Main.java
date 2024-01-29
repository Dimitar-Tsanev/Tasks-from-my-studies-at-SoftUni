package GoogleTask7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        List<Person> persons = new ArrayList<> ( );

        String line = scanner.nextLine ( );

        while (!"End".equals ( line )) {
            String[] personalData = line.split ( "\\s+" );

            String name = personalData[0];
            String command = personalData[1];

            Person person = new Person ( name );

            if ( !persons.contains ( person ) ) {
                persons.add ( person );

            }else{
                int indexOfPerson = persons.indexOf ( person);
                person = persons.get ( indexOfPerson );

            }

            switch (command) {
                case "company":
                    addCompany(person, personalData);
                    break;
                case "pokemon":
                    addPokemon(person,personalData);
                    break;
                case "parents":
                    addParents(person,personalData);
                    break;
                case "children":
                    addChildren(person,personalData);
                    break;
                case "car":
                    addCar(person,personalData);
                    break;

            }
            if ( !persons.contains ( person ) ) {
                persons.add ( person );

            }else{
                persons.remove ( person );
                persons.add ( person );
            }

            line = scanner.nextLine ( );
        }
        line = scanner.nextLine ( );

        Person wantedPerson = getPerson(persons,line);
        System.out.println ( wantedPerson );
    }

    private static Person getPerson ( List<Person> persons, String line ) {
        for ( Person person: persons) {
            if (person.getName ().equals ( line )){
                return person;
            }
        }
        return new Person ( line );
    }

    private static void addCar ( Person person, String[] personalData ) {
        String model = personalData[2];
        int speed = Integer.parseInt ( personalData [3]);

        person.setCar ( model,speed );
    }

    private static void addChildren ( Person person, String[] personalData ) {
        String childrenName = personalData[2];
        String childrenBirthday = personalData [3];

        person.addChildren ( childrenName,childrenBirthday );
    }

    private static void addParents ( Person person, String[] personalData ) {
        String parentName = personalData[2];
        String parentBirthday = personalData [3];

        person.addParent ( parentName,parentBirthday );
    }

    private static void addPokemon ( Person person, String[] personalData ) {
        String pokemonName = personalData[2];
        String pokemonElement = personalData [3];

        person.addPokemon ( pokemonName,pokemonElement );

    }

    private static void addCompany ( Person person, String[] personalData ) {
        String companyName = personalData[2];
        String department = personalData [3];
        double salary = Double.parseDouble ( personalData[4] );

        person.setCompany ( companyName,department,salary );
    }
}
