package solidLab.p01_SingleResponsibility.p01_DrawingShape.geometric_figures.rectangle;

class RectangleRender {
    private RectangleRender () {
    }
    static StringBuilder renderRectangle (double width, double height ){
        StringBuilder shapeBuilder = new StringBuilder ( );

        for ( int vertical = 1 ; vertical <= height ; vertical++ ) {
            for ( int horizontal = 1 ; horizontal <= width ; horizontal++ ) {
                shapeBuilder.append ( "* " );

            }
            shapeBuilder.append ( System.lineSeparator ( ) );
        }
        return shapeBuilder;
    }
}
