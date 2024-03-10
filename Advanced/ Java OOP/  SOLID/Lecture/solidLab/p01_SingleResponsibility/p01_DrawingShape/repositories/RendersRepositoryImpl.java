package solidLab.p01_SingleResponsibility.p01_DrawingShape.repositories;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderable;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.repositories.interfaces.RendersRepository;

import java.util.Collection;
import java.util.Collections;

public class RendersRepositoryImpl implements RendersRepository {

    private Collection<Renderable> objectRenders;

    public RendersRepositoryImpl ( Collection<Renderable> objectRenders ) {
        this.setObjectRendered ( objectRenders );
    }

    private void setObjectRendered ( Collection<Renderable> renderables ) {
        if ( renderables == null || renderables.isEmpty () ){
            throw new IllegalArgumentException ( "Repository need at least one shape!" );
        }
        this.objectRenders = renderables;
    }
    @Override
    public Collection<Renderable> getRenderers () {
        return Collections.unmodifiableCollection ( objectRenders );
    }

}
