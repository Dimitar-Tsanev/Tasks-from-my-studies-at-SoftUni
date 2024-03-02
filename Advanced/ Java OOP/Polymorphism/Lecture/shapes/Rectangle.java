package shapes;

class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle ( Double height, Double width ) {
        this.setHeight ( height );
        this.setWidth ( width );
        this.calculatePerimeter ();
        this.calculateArea ();
    }

    private void setHeight ( Double height ) {
        this.height = height;
    }

    private void setWidth ( Double width ) {
        this.width = width;
    }

    public Double getHeight () {
        return height;
    }

    public Double getWidth () {
        return width;
    }

    @Override
    protected void calculatePerimeter () {
        setPerimeter ( 2 * (this.width + this.height));
    }

    @Override
    protected void calculateArea () {
        setArea ( this.width * this.height);
    }
}
