import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        double width = Double.parseDouble ( scan.nextLine () );
        double height = Double.parseDouble ( scan.nextLine ( ) );
        double area = rectangleAreaCalculator ( width,height );
        System.out.printf ( "%.0f", area );
    }
    public static double rectangleAreaCalculator (double width, double height){
        return width * height;
    }
}
