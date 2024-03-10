package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.drawing_manager.DrawingManagerImpl;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.drawing_manager.DrawingManagerMultiple;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.drawing_manager.interfaces.DrawingManager;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.geometric_figures.circle.Circle;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.geometric_figures.rectangle.Rectangle;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderable;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.repositories.RendersRepositoryImpl;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.repositories.interfaces.RendersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) throws ClassNotFoundException {
        Scanner scanner = new Scanner ( System.in );

        String input;

        List<Shape> shapes = new ArrayList<> ( );
        List<Renderable> renderables = new ArrayList<> ( );

        while (!"end".equals ( input = scanner.nextLine ( ) )) {
            String[] data = input.split ( "\\s+" );

            switch (data[0]) {
                case "Circle":
                    Circle circle = new Circle ( Double.parseDouble ( data[1] ) );
                    shapes.add ( circle );
                    renderables.add ( circle );
                    break;

                case "Rectangle":
                    Rectangle rectangle = new Rectangle ( Double.parseDouble ( data[1] ), Double.parseDouble ( data[2] ) );
                    shapes.add ( rectangle );
                    renderables.add ( rectangle );
                    break;
            }
        }
        RendersRepository rendersRepository = new RendersRepositoryImpl ( renderables );

        DrawingManagerMultiple drawingManagerMultiple = new DrawingManagerMultiple ( rendersRepository );
        DrawingManager drawingManager = new DrawingManagerImpl ( renderables.get ( 0 ) );

        drawingManager.draw ( );

        drawingManagerMultiple.drawAll ( );
        drawingManagerMultiple.draw ( );
        drawingManagerMultiple.draw ( );
        shapes.forEach ( s -> System.out.printf ( "%s area is %.2f%n", s.getClass ( ).getSimpleName ( ), s.getArea ( ) ) );
    }
}
