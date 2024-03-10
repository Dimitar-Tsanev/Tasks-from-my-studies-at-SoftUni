package solidLab.p01_SingleResponsibility.p01_DrawingShape.repositories.interfaces;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderable;

import java.util.Collection;

public interface RendersRepository {
    Collection<Renderable> getRenderers();

}
