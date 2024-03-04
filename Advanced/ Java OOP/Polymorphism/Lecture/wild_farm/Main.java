package wild_farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ( );
        List<Animal> animals = new ArrayList<> ( );

        while (!"End".equals ( input )) {
            String[] animalData = input.split ( "\\s+" );
            String[] foodData = scanner.nextLine ( ).split ( "\\s+" );

            Animal animal = createAnimal ( animalData );
            Food food = createFood ( foodData );

            animal.makeSound ( );
            animal.eat ( food );

            animals.add ( animal );

            input = scanner.nextLine ( );
        }
        animals.forEach ( System.out::println );
    }

    private static Animal createAnimal ( String[] animalData ) {
        switch (animalData[0]) {
            case "Cat":
                return new Cat (
                        animalData[1],
                        animalData[0],
                        Double.parseDouble ( animalData[2] ),
                        animalData[3],
                        animalData[4] );

            case "Tiger":
                return new Tiger (
                        animalData[1],
                        animalData[0],
                        Double.parseDouble ( animalData[2] ),
                        animalData[3] );

            case "Zebra":
                return new Zebra (
                        animalData[1],
                        animalData[0],
                        Double.parseDouble ( animalData[2] ),
                        animalData[3] );

            case "Mouse":
                return new Mouse (
                        animalData[1],
                        animalData[0],
                        Double.parseDouble ( animalData[2] ),
                        animalData[3] );

            default:
                return null;
        }
    }

    private static Food createFood ( String[] foodData ) {

        if ( "Vegetable".equals ( foodData[0] ) ) {
            return new Vegetable ( Integer.parseInt ( foodData[1] ) );

        } else if ( "Meat".equals ( foodData[0] ) ) {
            return new Meat ( Integer.parseInt ( foodData[1] ) );

        } else {
            return null;
        }
    }
}
