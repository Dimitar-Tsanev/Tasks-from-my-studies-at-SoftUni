package solidLab.p02_OpenClosedPrinciple.p01_FileStream.StreamableFiles;

public class Music extends File {
    private String Artist;

    private String Album;

    public Music ( String name, int length ) {
        super ( name, length);
    }

    public String getArtist() {
        return this.Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getAlbum() {
        return this.Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }
}
