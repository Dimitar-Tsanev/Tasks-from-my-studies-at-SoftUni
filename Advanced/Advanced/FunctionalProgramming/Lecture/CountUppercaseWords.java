import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Predicate <String> isFirstLetterUppercase = x -> Character.isUpperCase ( x.charAt ( 0 ) );

        List<String> words = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .filter ( isFirstLetterUppercase )
                .collect( Collectors.toList());

        System.out.println (words.size () );

        words.forEach ( System.out::println );
    }
}
