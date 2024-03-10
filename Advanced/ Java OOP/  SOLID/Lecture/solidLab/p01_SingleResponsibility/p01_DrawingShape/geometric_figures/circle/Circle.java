package solidLab.p01_SingleResponsibility.p01_DrawingShape.geometric_figures.circle;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderable;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Circle implements Shape, Renderable {
    private double radius;
    private double area;
    private StringBuilder renderedCircle;
    public Circle ( double radius ) {
        this.setRadius ( radius );
        this.setArea ();
        this.setRenderedCircle ();
    }
    private void setRadius ( double radius ) {
        if (radius <= 0){
            throw new IllegalArgumentException ( "Radius must be positive number!" );
        }
        this.radius = radius;
    }

    private void setArea ( ) {
        this.area = CircleMathOperations.calculateCircleArea ( this.getRadius () );
    }

    private void setRenderedCircle (  ) {
        this.renderedCircle = CircleRender.renderCircle ( this.getRadius ());
    }

    public double getRadius () {
        return this.radius;
    }

    @Override
    public StringBuilder render () {
        return this.renderedCircle;
    }
    @Override
    public double getArea () {
        return this.area;
    }
}
