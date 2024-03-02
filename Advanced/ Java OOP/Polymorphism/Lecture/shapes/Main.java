package shapes;

import java.util.List;

public class Main {
    public static void main ( String[] args ) {
        List<Shape> shapes = List.of ( new Rectangle ( 3.0,4.0 ),
        new Circle ( 2.5 ));

        printShapeInformation ( shapes );
    }
    private static void printShapeInformation (List<Shape> shapes){
        for ( Shape shape: shapes ){
            if("Rectangle".equals ( shape.getClass ().getSimpleName () )){
                Rectangle rectangle = (Rectangle) shape;
                System.out.println ( rectangle.getHeight () );
                System.out.println ( rectangle.getWidth () );

            } else if ( "Circle".equals ( shape.getClass ().getSimpleName () ) ) {
                Circle circle = (Circle) shape;
                System.out.println (circle.getRadius () );
            }
            System.out.println ( shape.getArea () );
            System.out.println ( shape.getPerimeter () );
        }
    }
}
