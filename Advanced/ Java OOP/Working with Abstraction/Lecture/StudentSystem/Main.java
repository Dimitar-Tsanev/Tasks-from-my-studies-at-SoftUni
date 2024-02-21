package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem ();

        String[] input = scanner.nextLine().split(" ");

        String command = input[0];

        while (!"Exit".equals(command)) {
            String name = input[1];

            if ("Create".equals ( command )){
                int age = Integer.parseInt(input[2]);
                double grade = Double.parseDouble(input[3]);

                Student student = new Student ( name,age,grade );

                studentSystem.addStudent ( student );

            } else if ( "Show".equals ( command ) ) {
                System.out.println ( studentSystem.info ( name ) );

            }

            input = scanner.nextLine().split(" ");
            command = input[0];
        }
    }
}
