package pointIn_rectangle;

class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle ( int bottomLeftX, int bottomLeftY, int topRightX, int topRightY ) {
        this.setBottomLeft ( new Point ( bottomLeftX, bottomLeftY ) );
        this.setTopRight ( new Point ( topRightX, topRightY ) );

    }

    public Point getBottomLeft () {
        return bottomLeft;
    }

    public void setBottomLeft ( Point bottomLeft ) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight () {
        return topRight;
    }

    public void setTopRight ( Point topRight ) {
        this.topRight = topRight;
    }

    public boolean contains ( Point point ) {
        boolean isInsideHorizontal = (point.getCoordinateHorizontal ( ) >= getBottomLeft ( ).getCoordinateHorizontal ( )) &&
                (point.getCoordinateHorizontal ( ) <= getTopRight ( ).getCoordinateHorizontal ( ));

        boolean isInsideVertical = (point.getCoordinateVertical ( ) >= getBottomLeft ( ).getCoordinateVertical ( )) &&
        (point.getCoordinateVertical ( ) <= getTopRight ( ).getCoordinateVertical ( ));

        return isInsideHorizontal && isInsideVertical;
    }
}
