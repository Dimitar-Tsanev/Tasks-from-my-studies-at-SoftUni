package hero;

class Hero {
    private String username;
    private int level;

    public Hero ( String username, int level ) {
        this.setUsername ( username );
        this.setLevel ( level );

    }

    private void setUsername ( String username ) {
        this.username = username;
    }

    private void setLevel ( int level ) {
        this.level = level;
    }

    public String getUsername () {
        return this.username;
    }

    public int getLevel () {
        return this.level;
    }

    @Override
    public String toString () {
        return String.format ( "Type: %s Username: %s Level: %s",this.getClass ().getName (), getUsername (),getLevel () );
    }
}
