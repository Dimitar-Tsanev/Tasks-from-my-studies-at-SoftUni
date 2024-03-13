package solidLab.p05_DependencyInversion.p01_HelloWord;

public class Main {
    public static void main(String[] args) {
        Greeter greeter = new HelloWorld ( "Stamat" );

        System.out.println (greeter.greeting () );
    }
}
