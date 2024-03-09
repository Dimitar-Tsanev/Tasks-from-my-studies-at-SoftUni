package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;

import java.util.Collections;
import java.util.List;

class DrawingRepositoryImpl implements DrawingRepository {

    private List<Renderer> shapesRenders;

    public DrawingRepositoryImpl ( List<Renderer> shapesRenders ) {
        this.setShapes ( shapesRenders );
    }

    private void setShapes ( List<Renderer> renderers ) {
        if ( renderers == null || renderers.isEmpty () ){
            throw new IllegalArgumentException ( "Repository need at least one shape!" );
        }
        this.shapesRenders = renderers;
    }
    @Override
    public List<Renderer> getRenderers () {
        return Collections.unmodifiableList ( this.shapesRenders );
    }

}
