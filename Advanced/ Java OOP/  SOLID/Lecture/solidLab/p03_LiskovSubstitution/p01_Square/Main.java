package solidLab.p03_LiskovSubstitution.p01_Square;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = List.of ( new Rectangle (2.3,5),new Square ( 2.5 ) );

        shapes.forEach ( s-> System.out.println (s.getArea () ) );
    }
}
