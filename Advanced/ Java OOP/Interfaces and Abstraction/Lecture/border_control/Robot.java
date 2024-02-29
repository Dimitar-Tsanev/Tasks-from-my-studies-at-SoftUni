package border_control;

class Robot implements Identifiable{
    private String model;
    private String id;

    public Robot (  String model, String id ) {
        this.setModel ( model );
        this.setId ( id );

    }

    private void setId ( String id ) {
        this.id = id;
    }

    private void setModel ( String model ) {
        this.model = model;
    }

    @Override
    public String getId () {
        return this.id;
    }

    public String getModel () {
        return this.model;
    }
}
