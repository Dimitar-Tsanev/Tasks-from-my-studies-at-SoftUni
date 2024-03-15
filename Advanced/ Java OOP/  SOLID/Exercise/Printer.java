import calculators.Calculator;

public class Printer {
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    private Printer () {
    }

    public static void printSum( Calculator calculator) {
        System.out.printf((SUM) + "%n", calculator.sum ());
    }

    public static void printAverage(Calculator calculator ) {
        System.out.printf((AVERAGE) + "%n", calculator.average ());
    }
}
