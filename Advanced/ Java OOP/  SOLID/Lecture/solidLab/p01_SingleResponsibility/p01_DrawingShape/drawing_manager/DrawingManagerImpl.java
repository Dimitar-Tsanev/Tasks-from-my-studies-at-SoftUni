package solidLab.p01_SingleResponsibility.p01_DrawingShape.drawing_manager;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.drawing_manager.interfaces.DrawingManager;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderable;

public class DrawingManagerImpl implements DrawingManager {
    private Renderable renderable;
    public DrawingManagerImpl ( Renderable renderable ) {
        this.setRenderable ( renderable );
    }
    private void setRenderable ( Renderable renderable) {
        if (renderable == null){
            throw new IllegalArgumentException ( "Missing figure!" );
        }
        this.renderable = renderable;
    }

    @Override
    public void draw() {
        System.out.println ( this.renderable.render ());
    }
}
