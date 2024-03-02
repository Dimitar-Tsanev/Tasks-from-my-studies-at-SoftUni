package shapes;

class Circle extends Shape{
    private Double radius;

    public Circle ( Double radius ) {
        this.setRadius ( radius );
        this.calculatePerimeter ();
        this.calculateArea ();
    }

    private void setRadius ( Double radius ) {
        this.radius = radius;
    }

    public final Double getRadius () {
        return radius;
    }

    @Override
    protected void calculatePerimeter () {
        setPerimeter (  2 * Math.PI * this.radius);
    }

    @Override
    protected void calculateArea () {
        setArea ( Math.PI * Math.pow ( this.radius,2 ));
    }
}
