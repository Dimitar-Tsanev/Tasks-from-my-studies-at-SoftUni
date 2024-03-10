package solidLab.p01_SingleResponsibility.p01_DrawingShape.geometric_figures.circle;

class CircleMathOperations {
    private CircleMathOperations (){

    }
    static double calculateCircleArea (double radius ){
        return Math.PI * Math.pow ( radius, 2 );
    }
}
