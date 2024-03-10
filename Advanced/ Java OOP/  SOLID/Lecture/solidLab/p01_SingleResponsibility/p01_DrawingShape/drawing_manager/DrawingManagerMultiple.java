package solidLab.p01_SingleResponsibility.p01_DrawingShape.drawing_manager;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.drawing_manager.interfaces.DrawingManager;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderable;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.repositories.interfaces.RendersRepository;

import java.util.ArrayDeque;
import java.util.Deque;

public class DrawingManagerMultiple implements DrawingManager {
    private Deque<Renderable> renderablesQueue;

    public DrawingManagerMultiple ( RendersRepository rendersRepository ) {
        this.setRendersRepository ( rendersRepository );
    }

    private void setRendersRepository ( RendersRepository rendersRepository ) {
        for ( Renderable renderable : rendersRepository.getRenderers ( ) ) {
            if ( renderable == null ) {
                throw new IllegalArgumentException ( "Missing Figure in the repository!" );
            }
            if (renderablesQueue == null){
                this.renderablesQueue = new ArrayDeque<> (  );
            }
            this.renderablesQueue.offer ( renderable );
        }
    }

    public void drawAll () {
        for ( int i = 0 ; i < this.renderablesQueue.size () ; i++ ) {
            draw ();
        }
    }

    @Override
    public void draw () {
        if ( renderablesQueue == null || renderablesQueue.isEmpty ( ) ) {
            throw new IllegalArgumentException ( "Nothing to draw!" );

        }
        Renderable renderable = renderablesQueue.poll ();
        renderablesQueue.offer ( renderable );
        System.out.println ( renderable.render ( ) );
    }
}
