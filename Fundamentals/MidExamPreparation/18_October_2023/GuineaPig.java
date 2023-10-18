import java.util.Scanner;

public class GuineaPig {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        double foodKg = Double.parseDouble ( scan.nextLine () );
        double hayKg = Double.parseDouble ( scan.nextLine () );
        double coverKg = Double.parseDouble ( scan.nextLine () );
        double guineaPigWeightKg = Double.parseDouble ( scan.nextLine ( ) );

        double foodInGrams = foodKg * 1000;
        double hayInGrams = hayKg * 1000;
        double coverInGrams = coverKg * 1000;
        double guineaPigWeightInGrams = guineaPigWeightKg * 1000;

        for ( int i = 1 ; i <= 30  ; i++ ) {
            foodInGrams -= 300;
            if (i % 2 == 0){
                hayInGrams -= foodInGrams * 0.05;
            }
            if ( i % 3 == 0 ) {
                coverInGrams -= guineaPigWeightInGrams / 3;
            }
            if (foodInGrams <= 0 || hayInGrams <= 0 || coverInGrams <= 0){
                System.out.println ( "Merry must go to the pet store!" );
                return;
            }
        }
        foodKg = foodInGrams / 1000;
        hayKg = hayInGrams / 1000;
        coverKg = coverInGrams / 1000;
        System.out.printf ( "Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n",foodKg, hayKg, coverKg  );
    }
}
