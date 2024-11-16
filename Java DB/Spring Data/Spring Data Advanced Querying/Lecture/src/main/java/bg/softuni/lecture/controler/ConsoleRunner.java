package bg.softuni.lecture.controler;

import bg.softuni.lecture.data.entities.Ingredient;
import bg.softuni.lecture.data.entities.Label;
import bg.softuni.lecture.data.entities.Shampoo;
import bg.softuni.lecture.data.service.interfaces.IngredientService;
import bg.softuni.lecture.data.service.interfaces.LabelService;
import bg.softuni.lecture.data.service.interfaces.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final BufferedReader READER = new BufferedReader ( new InputStreamReader ( System.in ) );

    private final IngredientService ingredientService;
    private final LabelService labelService;
    private final ShampooService shampooService;

    @Autowired
    public ConsoleRunner( IngredientService ingredientService,
                          LabelService labelService,
                          ShampooService shampooService ) {

        this.ingredientService = ingredientService;
        this.labelService = labelService;
        this.shampooService = shampooService;

    }

    @Override
    public void run ( String... args ) throws Exception {
        //selectShampoosBySize();
        //selectShampoosBySizeOrLabel ();
        //selectShampoosWithPriceHigherThan ();
        //selectIngredientsStartWithLetter ();
        //selectIngredientsByNameOrderedByPrice ();
        //getShampoosCountByPrice ();
        //getShampoosByIngredients ();
        //getShampoosByIngredientCount ();
        //deleteIngredientByName ();
        //increaseIngredientsPriceWithTenPercent ();
        increaseIngredientsPriceByName ();

    }

    //1.Select Shampoos by Size
    private void selectShampoosBySize () throws IOException {
        String size = READER.readLine ();

        shampooService.getShampooBySize(size)
                .stream ( )
                .map ( Shampoo::toStringShampooIngredients )
                .forEach ( System.out::println );
    }

    //2.Select Shampoos by Size or Label
    private void selectShampoosBySizeOrLabel () throws IOException {
        System.out.println ( "Enter size:" );
        String size = READER.readLine ().toUpperCase (  );

        System.out.println ( "Enter label title:" );
        String labelTitle = READER.readLine ();

        Label label = labelService.getByTitle ( labelTitle ).orElse ( null );
        if ( label == null ) {
            System.out.println ( "Label id dose not exists" );

        }else{
            shampooService.getShampooBySizeOrLabel ( size, label ).stream ( )
                    .map ( Shampoo::toStringShampooIngredients )
                    .forEach ( System.out::println );
        }
    }

    //3.Select Shampoos by Price
    private void selectShampoosWithPriceHigherThan  () throws IOException {
        System.out.println ( "Enter price:" );
        double price = Double.parseDouble ( READER.readLine ());

        shampooService.getShampooByPriceGreaterThan (price ).stream ()
                .map ( Shampoo::toString )
                .forEach ( System.out::println );

    }

    //4.Select Ingredients by Name
    private void selectIngredientsStartWithLetter () throws IOException {
        char character = READER.readLine ().charAt ( 0 );

        ingredientService.getByStartLetter(character).stream()
                .map( Ingredient::getName )
                .forEach ( System.out::println );
    }

    /*5.Select Ingredients by Names -
     Create a method that selects all ingredients, which are contained in a given list.
     Sort the result ascending by price.*/
    private void selectIngredientsByNameOrderedByPrice() throws IOException {
        List<String> ingredientsNames = new ArrayList<> ();
        System.out.println ( "Enter ingredient name, or stop to exit" );
        String line = READER.readLine ();

        while (!"stop".equalsIgnoreCase ( line )) {
            ingredientsNames.add ( line );
            System.out.println ( "Enter ingredient name, or stop to exit" );
            line = READER.readLine ();
        }
        ingredientService.getIngredientsByNameOrderedByPrice( ingredientsNames )
                .stream ()
                .map ( Ingredient::getName )
                .forEach ( System.out::println );

    }

    //6.Count Shampoos by Price -
    //Create a method that counts all shampoos with price lower than a given price.
    private void getShampoosCountByPrice () throws IOException {
        System.out.println ( "Enter shampoo price:" );
        double price = Double.parseDouble ( READER.readLine ());

        System.out.println ( shampooService.getShampooCountWithPriceLowerThan ( price ));
    }

    //7.Select Shampoos by Ingredients
    private void getShampoosByIngredients () throws IOException {
        Set<String> ingredientsNames = readIngredients ();

        ingredientService.getShampooWithIngredients(ingredientsNames)
                .stream()
                .map(Shampoo::getBrand)
                .forEach( System.out::println);
    }

    //8.Select Shampoos by Ingredients Count
    private void getShampoosByIngredientCount() throws IOException {
        int count = Integer.parseInt( READER.readLine () );

        shampooService.getShampooWithIngredientCount(count)
                .stream()
                .map(Shampoo::getBrand)
                .forEach( System.out::println);
    }

    //9.Delete Ingredients by Name
    private void deleteIngredientByName () throws IOException {
        ingredientService.deleteIngredient ( READER.readLine () );
    }

    //10.Update Ingredients by Price
    private void increaseIngredientsPriceWithTenPercent ()  {
        ingredientService.increasePriceWithTenPercents();
    }

    //11.Update Ingredients by Names
    private void increaseIngredientsPriceByName () throws IOException {
        Set<String> ingredientsNames = readIngredients ();

        ingredientService.updatePriceOfIngredientsWithNames(ingredientsNames);
    }

    private Set<String> readIngredients () throws IOException {
        Set<String> ingredientsNames = new HashSet<> ();
        System.out.println ( "Enter ingredient name, or stop to exit" );
        String line = READER.readLine ();

        while (!"stop".equalsIgnoreCase ( line )) {
            ingredientsNames.add ( line );
            System.out.println ( "Enter ingredient name, or stop to exit" );
            line = READER.readLine ();
        }
        return ingredientsNames;
    }
}
