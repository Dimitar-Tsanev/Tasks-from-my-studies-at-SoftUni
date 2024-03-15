import calculators.AmountCalculator;
import calculators.Calculator;
import calculators.CalorieCalculator;
import products.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Drink> drinks = List.of (
                new Coke ( 500 ),
                new Lemonade ( 200 ),
                new Coke ( 200 ) );

        List<Food> foods = List.of ( new Chips ( 150 ),
                new Chocolate ( 100 ),
                new Chocolate ( 100 ) );

        List<Product> products = new ArrayList<> ();
        products.addAll ( foods );
        products.addAll ( drinks );

        List<Calculator> calculators = List.of (
                new AmountCalculator ( products ),
                new AmountCalculator ( foods ),
                new AmountCalculator ( drinks ),
                new CalorieCalculator ( products ),
                new CalorieCalculator ( foods ),
                new CalorieCalculator ( drinks ));

        for ( Calculator calculator: calculators) {
            Printer.printSum ( calculator );
            Printer.printAverage ( calculator );

        }
    }
}
