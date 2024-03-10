package solidLab.p01_SingleResponsibility.p01_DrawingShape.geometric_figures.circle;

class CircleRender {
    private CircleRender () {
    }

    static StringBuilder renderCircle ( double radius ) {
        StringBuilder shapeBuilder = new StringBuilder ( );
        int rad = (int) Math.round ( radius );

        int diameter= 2 * rad;
        int xCoord, yCoord, point;

        for ( int row = 0 ; row <= diameter ; row++ ) {
            for ( int col = 0 ; col <= diameter ; col++ ) {
                xCoord = rad - row;
                yCoord = rad - col;
                point = xCoord * xCoord + yCoord * yCoord;

                if ( point <= rad * rad + 1 ) {
                    shapeBuilder.append ( "* " );

                } else {
                    shapeBuilder.append ( "  " );

                }
            }
            shapeBuilder.append ( System.lineSeparator ( ) );
        }

        return shapeBuilder;
    }
}
