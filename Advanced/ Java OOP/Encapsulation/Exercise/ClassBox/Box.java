package ClassBox;

class Box {
    private static final String ERROR_TEMPLATE = "%s cannot be zero or negative.";
    private double length;
    private double width;
    private double height;
    public Box ( double length, double width, double height ) {
        this.setLength ( length );
        this.setWidth ( width );
        this.setHeight ( height );
    }

    private void setLength ( double length ) {
        if (length <= 0){
            throw new IllegalArgumentException ( String.format ( ERROR_TEMPLATE,"Length" ) );
        }
        this.length = length;
    }

    private void setWidth ( double width ) {
        if (width <= 0){
            throw new IllegalArgumentException ( String.format ( ERROR_TEMPLATE,"Width" ) );
        }
        this.width = width;
    }

    private void setHeight ( double height ) {
        if (height <= 0){
            throw new IllegalArgumentException ( String.format ( ERROR_TEMPLATE,"Height" ) );
        }
        this.height = height;
    }

    public double calculateSurfaceArea () {
        return calculateLateralSurfaceArea () + (2 * this.length * this.width);
    }

    public double calculateLateralSurfaceArea () {
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateVolume () {
        return this.length * this.width * this.height;
    }
}
