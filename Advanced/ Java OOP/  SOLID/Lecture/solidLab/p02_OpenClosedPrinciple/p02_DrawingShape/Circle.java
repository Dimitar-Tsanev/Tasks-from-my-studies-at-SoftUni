package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

class Circle implements Shape {

    private final String shape;

    public Circle () {
        this.shape = "◯";
    }

    @Override
    public String getShape () {
        return this.shape;
    }
}
