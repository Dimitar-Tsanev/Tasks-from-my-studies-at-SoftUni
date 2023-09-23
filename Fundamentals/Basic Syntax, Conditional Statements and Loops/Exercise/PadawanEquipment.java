import java.util.Scanner;

public class PadawanEquipment {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        double budget = Double.parseDouble ( scan.nextLine ( ) );
        int students = Integer.parseInt ( scan.nextLine ( ) );
        double saberPrice = Double.parseDouble ( scan.nextLine ( ) );
        double robePrice = Double.parseDouble ( scan.nextLine () );
        double beltPrice = Double.parseDouble ( scan.nextLine ( ) );
        double sabersTotalPrice = Math.ceil (students * 1.1) * saberPrice;
        double robesTotalPrice = students * robePrice;
        double beltsTotalPrice = (students - students/6) * beltPrice;
        double bill = sabersTotalPrice + beltsTotalPrice + robesTotalPrice;
        if(budget>=bill){
            System.out.printf ( "The money is enough - it would cost %.2flv.", bill );
        }else{
            double difference = Math.abs ( bill- budget );
            System.out.printf ( "George Lucas will need %.2flv more.", difference );
        }
    }
}
