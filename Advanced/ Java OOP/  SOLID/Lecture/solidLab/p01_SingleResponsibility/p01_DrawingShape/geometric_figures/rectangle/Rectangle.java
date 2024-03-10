package solidLab.p01_SingleResponsibility.p01_DrawingShape.geometric_figures.rectangle;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderable;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Rectangle implements Shape, Renderable {
    private double width;
    private double height;
    private double area;
    private StringBuilder renderedRectangle;

    public Rectangle ( double width, double height ) {
        this.setWidth ( width );
        this.setHeight ( height );
        this.setArea ( );
        this.setRenderedRectangle (  );
    }

    private void setHeight ( double height ) {
        if ( height <= 0 ) {
            throw new IllegalArgumentException ( "Rectangle height must be positive number!" );
        }
        this.height = height;
    }

    private void setWidth ( double width ) {
        if ( width <= 0 ) {
            throw new IllegalArgumentException ( "Rectangle width must be positive number!" );
        }
        this.width = width;
    }
    private void setRenderedRectangle () {
        this.renderedRectangle = RectangleRender.renderRectangle (this.getWidth (), this.getHeight ());
    }
    private void setArea (  ) {
        this.area = RectangleMathOperations.calculateRectangleArea ( this.getWidth (), this.getHeight () ) ;
    }
    public double getWidth () {
        return this.width;
    }

    public double getHeight () {
        return this.height;
    }

    @Override
    public double getArea () {
        return this.area;
    }

    @Override
    public StringBuilder render () {
        return this.renderedRectangle;
    }
}
