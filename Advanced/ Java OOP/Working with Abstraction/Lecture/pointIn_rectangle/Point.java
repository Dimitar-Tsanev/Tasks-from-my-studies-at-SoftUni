package pointIn_rectangle;

class Point {
    private int coordinateHorizontal;
    private int coordinateVertical;

    public Point ( int coordinateHorizontal, int coordinateVertical ) {
        this.setCoordinateHorizontal ( coordinateHorizontal );
        this.setCoordinateVertical ( coordinateVertical );

    }

    public int getCoordinateHorizontal () {
        return coordinateHorizontal;
    }

    public int getCoordinateVertical () {
        return coordinateVertical;
    }

    public void setCoordinateHorizontal ( int coordinateHorizontal ) {
        this.coordinateHorizontal = coordinateHorizontal;
    }

    public void setCoordinateVertical ( int coordinateVertical ) {
        this.coordinateVertical = coordinateVertical;
    }
}
