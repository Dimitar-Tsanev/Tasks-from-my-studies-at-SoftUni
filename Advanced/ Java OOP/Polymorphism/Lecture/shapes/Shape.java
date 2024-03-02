package shapes;

abstract class Shape {
    private Double perimeter;
    private Double area;

    protected void setPerimeter ( Double perimeter ) {
        this.perimeter = perimeter;
    }

    protected void setArea ( Double area ) {
        this.area = area;
    }

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();

    public Double getPerimeter () {
        return this.perimeter;
    }

    public Double getArea () {
        return this.area;
    }
}
