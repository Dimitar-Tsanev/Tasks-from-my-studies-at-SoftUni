package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

import java.util.List;

class Main {
    public static void main ( String[] args ) {
        List<Shape> shapes = List.of ( new Rectangle ( ),new Circle () );

        shapes.forEach ( s-> new DrawingManagerImpl ( s ).draw () );

    }
}
