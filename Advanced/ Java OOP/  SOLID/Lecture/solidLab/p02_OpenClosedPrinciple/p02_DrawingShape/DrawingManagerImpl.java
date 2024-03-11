package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.DrawingManager;
import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;


class DrawingManagerImpl implements DrawingManager {

    private final Shape shape;

    public DrawingManagerImpl (Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw ( ) {
        System.out.println ( this.shape.getShape () );
    }

}
