package solidLab.p03_LiskovSubstitution.p01_Square;

class Rectangle implements Shape {
   private double width;
   private double height;
   private double area;
    public Rectangle ( double width, double height ) {
        this.setWidth ( width );
        this.setHeight ( height );
        this.setArea ();
    }

    private void setWidth(double width) {
        this.width = width;
    }
    private void setHeight(double height) {
        this.height = height;
    }
    private void setArea ( ) {
        this.area = ShapesMathOperations.calculateRectangleArea ( this.getWidth (), this.getHeight () );
    }
    public double getHeight() {
        return this.height;
    }
    public double getWidth() {
        return this.width;
    }
    @Override
    public double getArea() {
       return this.area;
    }
}
