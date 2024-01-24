import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        UnaryOperator <Double> addVat = x -> x * 1.2;

        List<Double> pricesWithoutVAT = Arrays.stream( scanner.nextLine ().split ( ",\\s+" ) )
                .map ( Double::parseDouble )
                .collect( Collectors.toList());

        System.out.println ( "Prices with VAT:" );

        pricesWithoutVAT.forEach ( x -> System.out.printf (  "%.2f%n", addVat.apply ( x ) ));

    }
}
