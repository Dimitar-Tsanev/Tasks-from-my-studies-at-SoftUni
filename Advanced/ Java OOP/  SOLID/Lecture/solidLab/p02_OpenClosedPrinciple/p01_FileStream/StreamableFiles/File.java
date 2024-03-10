package solidLab.p02_OpenClosedPrinciple.p01_FileStream.StreamableFiles;

import solidLab.p02_OpenClosedPrinciple.p01_FileStream.StreamableFiles.interfaces.Streamable;

public class File implements Streamable {
    private String name;

    private int length;

    private int sent;

    public File ( String name, int length ) {
        this.setName ( name);
        this.setLength (length);
        this.setSent ( 0 );
    }

    public String getName () {
        return this.name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    @Override
    public int getLength () {
        return this.length;
    }

    private void setLength ( int length ) {
        this.length = length;
    }

    @Override
    public int getSent () {
        int sent = this.sent;

        if (sent < this.length) {
            this.setSent ( ++this.sent );
        }
        return sent;
    }

    private void setSent ( int sent ) {
        this.sent = sent;
    }
}
