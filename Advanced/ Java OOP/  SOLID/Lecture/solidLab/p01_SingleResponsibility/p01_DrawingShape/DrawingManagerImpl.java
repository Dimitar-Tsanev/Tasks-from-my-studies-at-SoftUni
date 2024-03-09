package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;

class DrawingManagerImpl implements DrawingManager {

    private final DrawingRepository drawingRepository;

    public DrawingManagerImpl(DrawingRepository drawingRepository) {
        this.drawingRepository = drawingRepository;
    }

    @Override
    public void draw() {
        for ( Renderer renderer: drawingRepository.getRenderers ()){
            System.out.println (renderer.render() );
        }
    }
}
