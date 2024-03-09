package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

class Rectangle implements Shape, Renderer {
    private double width;
    private double height;
    private double area;

    public Rectangle ( double width, double height ) {
        this.setWidth ( width );
        this.setHeight ( height );
        this.setArea ( ShapesMathOperations.calculateRectangleArea ( width, height ) );

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

    private void setArea ( double area ) {
        this.area = area;
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
        StringBuilder shapeBuilder = new StringBuilder ( );

        for ( int vertical = 1 ; vertical <= this.getHeight ( ) ; vertical++ ) {
            for ( int horizontal = 1 ; horizontal <= this.getWidth ( ) ; horizontal++ ) {
                shapeBuilder.append ( "* " );

            }
            shapeBuilder.append ( System.lineSeparator ( ) );
        }
        return shapeBuilder;
    }
}
