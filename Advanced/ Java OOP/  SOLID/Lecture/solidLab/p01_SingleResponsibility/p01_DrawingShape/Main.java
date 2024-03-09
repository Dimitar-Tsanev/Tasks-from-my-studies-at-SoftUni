package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input;

        List<Shape> shapes = new ArrayList<> ();
        List<Renderer> renderers = new ArrayList<> ();

        while (!"end".equals (input = scanner.nextLine ())){
            double[] rectangleParameters = Arrays.stream ( input.split ( "\\s+" ) )
                    .mapToDouble ( Double::parseDouble )
                    .toArray ();

            Rectangle rectangle = new Rectangle ( rectangleParameters[0], rectangleParameters[1] );

            shapes.add ( rectangle );
            renderers.add ( rectangle );
        }
        DrawingRepositoryImpl drawings = new DrawingRepositoryImpl ( renderers );
        DrawingManagerImpl drawingManager = new DrawingManagerImpl ( drawings );
        drawingManager.draw ();
        shapes.forEach ( s-> System.out.println (s.getArea () ) );
    }
}
