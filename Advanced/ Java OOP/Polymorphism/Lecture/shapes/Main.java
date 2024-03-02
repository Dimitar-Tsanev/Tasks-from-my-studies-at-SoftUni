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
            if( shape instanceof Rectangle rectangle ){
                System.out.println ( rectangle.getHeight () );
                System.out.println ( rectangle.getWidth () );

            } else if ( shape instanceof Circle circle  ) {
                System.out.println (circle.getRadius () );
            }
            System.out.println ( shape.getArea () );
            System.out.println ( shape.getPerimeter () );
        }
    }
}
