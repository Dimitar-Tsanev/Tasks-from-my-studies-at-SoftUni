package ferrari;

class Ferrari implements Car{
    private static final String MODEL = "488-Spider";
    private String driverName;
    private String model;

    public Ferrari ( String driverName ) {
        this.setDriverName ( driverName );
        this.setModel ( );
    }

    private void setDriverName ( String driverName ) {
        this.driverName = driverName;
    }

    private void setModel ( ) {
        this.model = MODEL;
    }

    public String getDriverName () {
        return this.driverName;
    }

    public String getModel () {
        return this.model;
    }

    @Override
    public String brakes () {
        return "Brakes!";
    }

    @Override
    public String gas () {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString () {
        return String.format ( "%s/%s/%s/%s",
                this.getModel (),
                this.brakes (),
                this.gas (),
                this.getDriverName () );
    }
}
