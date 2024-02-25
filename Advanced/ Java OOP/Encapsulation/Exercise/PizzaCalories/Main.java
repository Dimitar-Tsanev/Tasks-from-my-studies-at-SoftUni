package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] pizzaData = scanner.nextLine ( ).split ( "\\s+" );

        try {
            Pizza pizza = new Pizza ( pizzaData[1], Integer.parseInt ( pizzaData[2] ) );

            String[] doughData = scanner.nextLine ( ).split ( "\\s+" );

            Dough dough = new Dough ( doughData[1], doughData[2], Double.parseDouble ( doughData[3] ) );

            pizza.setDough ( dough );

            String command = scanner.nextLine ( );

            while (!"END".equals ( command )) {
                String[] toppingData = command.split ( "\\s+" );

                Topping topping = new Topping ( toppingData[1], Double.parseDouble ( toppingData[2] ) );

                pizza.addTopping ( topping );

                command = scanner.nextLine ();
            }
            System.out.printf ("%s - %.2f", pizza.getName (), pizza.getOverallCalories () );

        } catch (IllegalArgumentException e) {
            System.out.println ( e.getMessage ( ) );

        }
    }
}
