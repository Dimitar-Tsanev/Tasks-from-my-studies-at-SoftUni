package animals;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String command = scanner.nextLine ( );

        while (!"Beast!".equals ( command )) {
            String[] animalData = scanner.nextLine ( ).split ( "\\s+" );
            try {
                switch (command) {
                    case "Dog":
                        Dog dog = new Dog ( animalData[0], Integer.parseInt ( animalData[1] ), animalData[2] );
                        System.out.println (dog );
                        break;
                    case "Cat":
                        Cat cat = new Cat ( animalData[0], Integer.parseInt ( animalData[1] ), animalData[2] );
                        System.out.println (cat );
                        break;
                    case "Frog":
                        Frog frog = new Frog ( animalData[0], Integer.parseInt ( animalData[1] ), animalData[2] );
                        System.out.println (frog );
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten ( animalData[0], Integer.parseInt ( animalData[1] ) );
                        System.out.println (kitten );

                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat ( animalData[0], Integer.parseInt ( animalData[1] ) );
                        System.out.println (tomcat );
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println ( e.getMessage ( ) );

            }
            command = scanner.nextLine ( );
        }
    }
}


