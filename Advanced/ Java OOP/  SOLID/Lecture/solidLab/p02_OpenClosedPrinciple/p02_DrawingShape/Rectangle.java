package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

class Rectangle implements Shape {
    private final String shape;

    public Rectangle () {
        this.shape = "࿕";
    }

    @Override
    public String getShape () {
        return this.shape;
    }
}
