package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

import solidLab.p02_OpenClosedPrinciple.p01_FileStream.StreamableFiles.interfaces.Streamable;

public class Progress {
    private final Streamable streamable;

    public Progress (Streamable streamable)
    {
        this.streamable = streamable;
    }

    public int getCurrentPercent()
    {
        return this.streamable.getSent() * 100 / this.streamable.getLength();
    }
}
