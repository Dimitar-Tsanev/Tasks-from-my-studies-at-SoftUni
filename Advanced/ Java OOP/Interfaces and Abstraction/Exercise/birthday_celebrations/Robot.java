package birthday_celebrations;

class Robot implements Identifiable{
    private String id;
    private String model;

    public Robot ( String id, String model ) {
        this.setId ( id );
        this.setModel ( model );

    }

    public void setModel ( String model ) {
        this.model = model;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getModel () {
        return this.model;
    }

    @Override
    public String getId () {
        return this.id;
    }
}
